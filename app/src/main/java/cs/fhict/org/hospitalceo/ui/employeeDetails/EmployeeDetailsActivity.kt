package cs.fhict.org.hospitalceo.ui.employeeDetails

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import cs.fhict.org.hospitalceo.ui.dashboard.DashboardFragment
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.activity_employee_details.*

class EmployeeDetailsActivity : AppCompatActivity(),EmployeeDetailsContract.View {

    var presenter: EmployeeDetailsPresenter? = null
/*
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        val extraID = intent.getIntExtra(idTAG,0)
        Log.d(idTAG, extraID.toString())
        presenter = EmployeeDetailsPresenter(extraID)

        presenter?.onViewActive(this)

        presenter?.getEmployee()

    }

    override fun updateViewData() {
        employeeDetailsName.text = presenter?.showPhotoTitle()
        showText("Title shown!")
    }



    override fun showText(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

 */
    override fun onStart() {
        presenter?.onViewActive(this)
        super.onStart()
    }
    override fun onDestroy() {
        presenter!!.onViewInactive()
        presenter = null
        super.onDestroy()

    }

    override fun ShowToast(message: String?) {
        TODO("Not yet implemented")
    }
}