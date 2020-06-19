package cs.fhict.org.hospitalceo.ui.dashboard

import android.util.Log
import cs.fhict.org.hospitalceo.data.BedDataSource
import cs.fhict.org.hospitalceo.data.BedsRepository
import cs.fhict.org.hospitalceo.data.DepartmentDataSource
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.BedRemoteDataSource
import java.util.*
import kotlin.collections.ArrayList

class DashboardPresenter(depRep : DepartmentRepository) : DashboardContract.Presenter {

    var view : DashboardContract.View? = null
    var depRep : DepartmentRepository? = depRep;


    override fun getDepartments() {
     depRep?.getDepartments(object : DepartmentDataSource.LoadDepartmentsCallBack{
         override fun onDepartmentsLoaded(departmentList: ArrayList<Department>) {
             val notifications : ArrayList<DepartmentNotification> = ArrayList()

             departmentList.forEach {

                 depRep?.getDepartment(it.id!!.toInt(),object :DepartmentDataSource.LoadDepartmentCallBack{
                     override fun onDepartmentLoaded(department: Department) {


                         Log.d("BERTER",department.name)

                         if (department.beds?.size!! < department.patients?.size!!) {
                             val negativeNumber = department.patients.size - department.beds.size
                             notifications.add(
                                 DepartmentNotification(
                                     department.id.toString(), department,
                                     "$negativeNumber beds are needed ", Date(), true
                                 )
                             )
                         } else if (department.beds?.size!! == department.patients?.size!!) {
                             notifications.add(
                                 DepartmentNotification(
                                     department.id.toString(), department,
                                     "There are no more  beds", Date(), true
                                 )
                             )
                         } else if (department.beds?.size!! > department.patients?.size!!) {
                             val positiveDifferece = department.beds.size - department.patients.size

                             if (positiveDifferece < 10) {
                                 notifications.add(
                                     DepartmentNotification(
                                         department.id.toString(),
                                         department,
                                         "$positiveDifferece  beds before limit is reached",
                                         Date(),
                                         false
                                     )
                                 )
                             }

                         }


//                         var countPatientNeedBeds = 0;
//                         department.patients?.forEach {
//                             if (it.bed_needed==true) {
//                                 countPatientNeedBeds++
//                                 notifications.add(DepartmentNotification(department.id.toString(),department,
//                                     "${countPatientNeedBeds} patients need bed now ", Date(),true))
//                             }
//                         }

                         Log.d("DOPE",notifications.size.toString())
                         notifications.forEach {
                             Log.d("TOPE",it.body)
                         }
                         view?.showDepartmentNotifications(notifications)

                     }

                     override fun onDataNotAvailable() {

                     }

                     override fun onError(t: Throwable) {

                     }

                 })
             }


         }

         override fun onDataNotAvailable() {

         }

         override fun onError(t: Throwable) {
           view?.ShowToast(t.message)
         }

     })
    }

    override fun getDepartment(id: Int) {
        depRep?.getDepartment(id,object :DepartmentDataSource.LoadDepartmentCallBack{
            override fun onDepartmentLoaded(department: Department) {
                val notifications : ArrayList<DepartmentNotification> = ArrayList()
                //view?.ShowToast(departmentList[0].name)
                Log.d("DEPARTMENT", department.beds?.size.toString())

                if (department.beds?.size!! >= department.patients?.size!!) {
                    var negativeNumber = department.patients.size - department.beds.size
                     notifications.add(DepartmentNotification(department.id.toString(),department,
                         "$negativeNumber beds are needed ", Date(),true))
                }

               // view?.showDepartmentNotifications(notifications)
            }

            override fun onDataNotAvailable() {

            }

            override fun onError(t: Throwable) {

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