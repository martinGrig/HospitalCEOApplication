package cs.fhict.org.hospitalceo.ui.finance

import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface FinanceContract {
    interface View  : IBaseFragment{

    }

    interface Presenter : IBasePresenter<View>{

    }

    interface ItemView{
        fun bindItem(finance: Finance)
    }
}
