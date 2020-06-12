package cs.fhict.org.hospitalceo.ui.dashboard

import cs.fhict.org.hospitalceo.data.BedDataSource
import cs.fhict.org.hospitalceo.data.BedsRepository
import cs.fhict.org.hospitalceo.data.DepartmentRepository
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.BedRemoteDataSource

class DashboardPresenter(depRep : DepartmentRepository) : DashboardContract.Presenter {

    var view : DashboardContract.View? = null
    var depRep : DepartmentRepository? = depRep;
    var bedRep : BedsRepository? = BedsRepository(BedRemoteDataSource().getInstance()!!)
    fun getNeededBeds() {
       // bedRep?.getUsedBedsCount( )
    }

    override val itemCount: Int
        get() = 0;

    override fun onItemClicked(pos: Int) {
        TODO("Not yet implemented")
    }

    override fun onBindItemView(itemView: DashboardContract.ItemView, pos: Int) {
        TODO("Not yet implemented")
    }

    override fun onViewActive(view: DashboardContract.View) {
        this.view = view;
    }

    override fun onViewInactive() {
        this.view = null;
    }

}