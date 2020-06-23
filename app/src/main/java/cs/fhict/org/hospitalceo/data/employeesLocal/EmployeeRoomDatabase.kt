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