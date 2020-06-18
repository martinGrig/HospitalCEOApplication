package cs.fhict.org.hospitalceo.ui.dashboard

import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface DashboardContract {

    interface View : IBaseFragment {
        fun goToDepartmentDetails();
        fun showDepartmentNotifications(depNotifications : ArrayList<Department>)
    }


    interface Presenter : IBasePresenter<View> {
      fun getDepartments()

    }
}