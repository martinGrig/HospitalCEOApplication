package cs.fhict.org.hospitalceo.ui.main

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalmanagement.R

class MainPresenter  : MainContract.Presenter{

    private var view:MainContract.View? = null

    private var bottomNavigationView : BottomNavigationView? = null
    private var listener : BottomNavigationView.OnNavigationItemSelectedListener? = null

    init {
        listener = this
        bottomNavigationView?.setOnNavigationItemSelectedListener (listener)
    }
    override fun onViewLoaded() {
            view?.loadDashboard()
    }

    override fun onBackPressed() {
         view?.finishActivity()
    }


    override fun onViewActive(view: MainContract.View) {
        this.view=view;
    }

    override fun onViewInactive() {
        this.view = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard_tab -> {
                view?.loadDashboard()
            }
            R.id.employees_tab -> {
                view?.loadEmployees()
            }
            R.id.finance_tab -> {
                view?.loadFinance()
            }
        }
        return false
    }
}
