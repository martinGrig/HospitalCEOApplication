package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.data.model.Medicine

public interface FinanceDataSource {

    interface LoadFinanceCallback {
        fun onFinanceLoaded(finance: Finance)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    fun getFinances(callback: LoadFinanceCallback)
}
