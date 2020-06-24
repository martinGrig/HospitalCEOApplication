package cs.fhict.org.hospitalceo.ui.employees

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalceo.ui.employeeDetails.EmployeeDetailsActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.employee_fav_item.view.*
import kotlinx.android.synthetic.main.finance_list.view.*


class FavouriteContactsAdapter(private var favourites : ArrayList<Employee>, var context: Context) : RecyclerView.Adapter<FavouriteContactsAdapter.FavouriteContactsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteContactsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_fav_item, parent, false)
        return FavouriteContactsViewHolder(view)
    }

    override fun getItemCount(): Int =   favourites!!.size

    override fun onBindViewHolder(holder: FavouriteContactsViewHolder, position: Int) {

        val employee : Employee = favourites[position]

        holder.employeeNameTextView.text = employee.name_first
        //holder.imageEmployee
        holder.id = employee.id.toString()
    }

    class FavouriteContactsViewHolder(itemView : View ) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{

        var employeeNameTextView: TextView = itemView.employee_name
        var imageEmployee : ImageView = itemView.imageViewProfileEmployee
        var id: String = itemView.Id.text as String


        init {
            itemView.setOnClickListener (this)
            }

        override fun onClick(p0: View?) {
            val intent : Intent = Intent(p0?.context, EmployeeDetailsActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("adapter", "Fav")
            p0?.context?.startActivity(intent)
        }
    }

}

