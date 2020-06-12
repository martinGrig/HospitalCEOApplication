package cs.fhict.org.hospitalceo.ui.finance

import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface FinanceContract {
    interface View  : IBaseFragment{
        fun showFinances(fins : ArrayList<Finance>)
        fun setPieChart(fin : Finance)

    }

    interface Presenter : IBasePresenter<View>{

        fun getFinances()
        fun onItemClicked(pos: Int)
    }

    interface ItemView{
        fun bindItem(finance: Finance)
    }
}
