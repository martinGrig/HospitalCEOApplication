package cs.fhict.org.hospitalceo.ui.department

import cs.fhict.org.hospitalceo.data.BedsRepository
import cs.fhict.org.hospitalceo.data.DepartmentDataSource
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.Bed
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import java.util.*
import kotlin.collections.ArrayList


class DepartmentPresenter(var departmentRepository: DepartmentRepository?) : DepartmentContract.Presenter {
    var view: DepartmentContract.View? = null;

    override fun getDepartment(id: Int) {
        departmentRepository?.getDepartment(id,object :DepartmentDataSource.LoadDepartmentCallBack{
            override fun onDepartmentLoaded(department: Department) {

                view?.updateView(department)

            }

            override fun onDataNotAvailable() {
                view?.ShowToast("Data not available")
            }

            override fun onError(t: Throwable) {
                view?.ShowToast(t.message)
            }
        })
    }

    override fun onViewActive(view: DepartmentContract.View) {
        this.view = view
    }

    override fun onViewInactive() {
        this.view = null
    }
}