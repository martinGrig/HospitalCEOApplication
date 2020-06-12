package cs.fhict.org.hospitalceo.ui.finance

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import cs.fhict.org.hospitalceo.data.FinanceDataSource
import cs.fhict.org.hospitalceo.data.FinanceRepository
import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.FinanceRemoteDataSource
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.fragment_finance.view.*
import kotlinx.android.synthetic.main.fragment_finance.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FinancesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FinancesFragment : Fragment(), OnChartValueSelectedListener, FinanceContract.View {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var presenter : FinancePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            /*patientsChart.setUsePercentValues(true)
            patientsChart.description.isEnabled = false;
            patientsChart.setNoDataText("No Patients Found")
            patientsChart.setExtraOffsets(5F, 10F, 5F, 5F)
            patientsChart.setDrawEntryLabels(true)

            patientsChart.setDrawMarkers(true)
            patientsChart.isHighlightPerTapEnabled = true
            patientsChart.legend.isEnabled = true
            patientsChart.legend.horizontalAlignment
            patientsChart.legend.textSize = 18f
            patientsChart.legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            patientsChart.legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
            patientsChart.legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            patientsChart.legend.setDrawInside(false);
            patientsChart.legend.form = Legend.LegendForm.CIRCLE
            patientsChart.legend.formSize = 20f
            patientsChart.legend.setXEntrySpace(15f)
            patientsChart.dragDecelerationFrictionCoef = 0.95F
            patientsChart.animateY(1000, Easing.EaseInOutCubic)

            patientsChart.isDrawHoleEnabled = true
            patientsChart.setHoleColor(Color.WHITE)
            patientsChart.holeRadius = 60F
            patientsChart.transparentCircleRadius = 47F
            patientsChart.setDrawCenterText(true)

            val yValues = mutableListOf<PieEntry>()
            //Add values to the pie chart
            var financeList =
            yValues.add(PieEntry(30f, "Expenses"))
            yValues.add(PieEntry(30f, "Profit"))
            yValues.add(PieEntry(40f, "Insurance"))

            val dataSet = PieDataSet(yValues, "")
            dataSet.valueFormatter = PercentFormatter(patientsChart)
            dataSet.sliceSpace = 3f
            dataSet.selectionShift = 5f
            val colorPal = mutableListOf(Color.parseColor("#00AFD4"),
                Color.parseColor("#F0524F"),
                Color.parseColor("#F07D00")
            )
            dataSet.colors = colorPal

            val data = PieData(dataSet)
            data.setValueTextSize(15f)
            data.setValueTextColor(Color.WHITE)
            patientsChart.setDrawSliceText(false)
            patientsChart.setUsePercentValues(true)

            patientsChart.data = data
*/
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        presenter = FinancePresenter(FinanceRepository(FinanceRemoteDataSource().getInstance()))
        presenter?.onViewActive(this)
        // Inflate the layout for this fragment
        presenter?.getFinances()
        return inflater.inflate(R.layout.fragment_finance, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FinancesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FinancesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onStart() {
        presenter?.onViewActive(this)
        super.onStart()
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        if (e ==null) return
        e as PieEntry
        //This will show different recycle views below the chart with only the selected patients
        if (e.label =="Profit")
        {}
        if (e.label =="Expenses")
        {}
        if (e.label =="Insurance")
        {}
    }
    override fun onNothingSelected() {
        return
    }

    override fun showFinances(fins: ArrayList<Finance>) {
        view?.rvFinances?.layoutManager = LinearLayoutManager(view?.context)
        view?.rvFinances?.adapter = FinanceAdapter(fins)

        view?.rvFinances?.adapter?.notifyDataSetChanged()
    }

    override fun setPieChart(fin: Finance) {
        patientsChart.setUsePercentValues(true)
        patientsChart.description.isEnabled = false;
        patientsChart.setNoDataText("No Patients Found")
        patientsChart.setExtraOffsets(5F, 10F, 5F, 5F)
        patientsChart.setDrawEntryLabels(true)

        patientsChart.setDrawMarkers(true)
        patientsChart.isHighlightPerTapEnabled = true
        patientsChart.legend.isEnabled = true
        patientsChart.legend.horizontalAlignment
        patientsChart.legend.textSize = 18f
        patientsChart.legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        patientsChart.legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        patientsChart.legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        patientsChart.legend.setDrawInside(false);
        patientsChart.legend.form = Legend.LegendForm.CIRCLE
        patientsChart.legend.formSize = 20f
        patientsChart.legend.setXEntrySpace(15f)
        patientsChart.dragDecelerationFrictionCoef = 0.95F
        patientsChart.animateY(1000, Easing.EaseInOutCubic)

        patientsChart.isDrawHoleEnabled = true
        patientsChart.setHoleColor(Color.WHITE)
        patientsChart.holeRadius = 60F
        patientsChart.transparentCircleRadius = 47F
        patientsChart.setDrawCenterText(true)

        val yValues = mutableListOf<PieEntry>()
        //Add values to the pie chart
        var financeCosts: Float = fin.costs.today.toFloat()
        var financeIncome: Float = fin.income.today.toFloat()
        var financeInsurance: Float = fin.new_insurance_contracts.today.toFloat()
        yValues.add(PieEntry(financeCosts, "Expenses"))
        yValues.add(PieEntry(financeIncome, "Profit"))
        yValues.add(PieEntry(financeInsurance, "Insurance"))

        val dataSet = PieDataSet(yValues, "")
        dataSet.valueFormatter = PercentFormatter(patientsChart)
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f
        val colorPal = mutableListOf(Color.parseColor("#00AFD4"),
            Color.parseColor("#F0524F"),
            Color.parseColor("#F07D00")
        )
        dataSet.colors = colorPal

        val data = PieData(dataSet)
        data.setValueTextSize(15f)
        data.setValueTextColor(Color.WHITE)
        patientsChart.setDrawSliceText(false)
        patientsChart.setUsePercentValues(true)

        patientsChart.data = data

    }

    override fun ShowToast(message: String?) {
        TODO("Not yet implemented")
    }

}
