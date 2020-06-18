package cs.fhict.org.hospitalceo.data.employeesLocal

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cs.fhict.org.hospitalceo.data.model.Employee

interface EmployeeDAO {

    @Query("SELECT * from employee_table ORDER BY id ASC")
    fun getEmployees(): Array<Employee?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(emp: Employee)

}