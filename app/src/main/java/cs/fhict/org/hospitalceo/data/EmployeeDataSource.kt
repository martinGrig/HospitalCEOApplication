package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Employee


interface EmployeeDataSource {

    interface LoadEmployeesCallback {
        fun onEmployeesLoaded(employeeList: ArrayList<Employee>)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    interface LoadEmployeeCallback {
        fun onEmployeeLoaded(employee: Employee)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    interface LoadEmployeesCountCallback{
        fun onEmployeesCountLoaded(count : Int)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    fun getFavouriteStaff(callback: LoadEmployeesCallback)
    fun getEmployees(callback: LoadEmployeesCallback)
    fun getEmployeesCount(callback: LoadEmployeesCountCallback)
    fun getEmployee(id: Int, callback: LoadEmployeeCallback)
    fun getBirthdayEmployees(callback: LoadEmployeesCallback)
    fun getBirthdayEmployeeCount(callback: LoadEmployeesCountCallback)
    fun getAnniversaryEmployees(callback: LoadEmployeesCallback)
    fun getAnniversaryEmployeesCount(callback: LoadEmployeesCountCallback)

}