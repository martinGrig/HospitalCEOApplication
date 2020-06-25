package cs.fhict.org.hospitalceo.ui.employeeDetails

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.EmployeeRepository
import cs.fhict.org.hospitalceo.data.employeesLocal.EmployeeLocalRepository
import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.DepartmentRemoteDataSource
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.EmployeeRemoteDataSource
import cs.fhict.org.hospitalceo.ui.dashboard.DashboardFragment
import cs.fhict.org.hospitalceo.ui.department.DepartmentPresenter
import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.activity_employee_details.*

class EmployeeDetailsActivity : AppCompatActivity(),EmployeeDetailsContract.View {

    var presenter: EmployeeDetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        val extraID = intent.getStringExtra("id")

        presenter = EmployeeDetailsPresenter(EmployeeRepository(EmployeeRemoteDataSource().getInstance()), EmployeeLocalRepository())
        presenter?.onViewActive(this);

        when(intent.getStringExtra("adapter")){
            "Fav" -> presenter?.getFavouriteEmployee(extraID.toInt())
            "Mes" -> presenter?.getMessagesEmployee(extraID.toInt())
            else -> { Log.d("Details", "No adapter found")}
        }
    }

    override fun updateView(employee: Employee) {
        if(employee.gender.toString() == "female") employeeImage.setImageResource(R.mipmap.female_nurse)
        else employeeImage.setImageResource(R.mipmap.male_nurse)

        employeeDetailsName.text = employee.name_first + " " +  employee.name_last
        employeeBirthday.text = android.text.format.DateFormat.format("yyyy.MM.dd", employee.birthday)
        employeeJobStart.text = android.text.format.DateFormat.format("yyyy.MM.dd", employee.job_start)

        employeeJob.text = employee.job
        employeePhone.text = "+06 12345678"

    }

    override fun ShowToast(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}