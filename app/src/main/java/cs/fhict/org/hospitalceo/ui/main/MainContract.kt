package cs.fhict.org.hospitalceo.ui.main

import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.utils.mvp.IBaseFragment
import cs.fhict.org.hospitalceo.utils.mvp.IBasePresenter

interface MainContract {

    interface View : IBaseFragment {
        fun finishActivity();
        fun loadDashboard()
        fun loadEmployees()
        fun loadFinance()
    }

    interface Presenter : IBasePresenter<View>, BottomNavigationView.OnNavigationItemSelectedListener {
        fun onViewLoaded();
        fun onBackPressed();

    }
}