package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.FinanceDataSource
import cs.fhict.org.hospitalceo.data.model.Finance
import retrofit2.Callback
import retrofit2.Response

class FinanceRemoteDataSource : FinanceDataSource {

    private object SingletonHolder {
        val INSTANCE: FinanceRemoteDataSource = FinanceRemoteDataSource()
    }
    fun getInstance(): FinanceRemoteDataSource? {
        return SingletonHolder.INSTANCE
    }

    override fun getFinances(callback: FinanceDataSource.LoadFinanceCallback) {
        val call: retrofit2.Call<Finance> = ApiClient.getClient.getFinances()
        call.enqueue(object : Callback<Finance> {
            override fun onFailure(call: retrofit2.Call<Finance>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)
                callback.onError(t)
            }
            override fun onResponse(call: retrofit2.Call<Finance>, response: Response<Finance>) {
                if (response.isSuccessful) {
                    val finance : Finance = response.body()!!
                    callback.onFinanceLoaded(finance)
                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

}