package cs.fhict.org.hospitalceo.ui.department

import android.graphics.Color
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.graphics.toColor
import cs.fhict.org.hospitalceo.data.BedsRepository
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.BedRemoteDataSource
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.DepartmentRemoteDataSource
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.activity_department.*
import kotlinx.android.synthetic.main.list_notifications.*
import kotlinx.android.synthetic.main.list_notifications.tvDepartmentName
import java.util.*

class DepartmentActivity : AppCompatActivity(), DepartmentContract.View{

    var presenter : DepartmentPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)

        val extraID = intent.getStringExtra("id")
        presenter = DepartmentPresenter(DepartmentRepository(DepartmentRemoteDataSource().getInstance()))
        presenter?.onViewActive(this);

        presenter?.getDepartment(extraID.toInt()) // make INT




    }

    override fun updateView(department: Department) {

        tvDepartmentName.text = department.name
        tvHeadName.text = department.employees?.get(0)?.name_first + " " + department.employees?.get(0)?.name_first
        tvHeadNumber.text = "+31623131245"

        //linear layouts
        tvBeds.text = "Beds"

        var negativeNumber : Int?= null

        if (department.beds?.size!! > department.patients?.size!!) {
             negativeNumber =   department.beds.size - department.patients.size
             tvBedsStats.text = "$negativeNumber beds before limit is reached"
        }
        else if (department.beds?.size!! < department.patients?.size!!) {
            negativeNumber = department.patients.size - department.beds.size
            tvBedsStats.text = "$negativeNumber beds before limit is reached"
        }
        else {
            tvBedsStats.text = "There are no more  free beds in this department"
        }


        progressBarBeds.max = 30
        progressBarBeds.progress = department.beds?.size?.toInt()!!

        tvStaff.text = "Staff"
        tvStaffStats.text = "10 out of ${department.employees?.size} are on shift"
        progressBarStaff.max = 30
        progressBarStaff.progress = 10

    }

    override fun ShowToast(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}