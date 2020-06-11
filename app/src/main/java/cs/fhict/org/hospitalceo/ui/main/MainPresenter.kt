package cs.fhict.org.hospitalceo.ui.main

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalmanagement.R

class MainPresenter  : MainContract.Presenter{

    private var view:MainContract.View? = null

    override fun onViewLoaded() {
            view?.loadDashboard()
    }

    override fun onBackPressed() {
         view?.finishActivity()
    }

    override fun onDashboardTaped() {
        view?.loadDashboard()
    }

    override fun onFinanceTaped() {
        view?.loadFinance()
    }

    override fun onEmployeeTaped() {
        view?.loadEmployees()
    }


    override fun onViewActive(view: MainContract.View) {
        this.view=view;
    }

    override fun onViewInactive() {
        this.view = null
    }


}
