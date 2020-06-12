package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.EmployeeRemoteDataSource


class EmployeeRepository(empData : EmployeeRemoteDataSource?) : EmployeeDataSource{

    var empData = empData?.getInstance()

    override fun getFavouriteStaff(callback: EmployeeDataSource.LoadEmployeesCallback) {
        empData?.getFavouriteStaff(object: EmployeeDataSource.LoadEmployeesCallback {
            override fun onEmployeesLoaded(employeeList: ArrayList<Employee>) {
                callback.onEmployeesLoaded(employeeList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }


    override fun getEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {

        empData?.getEmployees(object: EmployeeDataSource.LoadEmployeesCallback {
            override fun onEmployeesLoaded(employeeList: ArrayList<Employee>) {
                callback.onEmployeesLoaded(employeeList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })


    }

    override fun getEmployeesCount(callback: EmployeeDataSource.LoadEmployeesCountCallback) {
        empData?.getEmployeesCount(object: EmployeeDataSource.LoadEmployeesCountCallback {

            override fun onEmployeesCountLoaded(count: Int) {
                callback.onEmployeesCountLoaded(count)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getEmployee(id: Int, callback: EmployeeDataSource.LoadEmployeeCallback) {

        empData?.getEmployee(id,object: EmployeeDataSource.LoadEmployeeCallback {
            override fun onEmployeeLoaded(employee: Employee) {
                callback.onEmployeeLoaded(employee)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getBirthdayEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {
        empData?.getBirthdayEmployees(object: EmployeeDataSource.LoadEmployeesCallback {
            override fun onEmployeesLoaded(employeeList: ArrayList<Employee>) {
                callback.onEmployeesLoaded(employeeList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getBirthdayEmployeeCount(callback: EmployeeDataSource.LoadEmployeesCountCallback) {
        empData?.getEmployeesCount(object: EmployeeDataSource.LoadEmployeesCountCallback {

            override fun onEmployeesCountLoaded(count: Int) {
                callback.onEmployeesCountLoaded(count)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getAnniversaryEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {
        empData?.getAnniversaryEmployees(object: EmployeeDataSource.LoadEmployeesCallback {
            override fun onEmployeesLoaded(employeeList: ArrayList<Employee>) {
                callback.onEmployeesLoaded(employeeList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getAnniversaryEmployeesCount(callback: EmployeeDataSource.LoadEmployeesCountCallback) {
        empData?.getEmployeesCount(object: EmployeeDataSource.LoadEmployeesCountCallback {

            override fun onEmployeesCountLoaded(count: Int) {
                callback.onEmployeesCountLoaded(count)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }


}