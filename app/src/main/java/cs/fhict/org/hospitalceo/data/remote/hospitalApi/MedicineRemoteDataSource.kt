package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.MedicineDataSource
import cs.fhict.org.hospitalceo.data.model.Medicine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicineRemoteDataSource : MedicineDataSource {

    private object SingletonHolder {
        val INSTANCE: MedicineRemoteDataSource = MedicineRemoteDataSource()
    }
    fun getInstance(): MedicineRemoteDataSource? {

        return SingletonHolder.INSTANCE
    }

    override fun getMedicines(callback: MedicineDataSource.LoadMedicinesCallback) {
        val call: Call<ArrayList<Medicine>> = ApiClient.getClient.getMedicines()

        call.enqueue(object : Callback<ArrayList<Medicine>> {
            override fun onFailure(call: Call<ArrayList<Medicine>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Medicine>>, response: Response<ArrayList<Medicine>>) {
                if (response.isSuccessful) {

                    val medicines : ArrayList<Medicine> = response.body()!!
                    callback.onMedicinesLoaded(medicines)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getMedicinesCount(callback: MedicineDataSource.LoadMedicinesCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getMedicinesCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val medsCount: Int = response.body()!!
                    callback.onMedicinesCountLoaded(medsCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getMedicine(id: Int, callback: MedicineDataSource.LoadMedicineCallback) {
        val call: Call<Medicine> = ApiClient.getClient.getMedicineById(id)

        call.enqueue(object : Callback<Medicine> {
            override fun onFailure(call: Call<Medicine>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Medicine>, response: Response<Medicine>) {
                if (response.isSuccessful) {

                    val medicine : Medicine = response.body()!!
                    callback.onMedicineLoaded(medicine)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getStockMedicines(callback: MedicineDataSource.LoadMedicinesCallback) {
        val call: Call<ArrayList<Medicine>> = ApiClient.getClient.getMedicinesStock()

        call.enqueue(object : Callback<ArrayList<Medicine>> {
            override fun onFailure(call: Call<ArrayList<Medicine>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Medicine>>, response: Response<ArrayList<Medicine>>) {
                if (response.isSuccessful) {

                    val medicines : ArrayList<Medicine> = response.body()!!
                    callback.onMedicinesLoaded(medicines)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getStockMedicinesCount(callback: MedicineDataSource.LoadMedicinesCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getMedicinesStockCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val medsCount: Int = response.body()!!
                    callback.onMedicinesCountLoaded(medsCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getRestockMedicines(callback: MedicineDataSource.LoadMedicinesCallback) {
        val call: Call<ArrayList<Medicine>> = ApiClient.getClient.getMedicinesRestock()

        call.enqueue(object : Callback<ArrayList<Medicine>> {
            override fun onFailure(call: Call<ArrayList<Medicine>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Medicine>>, response: Response<ArrayList<Medicine>>) {
                if (response.isSuccessful) {

                    val medicines : ArrayList<Medicine> = response.body()!!
                    callback.onMedicinesLoaded(medicines)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getRestockMedicinesCount(callback: MedicineDataSource.LoadMedicinesCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getMedicinesRestockCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val medsCount: Int = response.body()!!
                    callback.onMedicinesCountLoaded(medsCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

}