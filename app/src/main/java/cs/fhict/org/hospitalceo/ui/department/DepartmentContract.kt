package cs.fhict.org.hospitalceo.ui.department

import cs.fhict.org.hospitalceo.data.model.Bed
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.utils.mvp.IBaseActivity
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface DepartmentContract {
    interface View : IBaseActivity{
        fun updateView(department:Department)

    }


    interface Presenter : IBasePresenter<View>{
        fun getDepartment(id:Int)
    }
}