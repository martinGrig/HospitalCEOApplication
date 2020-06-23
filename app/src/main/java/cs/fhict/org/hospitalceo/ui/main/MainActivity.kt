package cs.fhict.org.hospitalceo.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.ui.dashboard.DashboardFragment
import cs.fhict.org.hospitalceo.ui.employees.EmployeeFragment
import cs.fhict.org.hospitalceo.ui.finance.FinancesFragment
import cs.fhict.org.hospitalmanagement.BuildConfig
import cs.fhict.org.hospitalmanagement.R


class MainActivity : AppCompatActivity(),MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener {

    private var mainPresenter : MainPresenter? = null
    private var fragmentManager : FragmentManager? = null
    private var bottomNavigationView : BottomNavigationView? = null
    private var listener : BottomNavigationView.OnNavigationItemSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listener = this
        bottomNavigationView = findViewById(R.id.nav_bottom_bar)
        bottomNavigationView?.setOnNavigationItemSelectedListener (listener)

        fragmentManager = supportFragmentManager
        mainPresenter = MainPresenter()
        mainPresenter?.onViewActive(this)

        mainPresenter?.onViewLoaded()

        if (BuildConfig.DEBUG) {
            // These flags cause the device screen to turn on (and bypass screen guard if possible) when launching.
            // This makes it easy for developers to test the app launch without needing to turn on the device
            // each time and without needing to enable the "Stay awake" option.
            window.addFlags(
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                        or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
            )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mainPresenter?.onBackPressed()
    }


    override fun finishActivity() {
       finish()
    }

    override fun loadDashboard() {
        val fragment: Fragment = DashboardFragment()
        fragmentManager?.findFragmentById(R.id.dashboard_tab)
        fragmentManager?.beginTransaction()?.replace(R.id.frameLay,fragment)?.commit()
    }

    override fun loadEmployees() {
        val fragment: Fragment = EmployeeFragment()
        fragmentManager?.findFragmentById(R.id.employees_tab)
        fragmentManager?.beginTransaction()?.replace(R.id.frameLay,fragment)?.commit()
    }

    override fun loadFinance() {
        val fragment: Fragment = FinancesFragment()
        fragmentManager?.findFragmentById(R.id.finance_tab)
        fragmentManager?.beginTransaction()?.replace(R.id.frameLay,fragment)?.commit()
    }

    override fun ShowToast(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard_tab -> {
                mainPresenter?.onDashboardTaped()
            }
            R.id.employees_tab -> {
              mainPresenter?.onEmployeeTaped()
            }
            R.id.finance_tab -> {
                mainPresenter?.onFinanceTaped()
            }
        }
        return false    }


}
