package cs.fhict.org.hospitalceo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cs.fhict.org.hospitalceo.data.model.Expense

@Dao
interface FinanceDAO {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
//    @Query("SELECT * from finance_expenses ORDER BY expense ASC")
//    fun getExpensesLocally(): LiveData<List<Expense>>

    @Query("Select * FROM finance_expenses")
    fun getExpenses(): Array<Expense?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(expense: Expense)

}