package cs.fhict.org.hospitalceo.ui.department

import cs.fhict.org.hospitalceo.data.model.Bed
import cs.fhict.org.hospitalceo.utils.mvp.IBaseActivity
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface DepartmentContract {
    interface View : IBaseActivity{

    }
    interface ItemView {
        fun bindItem(item: Bed)
    }

    interface Presenter : IBasePresenter<View>{
        //counter of items
        val itemCount: Int
        //starts a new Activity when item clicked
        fun onItemClicked(pos: Int)
        fun onBindItemView(itemView: ItemView, pos: Int)
    }
}