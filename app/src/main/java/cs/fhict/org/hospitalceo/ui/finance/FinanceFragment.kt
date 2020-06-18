package cs.fhict.org.hospitalceo.ui.finance

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import cs.fhict.org.hospitalceo.data.FinanceRepository
import cs.fhict.org.hospitalceo.data.local.FinancesLocalRepository
import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.FinanceRemoteDataSource
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.fragment_finance.*
import kotlinx.android.synthetic.main.fragment_finance.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [FinancesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FinancesFragment : Fragment(), OnChartValueSelectedListener, FinanceContract.View {

    var presenter : FinancePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_finance, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FinancePresenter(FinanceRepository(FinanceRemoteDataSource().getInstance()),FinancesLocalRepository())
        presenter?.onViewActive(this)
        // Inflate the layout for this fragment
        presenter?.getFinances()
        presenter?.getExpensesRoom()
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

    override fun showExpenses(expenses: ArrayList<Expense>) {
        Log.d("EMPTY",expenses.size.toString())


        view?.rvFinances?.layoutManager = LinearLayoutManager(activity)
        view?.rvFinances?.adapter = view?.context?.let { FinanceAdapter(expenses, it) }

        view?.rvFinances?.adapter?.notifyDataSetChanged()
    }

    override fun ShowToast(message: String?) {
        Toast.makeText(view?.context,message,Toast.LENGTH_LONG).show()
    }


    override fun setPieChart(fin: Finance) {
        patientsChart.setUsePercentValues(true)
        patientsChart.description.isEnabled = false;
        patientsChart.setNoDataText("No Expenses Found")
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
        data.setValueTextColor(Color.BLACK)
        patientsChart.setDrawSliceText(false)
        patientsChart.setUsePercentValues(true)

        patientsChart.data = data

    }
}
