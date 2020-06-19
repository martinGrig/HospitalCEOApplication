package cs.fhict.org.hospitalceo.ui.employees

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.employee_msg_item.view.*
import java.util.*


class EmployeeMessagesAdapter(private var emps : ArrayList<Employee>, val context: Context) : RecyclerView.Adapter<EmployeeMessagesAdapter.MessageViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.employee_msg_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return emps.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        holder.msg.text = emps[position].notification.body
        holder.empName.text = """${emps[position].name_first} ${emps[position].name_last}"""
        holder.date.text = android.text.format.DateFormat.format("HH:mm", emps[position].notification.date)
        holder.icon.setImageResource(R.mipmap.head_icon_foreground)

        //holder.btnCall.setOnClickListener()
    }

    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var msg: TextView = itemView.message_body
        var empName: TextView = itemView.employee_name
        var date: TextView = itemView.date
        var icon: ImageView = itemView.imageView
        var btnCall: Button = itemView.btnCall

        init {
            itemView.setOnClickListener (this)
            //btnCall.setOnClickListener(onClick(itemView))
        }
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
}