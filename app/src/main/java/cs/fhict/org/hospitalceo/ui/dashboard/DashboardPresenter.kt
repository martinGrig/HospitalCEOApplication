package cs.fhict.org.hospitalceo.ui.dashboard

import cs.fhict.org.hospitalceo.data.BedDataSource
import cs.fhict.org.hospitalceo.data.BedsRepository
import cs.fhict.org.hospitalceo.data.DepartmentDataSource
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.BedRemoteDataSource

class DashboardPresenter(depRep : DepartmentRepository) : DashboardContract.Presenter {

    var view : DashboardContract.View? = null
    var depRep : DepartmentRepository? = depRep;


    override fun getDepartments() {
     depRep?.getDepartments(object : DepartmentDataSource.LoadDepartmentsCallBack{
         override fun onDepartmentsLoaded(departmentList: ArrayList<Department>) {

           view?.showDepartmentNotifications(departmentList)
         }

         override fun onDataNotAvailable() {

         }

         override fun onError(t: Throwable) {
           view?.ShowToast(t.message)
         }

     })
    }


    override fun onViewActive(view: DashboardContract.View) {
        this.view = view;
    }

    override fun onViewInactive() {
        this.view = null;
    }

}