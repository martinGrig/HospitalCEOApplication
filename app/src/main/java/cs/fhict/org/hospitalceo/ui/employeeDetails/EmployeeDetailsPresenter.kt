package cs.fhict.org.hospitalceo.ui.employeeDetails
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.data.DepartmentDataSource
import cs.fhict.org.hospitalceo.data.EmployeeDataSource
import cs.fhict.org.hospitalceo.data.EmployeeRepository
import cs.fhict.org.hospitalceo.data.employeesLocal.EmployeeLocalRepository
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.ui.main.MainContract
import cs.fhict.org.hospitalmanagement.R

class EmployeeDetailsPresenter(var empRep: EmployeeRepository, var empLRep: EmployeeLocalRepository)  : EmployeeDetailsContract.Presenter{
    var view:EmployeeDetailsContract.View? = null

    override fun getFavouriteEmployee(id: Int) {
        empRep?.getEmployee(id,object : EmployeeDataSource.LoadEmployeeCallback{
            override fun onEmployeeLoaded(employee: Employee) {
                view?.updateView(employee)
            }

            override fun onDataNotAvailable() {
                view?.ShowToast("Data not available")
            }

            override fun onError(t: Throwable) {
                view?.ShowToast(t.message)
            }
        })
    }

    override fun getMessagesEmployee(id: Int) {
        var employee = empLRep.getEmployee(id)

        if (employee != null) {
            view?.updateView(employee)
        }
    }

    override fun onViewActive(view: EmployeeDetailsContract.View) {
        this.view=view;
    }

    override fun onViewInactive() {
        this.view = null
    }


}
