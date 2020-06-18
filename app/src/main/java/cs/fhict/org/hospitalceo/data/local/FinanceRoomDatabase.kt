package cs.fhict.org.hospitalceo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.BedRemoteDataSource

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [Expense::class], version = 1)
abstract  class FinanceRoomDatabase() : RoomDatabase() {

    private var instance: FinanceRoomDatabase? = null
    abstract fun financeDAO(): FinanceDAO



    open fun getAppDatabase(context: Context): FinanceRoomDatabase? {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                FinanceRoomDatabase::class.java,
                "finance_table"
            )
                .allowMainThreadQueries()
                .build()
        }
        return instance
    }
//    companion object {
//        private var instance: FinanceRoomDatabase? = null
//        fun getAppDatabase(context: Context): FinanceRoomDatabase? {
//            if (instance == null) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    FinanceRoomDatabase::class.java,
//                    "finance_expenses"
//                )
//                    .allowMainThreadQueries()
//                    .build()
//            }
//            return instance
//        }
//    }


}