package cs.fhict.org.hospitalceo.ui.employees

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cs.fhict.org.hospitalceo.data.EmployeeRepository
import cs.fhict.org.hospitalceo.data.employeesLocal.EmployeeLocalRepository
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.EmployeeRemoteDataSource
import cs.fhict.org.hospitalceo.ui.employeeDetails.EmployeeDetailsActivity
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.fragment_employee.*
import kotlinx.android.synthetic.main.fragment_employee.view.*
import kotlin.collections.ArrayList

class EmployeeFragment : Fragment(), EmployeeContract.View {

    var presenter : EmployeePresenter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view : View = inflater.inflate(R.layout.fragment_employee, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = EmployeePresenter(EmployeeRepository(EmployeeRemoteDataSource().getInstance()), EmployeeLocalRepository())
        presenter?.onViewActive(this)
        // Inflate the layout for this fragment
        presenter?.getFavouriteEmployees()
        presenter?.getMessagesEmployees()
    }

    override fun onStart() {
        presenter?.onViewActive(this)
        super.onStart()
    }

    override fun goToEmployeeDetails(empId: Int) {
       Log.d("TAG DO", "DOOOOOO")
    }

    override fun showFavouriteEmployees(emps: ArrayList<Employee>) {
        view?.recFavEmp?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, true)
        view?.recFavEmp?.adapter = view?.context?.let { FavouriteContactsAdapter(emps, it) }

        view?.recFavEmp?.adapter?.notifyDataSetChanged()
    }

    override fun showMessagesEmployees(emps: ArrayList<Employee>) {
        Log.d("EMPTY", emps.size.toString())

        view?.msg_recycler_view?.layoutManager = LinearLayoutManager(activity)
        view?.msg_recycler_view?.adapter = view?.context?.let { EmployeeMessagesAdapter(emps, it)}

        view?.msg_recycler_view?.adapter?.notifyDataSetChanged()
    }


    override fun ShowToast(message: String?) {
       Toast.makeText(view?.context,message,Toast.LENGTH_LONG).show()
    }


}