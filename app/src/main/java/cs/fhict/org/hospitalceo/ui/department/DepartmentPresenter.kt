package cs.fhict.org.hospitalceo.ui.department

import cs.fhict.org.hospitalceo.data.BedsRepository
import cs.fhict.org.hospitalceo.data.model.Bed


class DepartmentPresenter(bedRep: BedsRepository) : DepartmentContract.Presenter {
    var view: DepartmentContract.View? = null;
    var beds = ArrayList<Bed>() // can be done with interactor
    var bedRep: BedsRepository = bedRep

    override val itemCount: Int
        get() = beds?.size!!

    override fun onItemClicked(pos: Int) {
        TODO("Not yet implemented")
    }

    override fun onBindItemView(itemView: DepartmentContract.ItemView, pos: Int) {
        TODO("Not yet implemented")
    }

    override fun onViewActive(view: DepartmentContract.View) {
        this.view = view
    }

    override fun onViewInactive() {
        this.view = null
    }
}