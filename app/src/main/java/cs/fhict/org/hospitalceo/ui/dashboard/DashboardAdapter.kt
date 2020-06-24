package cs.fhict.org.hospitalceo.ui.dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalceo.ui.department.DepartmentActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.finance_list.view.*
import kotlinx.android.synthetic.main.list_notifications.view.*

class DashboardAdapter(private var depNotifications : ArrayList<DepartmentNotification>, val context: Context) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_notifications, parent, false)
        return DashboardViewHolder(view,context)
    }

    override fun getItemCount(): Int = depNotifications.size

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {


        val notification: DepartmentNotification = depNotifications[position]

        holder.nameTextView.text =  notification.department?.name//depNotifications[position].department?.name
        holder.bodyTextView.text = notification.body//depNotifications[position].body
        holder.dateTextView.text = android.text.format.DateFormat.format("d MMM HH:mm", notification.time) //notification.time.toString()
        holder.tvInvisible.text = notification.id


        if (notification.priority==true) {
            holder.linearLayoutPriority.setBackgroundResource(R.color.colorRedPriority)
        }
        else {
            holder.linearLayoutPriority.setBackgroundResource(R.color.colorOrangePriority)
        }


    }

    class DashboardViewHolder(view: View,context: Context) : RecyclerView.ViewHolder(view) , View.OnClickListener{

        var context : Context = context

        var nameTextView: TextView = view.tvDepartmentName
        var bodyTextView : TextView = view.tvNotificationContent
        var dateTextView : TextView = view.tvTime
        var linearLayoutPriority : LinearLayout = view.linearLayoutNotification
        var tvInvisible : TextView = view.tvIdInvisible
        init {
            view.setOnClickListener (this)
        }


        override fun onClick(p0: View?) {
            Log.d("INVISIBLE" , tvInvisible.text.toString())
            val intent : Intent = Intent(p0?.context, DepartmentActivity::class.java)

            intent.putExtra("id",tvInvisible.text.toString())
            context.startActivity(intent)

        }
    }

}