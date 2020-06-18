package cs.fhict.org.hospitalceo.ui.finance

import cs.fhict.org.hospitalceo.data.model.Expense
import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface FinanceContract {

    interface View  : IBaseFragment{
        fun showExpenses(expenses: ArrayList<Expense>)
        fun setPieChart(fin : Finance)

    }

    interface Presenter : IBasePresenter<View>{

        fun getExpensesRoom()
        fun getFinances()
        fun onItemClicked(pos: Int)
    }

    interface ItemView{
        fun bindItem(finance: Expense)
    }
}
