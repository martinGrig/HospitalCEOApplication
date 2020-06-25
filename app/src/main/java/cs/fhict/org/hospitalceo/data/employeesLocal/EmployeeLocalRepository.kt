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
            Date(62, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(119,7,31),
            Notification("Urgent","I am not feeling well, is it possible for me to have a sick leave?",
                cal.time
            )
        )
        employeeEntities?.add(employee)

        cal.set(2020, Calendar.JUNE, 19, 17,50)
        employee = Employee(
            1,
            "Richard",
            "Z",
            "Waterson",
            Gender.male,
            Date(62, 5, 20),
            "Orthopedische chirurg",
            "Orthopedie",
            Date(119,7,31),
            Notification("Urgent","We have a problem in the Orthopedie Department", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 23, 13,13)
        employee = Employee(
            1,
            "Nikole",
            "R",
            "Vermond",
            Gender.male,
            Date(76, 5, 20),
            "Diëtetiek",
            "Diëtetiek",
            Date(113,7,31),
            Notification("Urgent","The conditions of a patient are getting worse", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 25,9,0)
        employee = Employee(
            1,
            "Jasmin",
            "M",
            "van 't Klooster",
            Gender.female,
            Date(87, 5, 20),
            "Anesthesioloog-pijnspecialis",
            "Orthopedie",
            Date(100,7,31),
            Notification("Urgent","Dr. Michaels is not and he was suppose to be on shift", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 21, 21,25)
        employee = Employee(
            1,
            "David",
            "Z",
            "Koehorst",
            Gender.male,
            Date(62, 5, 20),
            "Slaapconsulent",
            "Orthopedie",
            Date(99,7,31),
            Notification("Urgent","I am organizing a party, are you free on Sunday, Boss?", cal.time)
        )
        employeeEntities?.add(employee)
        cal.set(2020, Calendar.JUNE, 22, 3,33)
        employee = Employee(
            1,
            "Rock",
            "D",
            "Johnson",
            Gender.male,
            Date(87, 5, 20),
            "Physician Assistant",
            "Orthopedie",
            Date(111,7,31),
            Notification("Urgent","\"Message deleted.\"", cal.time)
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















