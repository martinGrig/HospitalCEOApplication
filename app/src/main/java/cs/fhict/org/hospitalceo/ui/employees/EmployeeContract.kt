package cs.fhict.org.hospitalceo.ui.employees

import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface EmployeeContract {

    interface View : IBaseFragment {
        fun goToEmployeeDetails(empId:Int);
        fun showFavouriteEmployees(emps : ArrayList<Employee>)
    }

    //ItemView
    interface ItemView {
        fun bindItem(item: Employee)
    }

    interface Presenter : IBasePresenter<View> {
        //counter of items (notifications)
        fun getFavouriteEmployees()
        val itemCount: Int
        //starts a new Activity when item clicked
        fun onItemClicked(pos: Int)
        fun onBindItemView(itemView: ItemView, pos: Int)
    }
}