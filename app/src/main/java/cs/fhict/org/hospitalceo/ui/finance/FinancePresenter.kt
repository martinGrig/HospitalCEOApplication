package cs.fhict.org.hospitalceo.ui.finance

import android.util.Log
import cs.fhict.org.hospitalceo.data.FinanceDataSource
import cs.fhict.org.hospitalceo.data.FinanceRepository
import cs.fhict.org.hospitalceo.data.model.Finance

class FinancePresenter(finRep: FinanceRepository) : FinanceContract.Presenter {
    var view: FinanceContract.View? = null
    var finRep: FinanceRepository? = finRep

    fun getFinances(fins: ArrayList<Finance>): ArrayList<Finance> {
        return fins
    }

    override fun getFinances() {
        finRep?.getFinances(object : FinanceDataSource.LoadFinanceCallback {
            override fun onFinanceLoaded(finance: Finance) {
                view?.setPieChart(finance)
            }

            override fun onDataNotAvailable() {
                Log.d("NODATA", "NO DATA")
            }

            override fun onError(t: Throwable) {
                Log.d("ERROR", t.message!!)
            }
        })
    }

    override fun onItemClicked(pos: Int) {
        TODO("Not yet implemented")
    }
    override fun onViewActive(view: FinanceContract.View) {
        this.view = view;
    }

    override fun onViewInactive() {
        this.view = null;
    }
}