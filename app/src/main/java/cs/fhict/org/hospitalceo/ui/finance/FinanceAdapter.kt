package cs.fhict.org.hospitalceo.ui.finance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.EmployeeMessage
import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.employee_msg_item.view.*

class FinanceAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private val TAG: String = "AppDebug"

    private var items: List<Finance> = ArrayList()

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
        val msg_body = itemView.employee_name

        fun bind(employeeMessage: EmployeeMessage){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            // Glide.with(itemView.context)
            //    .applyDefaultRequestOptions(requestOptions)
            //     .load(employeeMessage.image)
            //   .into(employeeMessage)
            msg_title.setText(employeeMessage.title)
            msg_body.setText(employeeMessage.body)
        }
    }
/// public interface  onMessageListener{
//    fun  onClickLinstener(int position) {

//   }

