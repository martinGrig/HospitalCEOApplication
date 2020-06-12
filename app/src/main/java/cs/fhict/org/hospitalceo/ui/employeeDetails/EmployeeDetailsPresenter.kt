package cs.fhict.org.hospitalceo.ui.employeeDetails
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.data.EmployeeDataSource
import cs.fhict.org.hospitalceo.data.EmployeeRepository
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.ui.main.MainContract
import cs.fhict.org.hospitalmanagement.R

class EmployeeDetailsPresenter(empRep: EmployeeRepository)  : EmployeeDetailsContract.Presenter{
    private var view:EmployeeDetailsContract.View? = null
    var emp : Employee?=null
    var empRep : EmployeeRepository=empRep

    override fun getEmployee() {
        /*empRep.getEmployee(id,object : EmployeeDataSource.LoadEmployeeCallback{
            override fun onEmployeeLoaded(employee: Employee) {

            }

            override fun onDataNotAvailable() {

            }

            override fun onError(t: Throwable) {

            }

        })
        */

    }


    override fun onViewLoaded() {

    }

    override fun onViewActive(view: EmployeeDetailsContract.View) {
        this.view=view;
    }

    override fun onViewInactive() {
        this.view = null
    }


}
