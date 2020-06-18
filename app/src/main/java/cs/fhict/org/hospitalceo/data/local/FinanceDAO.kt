package cs.fhict.org.hospitalceo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cs.fhict.org.hospitalceo.data.model.Expense

@Dao
interface FinanceDAO {

    @Query("Select * FROM finance_expenses")
    fun getExpenses(): Array<Expense?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(expense: Expense)

}