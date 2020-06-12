package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Finance
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.FinanceRemoteDataSource
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.MedicineRemoteDataSource

class FinanceRepository(financeData : FinanceRemoteDataSource)  : FinanceDataSource {

    var financeData = financeData.getInstance()

    override fun getFinances(callback: FinanceDataSource.LoadFinanceCallback) {
        financeData?.getFinances(object : FinanceDataSource.LoadFinanceCallback{
            override fun onFinanceLoaded(finance: ArrayList<Finance>) {
                callback.onFinanceLoaded(finance)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
               callback.onError(t)
            }

        } )
    }

}