package cs.fhict.org.hospitalceo.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import cs.fhict.org.hospitalceo.ui.dashboard.DashboardFragment
import cs.fhict.org.hospitalceo.ui.employees.EmployeeFragment
import cs.fhict.org.hospitalmanagement.R


class MainActivity : AppCompatActivity(),MainContract.View {

    private var mainPresenter : MainPresenter? = null
    private var fragmentManager : FragmentManager? = null
    private var bottomNavigationView : BottomNavigationView? = null
    private var listener : BottomNavigationView.OnNavigationItemSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        mainPresenter = MainPresenter()
        mainPresenter?.onViewActive(this)

        mainPresenter?.onViewLoaded()
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

    }

    override fun ShowToast(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }


}
