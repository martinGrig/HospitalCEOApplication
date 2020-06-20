package cs.fhict.org.hospitalceo.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.model.DepartmentNotification
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.DepartmentRemoteDataSource
import cs.fhict.org.hospitalceo.ui.department.DepartmentActivity

import cs.fhict.org.hospitalmanagement.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*


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
        dashboardPresenter?.getDepartment(1)


    }

    override fun goToDepartmentDetails(id: Int) {

        val intent : Intent = Intent(activity,DepartmentActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
    }

    override fun showDepartmentNotifications(depNotifications : ArrayList<DepartmentNotification>) {


        view?.depNotificationsRecyclerView?.layoutManager = LinearLayoutManager(activity)

        view?.depNotificationsRecyclerView?.adapter = view?.context?.let { DashboardAdapter(depNotifications, it) }

        view?.depNotificationsRecyclerView?.adapter?.notifyDataSetChanged()



    }

    override fun showAgendaNotifications(depNotifications: ArrayList<DepartmentNotification>) {
        view?.recyclerViewAgenda?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, true)

        view?.recyclerViewAgenda?.adapter = view?.context?.let { DashboardAgendaAdapter(depNotifications, it) }

        view?.recyclerViewAgenda?.adapter?.notifyDataSetChanged()
    }

    override fun setNotificationPriority(depNotifications: ArrayList<DepartmentNotification>) {
        notificationsMenu.setOnClickListener {
            val popupMenu = PopupMenu(view?.context,it)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
                dashboardPresenter?.onSortNotifications(item!!.itemId,depNotifications)
                true
            })

            popupMenu.inflate(R.menu.notifications_menu)
            popupMenu.show()
        }
    }

    override fun ShowToast(message: String?) {
       Toast.makeText(view?.context,message,Toast.LENGTH_LONG).show()
    }

}
