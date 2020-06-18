package cs.fhict.org.hospitalceo.data.local

import android.util.Log
import androidx.annotation.WorkerThread
import cs.fhict.org.hospitalceo.data.model.Expense
import java.util.*
import kotlin.collections.ArrayList


/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class FinancesLocalRepository( ) {

    private var instance: FinancesLocalRepository? = null

    var appDataBase: FinanceRoomDatabase? =  null // appDataBase

    var expensesEntities: ArrayList<Expense>? = ArrayList()

    private object SingletonHolder {
        val INSTANCE: FinancesLocalRepository = FinancesLocalRepository()
    }
    fun getInstance(): FinancesLocalRepository? {

        return SingletonHolder.INSTANCE
    }

    fun with(appDataBase: FinanceRoomDatabase): FinancesLocalRepository? {
        if (appDataBase == null) this.appDataBase = appDataBase
        if (instance == null) instance = FinancesLocalRepository()
        return instance
    }
    private fun loadExpenses() {
        if (appDataBase == null) return

        expensesEntities?.add(Expense("Masks95", Date(),50000.0))
        expensesEntities?.add(Expense("Insulin", Date(),50000.0))
        expensesEntities?.add(Expense("Bed sheets", Date(),50000.0))
        expensesEntities?.add(Expense("Food ingredients", Date(),50000.0))
        expensesEntities?.add(Expense("Paracetamol", Date(),50000.0))
        expensesEntities?.add(Expense("Oxygen", Date(),50000.0))
        expensesEntities?.add(Expense("Chemicals", Date(),50000.0))
        expensesEntities?.add(Expense("Patient Room 4", Date(),50000.0))
        expensesEntities?.add(Expense("Patient Room 5", Date(),50000.0))
        Log.d("EXPENSES",expensesEntities?.size.toString())
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(expense: Expense) {
        appDataBase?.financeDAO()

    }

    fun getExpenses(): ArrayList<Expense>? {
        expensesEntities?.add(Expense("Masks95", Date(),50000.0))
        expensesEntities?.add(Expense("Insulin", Date(),50000.0))
        expensesEntities?.add(Expense("Bed sheets", Date(),50000.0))
        expensesEntities?.add(Expense("Food ingredients", Date(),50000.0))
        expensesEntities?.add(Expense("Paracetamol", Date(),50000.0))
        expensesEntities?.add(Expense("Oxygen", Date(),50000.0))
        expensesEntities?.add(Expense("Chemicals", Date(),50000.0))
        expensesEntities?.add(Expense("Patient Room 4", Date(),50000.0))
        expensesEntities?.add(Expense("Patient Room 5", Date(),50000.0))
        Log.d("EXPENSES GET",expensesEntities?.size.toString())
        loadExpenses()
        return expensesEntities
    }
}