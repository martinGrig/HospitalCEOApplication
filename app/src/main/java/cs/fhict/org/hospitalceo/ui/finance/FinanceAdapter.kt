package cs.fhict.org.hospitalceo.ui.finance

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.finance_list.view.*

class FinanceAdapter(private var finances : ArrayList<Expense>,val context: Context) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.finance_list, parent, false)
        return FinanceViewHolder(view)
    }

    override fun getItemCount(): Int = finances.size

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {

        holder.nameTextView.text = finances[position].title
        holder.bodyTextView.text = "€ " + finances[position].amount.toString()
        holder.dateTextView.text = android.text.format.DateFormat.format("d MMM", finances[position].date)

    }

    class FinanceViewHolder(view:View) : RecyclerView.ViewHolder(view) , View.OnClickListener{

        var nameTextView: TextView = view.expense_name
        var bodyTextView : TextView = view.expense_description
        var dateTextView : TextView = view.expense_date

        init {
            view.setOnClickListener (this)
        }


        override fun onClick(p0: View?) {

        }
    }

}