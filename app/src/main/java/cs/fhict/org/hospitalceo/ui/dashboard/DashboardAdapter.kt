package cs.fhict.org.hospitalceo.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.finance_list.view.*
import kotlinx.android.synthetic.main.list_notifications.view.*

class DashboardAdapter(private var depNotifications : ArrayList<DepartmentNotification>, val context: Context) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_notifications, parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int = depNotifications.size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        holder.nameTextView.text = depNotifications[position].department?.name
        holder.bodyTextView.text = depNotifications[position].body
        


       // holder.bodyTextView.text = depNotifications[position].amount.toString()
       // holder.dateTextView.text =  depNotifications[position].date.toString()

    }

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{

        var nameTextView: TextView = view.tvDepartmentName
        var bodyTextView : TextView = view.tvNotificationContent
        var dateTextView : TextView = view.tvTime

        init {
            view.setOnClickListener (this)
        }


        override fun onClick(p0: View?) {

        }
    }

}