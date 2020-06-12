package cs.fhict.org.hospitalceo.data.employeesLocal

import androidx.lifecycle.LiveData
import cs.fhict.org.hospitalceo.data.model.Employee

class EmployeeLocalRepository(private val employeeDAO: EmployeeDAO) {
    val allEmployees: LiveData<List<Employee>> = employeeDAO.getEmployees()

    suspend fun insert(employee: Employee){
        employeeDAO.insert(employee)
    }
}