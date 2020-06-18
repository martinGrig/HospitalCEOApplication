package cs.fhict.org.hospitalceo.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.DepartmentRemoteDataSource
import cs.fhict.org.hospitalceo.ui.finance.FinanceAdapter

import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment(),DashboardContract.View {

    var dashboardPresenter : DashboardPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardPresenter = DashboardPresenter(DepartmentRepository(DepartmentRemoteDataSource().getInstance()))
        dashboardPresenter?.onViewActive(this)
        dashboardPresenter?.getDepartments()
    }

    override fun goToDepartmentDetails() {

    }

    override fun showDepartmentNotifications(depNotifications : ArrayList<Department>) {
        view?.depNotificationsRecyclerView?.layoutManager = LinearLayoutManager(activity)
        view?.depNotificationsRecyclerView?.adapter = view?.context?.let { DashboardAdapter(depNotifications, it) }

        view?.depNotificationsRecyclerView?.adapter?.notifyDataSetChanged()
    }

    override fun ShowToast(message: String?) {
       Toast.makeText(view?.context,message,Toast.LENGTH_LONG).show()
    }

}
