package cs.fhict.org.hospitalceo.ui.employees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employee_msg_item.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import cs.fhict.org.hospitalceo.data.model.EmployeeMessage
import cs.fhict.org.hospitalmanagement.R
import kotlin.collections.ArrayList


class EmployeeMessagesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private val TAG: String = "AppDebug"

    private var items: List<EmployeeMessage> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.employee_msg_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is MessageViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(msgList: List<EmployeeMessage>){
        items = msgList
    }



    class MessageViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val msg_title = itemView.message_body
      //  val msg_body = itemView.fav_emp_name;

        fun bind(employeeMessage: EmployeeMessage){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

           // Glide.with(itemView.context)
            //    .applyDefaultRequestOptions(requestOptions)
           //     .load(employeeMessage.image)
             //   .into(employeeMessage)
            msg_title.setText(employeeMessage.title)
          //  msg_body.setText(employeeMessage.body)
        }
    }
/// public interface  onMessageListener{
//    fun  onClickLinstener(int position) {

    //   }

}