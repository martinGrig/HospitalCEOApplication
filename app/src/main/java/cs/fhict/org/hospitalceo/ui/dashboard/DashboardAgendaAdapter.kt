package cs.fhict.org.hospitalceo.ui.dashboard

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.ui.department.DepartmentActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.list_agenda.view.*
import kotlinx.android.synthetic.main.list_notifications.view.*

class DashboardAgendaAdapter(private var depNotifications : ArrayList<DepartmentNotification>, val context: Context) : RecyclerView.Adapter<DashboardAgendaAdapter.DashboardAgendaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardAgendaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_agenda, parent, false)
        return DashboardAgendaViewHolder(view,context)
    }

    override fun getItemCount(): Int = depNotifications.size

    override fun onBindViewHolder(holder: DashboardAgendaViewHolder, position: Int) {


        var notification: DepartmentNotification = depNotifications[position]

        holder.nameTextView.text =  notification.department?.name//depNotifications[position].department?.name
        holder.bodyTextView.text = notification.body//depNotifications[position].body
       // holder.dateTextView.text = notification.time.toString()




        // holder.bodyTextView.text = depNotifications[position].amount.toString()
        // holder.dateTextView.text =  depNotifications[position].date.toString()

    }

    class DashboardAgendaViewHolder(view: View,context: Context) : RecyclerView.ViewHolder(view) , View.OnClickListener{

        val context : Context?= context

        var nameTextView: TextView = view.tvAgendaTitle
        var bodyTextView : TextView = view.tvAgendaBody
        //var dateTextView : TextView = view.tvTime
        init {
            view.setOnClickListener (this)
        }


        override fun onClick(p0: View?) {


        }
    }

}