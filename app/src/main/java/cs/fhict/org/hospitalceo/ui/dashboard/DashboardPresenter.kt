package cs.fhict.org.hospitalceo.ui.dashboard

import android.util.Log
import cs.fhict.org.hospitalceo.data.DepartmentDataSource
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.AgendaNotification
import cs.fhict.org.hospitalceo.data.model.AgendaType
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalmanagement.R
import java.util.*
import kotlin.collections.ArrayList

class DashboardPresenter(depRep : DepartmentRepository) : DashboardContract.Presenter {

    var view : DashboardContract.View? = null
    var depRep : DepartmentRepository? = depRep;


    override fun getDepartments() {
     depRep?.getDepartments(object : DepartmentDataSource.LoadDepartmentsCallBack{
         override fun onDepartmentsLoaded(departmentList: ArrayList<Department>) {
             val notifications : ArrayList<DepartmentNotification> = ArrayList()
             val agenda : ArrayList<AgendaNotification> = ArrayList()

             departmentList.forEach {

                 depRep?.getDepartment(it.id!!.toInt(),object :DepartmentDataSource.LoadDepartmentCallBack{
                     override fun onDepartmentLoaded(department: Department) {


                         if (department.beds?.size!! < department.patients?.size!!) {
                             val negativeNumber = department.patients.size - department.beds.size
                             notifications.add(
                                 DepartmentNotification(
                                     department.id.toString(), department,
                                     "There is a lack of $negativeNumber beds in this department now", Date(), true,1
                                 )
                             )
                         } else if (department.beds?.size!! == department.patients?.size!!) {
                             notifications.add(
                                 DepartmentNotification(
                                     department.id.toString(), department,
                                     "All beds in this department have been occupied.", Date(), true,1
                                 )
                             )
                         } else if (department.beds?.size!! > department.patients?.size!!) {
                             val positiveDifferece = department.beds.size - department.patients.size

                             if (positiveDifferece < 10) {
                                 notifications.add(
                                     DepartmentNotification(
                                         department.id.toString(),
                                         department,
                                         "It is only $positiveDifferece  beds before the limit of this department is reached",
                                         Date(),
                                         false,1
                                     )
                                 )
                             }

                         }


                   department.employees?.forEach {
                       if(it.job=="Secretaris") {
                           agenda.add(
                               AgendaNotification(
                                   "0",
                                   "Secretary has birthday", Date(), AgendaType.BIRTHDAY
                               )
                           )
                           agenda.add(
                               AgendaNotification(
                                   "0",
                                   "Maintenance of electrical in Department Intensive Care", Date(), AgendaType.DEPARTMENT
                               )
                           )

                           agenda.add(
                               AgendaNotification(
                                   "2",
                                   "Ordered respirators will come tomorrow.", Date(), AgendaType.EQUIPMENT
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


                         view?.setNotificationPriority(notifications )
                         view?.showDepartmentNotifications(notifications)
                         view?.showAgendaNotifications(agenda)
                         view?.setOtherNews()
                         view?.setHospitalNews()

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

                if (department.beds?.size!! >= department.patients?.size!!) {
                    var negativeNumber = department.patients.size - department.beds.size
                     notifications.add(DepartmentNotification(department.id.toString(),department,
                         "$negativeNumber beds are needed ", Date(),true,1))
                }

               // view?.showDepartmentNotifications(notifications)
            }

            override fun onDataNotAvailable() {

            }

            override fun onError(t: Throwable) {

            }
        })
    }

    override fun onSortNotifications(itemId: Int, list: ArrayList<DepartmentNotification>) {
        var sortedList : List<DepartmentNotification>? = null
        val sortedArray : ArrayList<DepartmentNotification> = ArrayList()

        when (itemId) {
            R.id.byPriority -> {
               sortedList = list.sortedWith(compareByDescending { it.priority }) //compareByDescending to get them sorted by descending
            }
            R.id.byDepartment -> {
                sortedList = list.sortedWith(compareBy { it.department?.name }) //compareByDescending to get them sorted by des
            }
            R.id.byTime -> {
                sortedList = list.sortedWith(compareBy { it.time }) //compareByDescending to get them sorted by descending
            }
        }

        sortedList?.forEach {
            sortedArray.add(it)
        }

        view?.showDepartmentNotifications(sortedArray)

    }

    override fun getOtherNews() {
        val otherNews : ArrayList<DepartmentNotification> = ArrayList()

        otherNews.add(DepartmentNotification("Corona",null,"Corona cases in Maastricht have risen to 1500",Date(),false,2 ))
        otherNews.add(DepartmentNotification("Corona",null,"Total number of Corona cases in the Netherlands is 50 000",Date(),false,2 ))
        otherNews.add(DepartmentNotification("Health Ministry",null,"New budged for the Health Ministry has been approved",Date(),true,2 ))
        otherNews.add(DepartmentNotification("Corona",null,"Corona cases in the USA are skyrocketing",Date(),false,2 ))
        otherNews.add(DepartmentNotification("World",null,"World Diabetes pressconfernce will take place in London ",Date(),false,2 ))
        otherNews.add(DepartmentNotification("World",null,"The EU is considering a new investments in Alzheimer research",Date(),false,2 ))
        otherNews.add(DepartmentNotification("Health Ministry",null,"New rules for health insurances to be announced next week",Date(),false,2 ))
        otherNews.add(DepartmentNotification("Netherlands",null,"Dutch national dementia organization to host a new event next week",Date(),false ,2))

        view?.showDepartmentNotifications(otherNews)
    }


    override fun onViewActive(view: DashboardContract.View) {
        this.view = view;
    }

    override fun onViewInactive() {
        this.view = null;
    }

}