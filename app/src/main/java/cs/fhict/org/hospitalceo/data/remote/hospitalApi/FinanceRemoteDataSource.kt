package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.FinanceDataSource
import cs.fhict.org.hospitalceo.data.model.Employee
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
        val call: retrofit2.Call<ArrayList<Finance>> = ApiClient.getClient.getFinances()

        call.enqueue(object : Callback<ArrayList<Finance>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Finance>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Finance>>, response: Response<ArrayList<Finance>>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val finances : ArrayList<Finance> = response.body()!!

                    callback.onFinanceLoaded(finances)



                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

}