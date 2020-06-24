package cs.fhict.org.hospitalceo.ui.employeeDetails
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface EmployeeDetailsContract {

    interface View : IBaseFragment {
        fun updateView(employee: Employee)
    }

    interface Presenter : IBasePresenter<View> {
        fun getFavouriteEmployee(id: Int);
        fun getMessagesEmployee(id: Int)
    }
}
