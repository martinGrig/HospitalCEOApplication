package cs.fhict.org.hospitalceo.ui.employees

import android.util.Log
import cs.fhict.org.hospitalceo.data.EmployeeDataSource
import cs.fhict.org.hospitalceo.data.EmployeeRepository
import cs.fhict.org.hospitalceo.data.model.Employee

class EmployeePresenter(empRep:EmployeeRepository) : EmployeeContract.Presenter {
    var view : EmployeeContract.View? = null
    var empRep : EmployeeRepository? = empRep

     var favouriteEmployees:ArrayList<Employee>? = ArrayList()

    override fun getFavouriteEmployees() {
        empRep?.getFavouriteStaff(object : EmployeeDataSource.LoadEmployeesCallback{
            override fun onEmployeesLoaded(employeeList: ArrayList<Employee>) {
              //  favouriteEmployees?.addAll(employeeList)

               favouriteEmployees =  getFavouriteContactsFromRepository(employeeList)
                view?.showFavouriteEmployees(favouriteEmployees!!)


                favouriteEmployees?.forEach {
                    Log.d("NAMEFIRST",it.name_first)


                }
            }

            override fun onDataNotAvailable() {
                Log.d("NODATA","NO DATA")

            }

            override fun onError(t: Throwable) {
                Log.d("ERROR",t.message!!)
            }

        })

      //  favouriteEmployees = empRep?.favs
    }

    private fun getFavouriteContactsFromRepository(favourites : ArrayList<Employee>) : ArrayList<Employee> {
        Log.d("SIZE SSS", favourites.size.toString())
        return  favourites
    }

    fun getEmployees (emps : ArrayList<Employee>) : ArrayList<Employee> {
        return  emps
    }

    override val itemCount: Int
        get() =   favouriteEmployees!!.size //favouriteEmployees?.size!!



    override fun onItemClicked(pos: Int) {
        val emp = favouriteEmployees?.get(pos)//favouriteEmployees?.get(pos)
        emp?.id?.let { view?.goToEmployeeDetails(it) }
    }

    override fun onBindItemView(itemView: EmployeeContract.ItemView, pos: Int) {
        Log.d("SIZE SSS", favouriteEmployees?.size.toString())
        favouriteEmployees?.get(pos).let {
            if (it != null) {
                itemView.bindItem(it)
            }
        }
    }

    override fun onViewActive(view: EmployeeContract.View) {
        this.view = view;
    }

    override fun onViewInactive() {
        this.view =null
    }
}