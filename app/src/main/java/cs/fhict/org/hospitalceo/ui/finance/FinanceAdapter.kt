package cs.fhict.org.hospitalceo.ui.finance

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.model.EmployeeMessage
import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.ui.employees.EmployeeContract
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.employee_fav_item.view.*
import kotlinx.android.synthetic.main.employee_msg_item.view.*
import kotlinx.android.synthetic.main.employee_msg_item.view.fav_emp_name

class FinanceAdapter(private var finances : ArrayList<Finance>) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.finance_list, parent, false)
        return FinanceViewHolder(finances,view)
    }

    override fun getItemCount(): Int =   finances!!.size

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {

        Log.d("SIZE SSS", finances?.size.toString())
        finances?.get(position).let {
            holder.bindItem(it)
        }
    }

    class FinanceViewHolder(private var finances : ArrayList<Finance>, itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView),
        FinanceContract.ItemView{

        var nameTextView: TextView = itemLayoutView.fav_emp_name

        init {
            itemLayoutView.setOnClickListener {

                val fins = finances?.get(adapterPosition)

            }
        }
        override fun bindItem(item: Finance) {
            Log.d("NAME AND JOB",  item.income.toString())
            nameTextView.text = item.costs.toString()
        }
    }

}