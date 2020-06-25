package cs.fhict.org.hospitalceo.ui.dashboard

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.ui.department.DepartmentActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.list_notifications.view.*

class DashboardAdapter(
    private var depNotifications: ArrayList<DepartmentNotification>,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() { //: RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {


    private val TYPE_HOSPITAL = 1
    private val TYPE_OTHER = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?


        return if (viewType == TYPE_HOSPITAL) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.list_notifications, parent, false)
            DashboardViewHolder(view, context)

        } else { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.list_notifications, parent, false)
            DashboardOtherViewHolder(view, context)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return depNotifications.get(position).type;
    }


    override fun getItemCount(): Int = depNotifications.size


    class DashboardViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        var context: Context = context

        var nameTextView: TextView = view.tvDepartmentName
        var bodyTextView: TextView = view.tvNotificationContent
        var dateTextView: TextView = view.tvTime
        var linearLayoutPriority: LinearLayout = view.linearLayoutNotification
        var tvInvisible: TextView = view.tvIdInvisible
        var btnCall: Button = view.btnCallDashboard
        var btnNotify: Button = view.btnNotifyDashboard

        init {
            view.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            Log.d("INVISIBLE", tvInvisible.text.toString())
            val intent: Intent = Intent(p0?.context, DepartmentActivity::class.java)

            intent.putExtra("id", tvInvisible.text.toString())
            context.startActivity(intent)

        }

        fun setHospitalDetails(notification: DepartmentNotification) {

            nameTextView.text =
                notification.department?.name//depNotifications[position].department?.name
            bodyTextView.text = notification.body//depNotifications[position].body
            dateTextView.text = android.text.format.DateFormat.format(
                "d MMM HH:mm",
                notification.time
            ) //notification.time.toString()
            tvInvisible.text = notification.id
            btnCall.text = "CALL"
            btnCall.setOnClickListener {
                Toast.makeText(context, "Calling head of department.", Toast.LENGTH_LONG).show()
            }


            btnNotify.text = "NOTIFY"
            btnNotify.setOnClickListener {
                Toast.makeText(context, "Notifying head of department.", Toast.LENGTH_LONG).show()
            }
            if (notification.priority == true) {
                linearLayoutPriority.setBackgroundResource(R.color.colorRedPriority)
            } else {
                linearLayoutPriority.setBackgroundResource(R.color.colorOrangePriority)
            }
        }
    }

    class DashboardOtherViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        var context: Context = context

        //
        var nameTextView: TextView = view.tvDepartmentName
        var bodyTextView: TextView = view.tvNotificationContent
        var dateTextView: TextView = view.tvTime
        var linearLayoutPriority: LinearLayout = view.linearLayoutNotification
        var tvInvisible: TextView = view.tvIdInvisible
        var btnCall: Button = view.btnCallDashboard
        var btnNotify: Button = view.btnNotifyDashboard

        init {
            view.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {

        }

        fun setOtherDetails(notification: DepartmentNotification) {
            nameTextView.text = notification.id.toString()
            bodyTextView.text = notification.body
            dateTextView.text = android.text.format.DateFormat.format(
                "d MMM HH:mm",
                notification.time
            ) //notification.time.toString()
            btnCall.text = "GO TO ARTICLE"
            btnCall.setOnClickListener {
                Toast.makeText(context, "Going to article.", Toast.LENGTH_LONG).show()
            }
            btnNotify.text = ""
            //linearLayoutPriority


        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_HOSPITAL) {

            if (holder is DashboardViewHolder) {
                holder.setHospitalDetails(depNotifications[position])
            }

        } else {
            if (holder is DashboardOtherViewHolder) {
                holder.setOtherDetails(depNotifications[position])
            }
        }
    }

}