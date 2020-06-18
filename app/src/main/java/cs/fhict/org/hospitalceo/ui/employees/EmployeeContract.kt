package cs.fhict.org.hospitalceo.ui.employees

import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface EmployeeContract {

    interface View : IBaseFragment {
        fun goToEmployeeDetails(empId:Int);
        fun showFavouriteEmployees(emps : ArrayList<Employee>)
        fun showMessagesEmployees(emps: ArrayList<Employee>)
    }

    interface Presenter : IBasePresenter<View> {
        //counter of items (notifications)
        fun getFavouriteEmployees()
        fun getMessagesEmployees()
        val itemCount: Int

        //starts a new Activity when item clicked
        fun onItemClicked(pos: Int)
        fun onBindItemView(itemView: ItemView, pos: Int)
    }

    //ItemView
    interface ItemView {
        fun bindItem(item: Employee)
    }
}