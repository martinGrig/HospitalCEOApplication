package cs.fhict.org.hospitalceo.data.employeesLocal

import android.util.Log
import androidx.annotation.WorkerThread
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.model.Gender
import cs.fhict.org.hospitalceo.data.model.Notification
import java.util.*
import kotlin.collections.ArrayList

class EmployeeLocalRepository() {

    private var instance: EmployeeLocalRepository? = null

    var appDataBase:EmployeeRoomDatabase? = null

    var employeeEntities: ArrayList<Employee>? = ArrayList()

    private object  SingletonHolder{
        var INSTANCE: EmployeeLocalRepository = EmployeeLocalRepository()
    }

    fun getInstance(): EmployeeLocalRepository{
        return SingletonHolder.INSTANCE
    }

    fun with(appDataBase: EmployeeRoomDatabase): EmployeeLocalRepository?{
        if (appDataBase == null) this.appDataBase = appDataBase
        if (instance == null) instance = EmployeeLocalRepository()
        return instance
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(employee: Employee) {
        appDataBase?.employeeDAO()
    }

    fun getEmployees(): ArrayList<Employee>?{

        var cal: Calendar = Calendar.getInstance()
        cal.set(2020, Calendar.JUNE, 20, 22,30)
        var employee = Employee(
            1,
            "Jermo",
            "I",
            "Chotoe",
            Gender.female,
            Date(1962, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(2019,7,31),
            Notification("Urgent","I am sick",
                cal.time
            )
        )
        employeeEntities?.add(employee)

        cal.set(2020, Calendar.JUNE, 20, 16,5)
        employee = Employee(
            1,
            "Richard",
            "Z",
            "Waterson",
            Gender.male,
            Date(1962, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(2019,7,31),
            Notification("Urgent","I wanna die", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 20, 16,5)
        employee = Employee(
            1,
            "Richard",
            "Z",
            "Waterson",
            Gender.male,
            Date(1962, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(2019,7,31),
            Notification("Urgent","I wanna die", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 20, 16,5)
        employee = Employee(
            1,
            "Richard",
            "Z",
            "Waterson",
            Gender.male,
            Date(1962, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(2019,7,31),
            Notification("Urgent","I wanna die", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 20, 16,5)
        employee = Employee(
            1,
            "Richard",
            "Z",
            "Waterson",
            Gender.male,
            Date(1962, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(2019,7,31),
            Notification("Urgent","I wanna die", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 20, 16,5)
        employee = Employee(
            1,
            "Richard",
            "Z",
            "Waterson",
            Gender.male,
            Date(1962, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(2019,7,31),
            Notification("Urgent","I wanna die", cal.time)
        )
        employeeEntities?.add(employee)

        Log.d("EMPLOYEES GET", employeeEntities?.size.toString())
        return employeeEntities
    }

    fun getEmployee(id: Int): Employee?{
        getEmployees()
        employeeEntities?.forEach {
            if(it.id == id) {
                Log.d("Local Employee", "Found $id")
                return it}
        }
    Log.d("Local Employee", "Not Found $id")
    return null;
    }
}















