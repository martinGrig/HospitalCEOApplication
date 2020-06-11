package cs.fhict.org.hospitalceo.ui.employees

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.employee_fav_item.view.*

class FavouriteContactsAdapter(private var favourites : ArrayList<Employee>) : RecyclerView.Adapter<FavouriteContactsAdapter.FavouriteContactsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteContactsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_fav_item, parent, false)
        return FavouriteContactsViewHolder(favourites,view)
    }

    override fun getItemCount(): Int =   favourites!!.size

    override fun onBindViewHolder(holder: FavouriteContactsViewHolder, position: Int) {
        //presenter?.onBindItemView(holder, position)

        Log.d("SIZE SSS", favourites?.size.toString())
        favourites?.get(position).let {
            holder.bindItem(it)
        }
    }

    class FavouriteContactsViewHolder(private var favourites : ArrayList<Employee>,itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView),EmployeeContract.ItemView{

        var nameTextView: TextView = itemLayoutView.fav_emp_name

        init {
            itemLayoutView.setOnClickListener {
              //  presenter?.onItemClicked(adapterPosition)

                val emp = favourites?.get(adapterPosition)//favouriteEmployees?.get(pos)
              //  emp?.id?.let { itemLayoutView?.goToEmployeeDetails(it) }

            }
        }
        override fun bindItem(item: Employee) {
            Log.d("NAME AND JOB", item.name_first + item.job)
            nameTextView.text = item.name_first
        }
    }

}