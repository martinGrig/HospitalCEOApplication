package cs.fhict.org.hospitalceo.ui.dashboard

import android.view.MenuItem
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface DashboardContract {

    interface View : IBaseFragment {
        fun goToDepartmentDetails(id: Int);
        fun showDepartmentNotifications(depNotifications : ArrayList<DepartmentNotification>)
        fun showAgendaNotifications(depNotifications : ArrayList<DepartmentNotification>)
        fun setNotificationPriority(depNotifications : ArrayList<DepartmentNotification>)
    }


    interface Presenter : IBasePresenter<View> {
      fun getDepartments()
      fun getDepartment(id : Int)
      fun onSortNotifications(itemId:Int, list:  ArrayList<DepartmentNotification>)


    }
}