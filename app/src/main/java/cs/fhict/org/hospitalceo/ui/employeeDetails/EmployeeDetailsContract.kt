package cs.fhict.org.hospitalceo.ui.employeeDetails
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface EmployeeDetailsContract {

    interface View : IBaseFragment {
    }

    interface Presenter : IBasePresenter<View> {
        fun getEmployee();
        fun onViewLoaded();
    }
}
