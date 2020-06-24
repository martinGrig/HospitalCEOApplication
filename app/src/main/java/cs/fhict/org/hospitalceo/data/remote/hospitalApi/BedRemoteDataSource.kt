package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.BedDataSource
import cs.fhict.org.hospitalceo.data.model.Bed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BedRemoteDataSource  : BedDataSource {


    private object SingletonHolder {
        val INSTANCE: BedRemoteDataSource = BedRemoteDataSource()
    }
    fun getInstance(): BedRemoteDataSource? {

        return SingletonHolder.INSTANCE
    }

    override fun getBeds(callback: BedDataSource.LoadBedsCallBack) {
        val call: Call<ArrayList<Bed>> = ApiClient.getClient.getBeds()

        call.enqueue(object : Callback<ArrayList<Bed>> {
            override fun onFailure(call: Call<ArrayList<Bed>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Bed>>, response: Response<ArrayList<Bed>>) {
                if (response.isSuccessful) {

                    val beds : ArrayList<Bed> = response.body()!!
                    callback.onBedsLoaded(beds)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getBedsCount(callback: BedDataSource.LoadBedsCountCallBack) {
        val call: Call<Int> = ApiClient.getClient.getBedsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val bedCount: Int = response.body()!!
                    callback.onBedsCountLoaded(bedCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getBed(id: Int, callback: BedDataSource.LoadBedCallBack) {
        val call: Call<Bed> = ApiClient.getClient.getBedsById(id)

        call.enqueue(object : Callback<Bed> {
            override fun onFailure(call: Call<Bed>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Bed>, response: Response<Bed>) {
                if (response.isSuccessful) {

                    val bed : Bed = response.body()!!
                    callback.onBedLoaded(bed)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getFreeBeds(callback: BedDataSource.LoadBedsCallBack) {
        val call: Call<ArrayList<Bed>> = ApiClient.getClient.getFreeBeds()

        call.enqueue(object : Callback<ArrayList<Bed>> {
            override fun onFailure(call: Call<ArrayList<Bed>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Bed>>, response: Response<ArrayList<Bed>>) {
                if (response.isSuccessful) {

                    val beds : ArrayList<Bed> = response.body()!!
                    callback.onBedsLoaded(beds)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getFreeBedsCount(callback: BedDataSource.LoadBedsCountCallBack) {
        val call: Call<Int> = ApiClient.getClient.getFreeBedsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val bedCount: Int = response.body()!!
                    callback.onBedsCountLoaded(bedCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getUsedBeds(callback: BedDataSource.LoadBedsCallBack) {
        val call: Call<ArrayList<Bed>> = ApiClient.getClient.getUsedBeds()

        call.enqueue(object : Callback<ArrayList<Bed>> {
            override fun onFailure(call: Call<ArrayList<Bed>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Bed>>, response: Response<ArrayList<Bed>>) {
                if (response.isSuccessful) {

                    val beds : ArrayList<Bed> = response.body()!!
                    callback.onBedsLoaded(beds)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getUsedBedsCount(callback: BedDataSource.LoadBedsCountCallBack) {
        val call: Call<Int> = ApiClient.getClient.getUsedBedsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val bedCount: Int = response.body()!!
                    callback.onBedsCountLoaded(bedCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }
}