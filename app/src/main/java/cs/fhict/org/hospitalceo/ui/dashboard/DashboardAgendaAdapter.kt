package cs.fhict.org.hospitalceo.ui.dashboard

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.AgendaNotification
import cs.fhict.org.hospitalceo.data.model.AgendaType
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.ui.department.DepartmentActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.list_agenda.view.*
import kotlinx.android.synthetic.main.list_notifications.view.*

class DashboardAgendaAdapter(private var agendaNotifications : ArrayList<AgendaNotification>, val context: Context) : RecyclerView.Adapter<DashboardAgendaAdapter.DashboardAgendaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardAgendaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_agenda, parent, false)
        return DashboardAgendaViewHolder(view,context)
    }

    override fun getItemCount(): Int = agendaNotifications.size

    override fun onBindViewHolder(holder: DashboardAgendaViewHolder, position: Int) {


        val agendaNotification: AgendaNotification = agendaNotifications[position]

        if (agendaNotification.type == AgendaType.BIRTHDAY) {

            holder.imageViewAgenda.setBackgroundResource(R.drawable.cake)
        }
        else if(agendaNotification.type == AgendaType.EQUIPMENT) {
            holder.imageViewAgenda.setBackgroundResource(R.drawable.medical)
        }
        else {
            holder.imageViewAgenda.setBackgroundResource(R.drawable.department)
        }

        holder.nameTextView.text =  agendaNotification.type.toString()
        holder.bodyTextView.text = agendaNotification.body
        holder.dateTextView.text = android.text.format.DateFormat.format("d MMM", agendaNotification.time).toString() //notification.time.toString()

    }

    class DashboardAgendaViewHolder(view: View,context: Context) : RecyclerView.ViewHolder(view) , View.OnClickListener{

        val context : Context?= context

        var imageViewAgenda : ImageView = view.imageViewAgenda
        var nameTextView: TextView = view.tvAgendaTitle
        var bodyTextView : TextView = view.tvAgendaBody
        var dateTextView : TextView = view.tvAgendaTime
        init {
            view.setOnClickListener (this)
        }


        override fun onClick(p0: View?) {


        }
    }

}