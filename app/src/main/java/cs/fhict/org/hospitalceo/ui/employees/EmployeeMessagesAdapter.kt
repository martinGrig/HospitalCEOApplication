package cs.fhict.org.hospitalceo.ui.employees

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.ui.employeeDetails.EmployeeDetailsActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.employee_msg_item.view.*
import java.util.*


class EmployeeMessagesAdapter(private var emps : ArrayList<Employee>, val context: Context) : RecyclerView.Adapter<EmployeeMessagesAdapter.MessageViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.employee_msg_item,
            parent,
            false)
            , context
        )
    }

    override fun getItemCount(): Int {
        return emps.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        holder.msg.text = emps[position].notification.body
        holder.empName.text = """${emps[position].name_first} ${emps[position].name_last}"""
        holder.date.text = android.text.format.DateFormat.format("d MMM HH:mm", emps[position].notification.date)
        holder.id = emps[position].id.toString()

        if(emps[position].gender.toString() == "female") holder.icon.setImageResource(R.mipmap.female_nurse)
        else holder.icon.setImageResource(R.mipmap.male_nurse)

        holder.btnCall.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Calling Dr. ${emps[position].name_last}...", Toast.LENGTH_SHORT).show()
        })

        holder.btnMsg.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Messaging Dr. ${emps[position].name_last}...", Toast.LENGTH_SHORT).show()
        })
    }

    class MessageViewHolder(itemView: View, vcontext: Context): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var msg: TextView = itemView.message_body
        var empName: TextView = itemView.employee_name
        var date: TextView = itemView.date
        var icon: ImageView = itemView.imageView
        var btnCall: Button = itemView.btnCall
        var btnMsg: Button = itemView.btnMessage
        var id: String = itemView.lblID.text as String

        init {
            itemView.setOnClickListener (this)
        }
        override fun onClick(v: View?) {
            val intent : Intent = Intent(v?.context, EmployeeDetailsActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("adapter", "Mes")
            v?.context?.startActivity(intent)
        }
    }
}