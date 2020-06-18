package cs.fhict.org.hospitalceo.data.employeesLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.model.Gender
import cs.fhict.org.hospitalceo.data.model.Notification
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeRoomDatabase : RoomDatabase() {

    private var instance: EmployeeRoomDatabase? = null
    abstract fun employeeDAO(): EmployeeDAO

/*    class EmployeeDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.employeeDAO())
                }
            }
        }
        suspend fun populateDatabase(employeeDAO: EmployeeDAO){
            employeeDAO.deleteAll()

            var employee = Employee(
                1,
                "Jermo",
                "I",
                "Chotoe",
                Gender.male,
                Date(1962, 5, 20),
                "Orthopedische chirurg",
                "Orthopedie",
                Date(2019,7,31),
                Notification("Urgent","I am sick",   Date(2020,6,12))
            )
            employeeDAO.insert(employee)

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
                Notification("Urgent","I wanna die",   Date(2020,6,12))
            )
            employeeDAO.insert(employee)
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: EmployeeRoomDatabase? = null*/

    fun getAppDatabase(
        context: Context
    ): EmployeeRoomDatabase? {
        if (instance == null) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                EmployeeRoomDatabase::class.java,
                "employees_database"
            )
                .allowMainThreadQueries()
                .build()
        }
        return instance
    }
}