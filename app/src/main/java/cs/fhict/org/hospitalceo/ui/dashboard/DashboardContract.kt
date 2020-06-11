package cs.fhict.org.hospitalceo.ui.dashboard

import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface DashboardContract {

    interface View : IBaseFragment {
        fun goToDepartmentDetails();
    }

    //ItemView
    interface ItemView {
        fun bindItem(item: Department)
    }

    interface Presenter : IBasePresenter<View> {
        //counter of items (notifications)
        val itemCount: Int
        //starts a new Activity when item clicked
        fun onItemClicked(pos: Int)
        fun onBindItemView(itemView: ItemView, pos: Int)
    }
}