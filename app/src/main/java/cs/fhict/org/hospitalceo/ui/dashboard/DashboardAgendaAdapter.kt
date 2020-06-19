package cs.fhict.org.hospitalceo.ui.dashboard

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.list_notifications.view.*

class DashboardAgendaAdapter(private var depNotifications : ArrayList<DepartmentNotification>, val context: Context) : RecyclerView.Adapter<DashboardAgendaAdapter.DashboardAgendaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardAgendaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_notifications, parent, false)
        return DashboardAgendaViewHolder(view)
    }

    override fun getItemCount(): Int = depNotifications.size

    override fun onBindViewHolder(holder: DashboardAgendaViewHolder, position: Int) {


        var notification: DepartmentNotification = depNotifications[position]

        holder.nameTextView.text =  notification.department?.name//depNotifications[position].department?.name
        holder.bodyTextView.text = notification.body//depNotifications[position].body
        holder.dateTextView.text = notification.time.toString()

        if (notification.priority==true) {
            holder.linearLayoutPriority.setBackgroundColor(Color.RED)
        }
        else {
            holder.linearLayoutPriority.setBackgroundColor(Color.YELLOW)
        }


        // holder.bodyTextView.text = depNotifications[position].amount.toString()
        // holder.dateTextView.text =  depNotifications[position].date.toString()

    }

    class DashboardAgendaViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{

        var nameTextView: TextView = view.tvDepartmentName
        var bodyTextView : TextView = view.tvNotificationContent
        var dateTextView : TextView = view.tvTime
        var linearLayoutPriority : LinearLayout = view.linearLayoutNotification
        init {
            view.setOnClickListener (this)
        }


        override fun onClick(p0: View?) {

        }
    }

}