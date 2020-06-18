package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.DepartmentDataSource
import cs.fhict.org.hospitalceo.data.model.Department
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DepartmentRemoteDataSource  : DepartmentDataSource {

    private object SingletonHolder {
        val INSTANCE: DepartmentRemoteDataSource = DepartmentRemoteDataSource()
    }
    fun getInstance(): DepartmentRemoteDataSource? {

        return SingletonHolder.INSTANCE
    }

    override fun getDepartments(callback: DepartmentDataSource.LoadDepartmentsCallBack) {
        val call: Call<ArrayList<Department>> = ApiClient.getClient.getDepartments()

        call.enqueue(object : Callback<ArrayList<Department>> {
            override fun onFailure(call: Call<ArrayList<Department>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<ArrayList<Department>>, response: Response<ArrayList<Department>>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val departments : ArrayList<Department> = response.body()!!
                    callback.onDepartmentsLoaded(departments)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getDepartmentsCount(callback: DepartmentDataSource.LoadDepartmentsCountCallBack) {
        val call: Call<Int> = ApiClient.getClient.getDepartmentsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val depCount: Int = response.body()!!
                    callback.onDepartmentsCountLoaded(depCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getDepartment(id: Int, callback: DepartmentDataSource.LoadDepartmentCallBack) {
        val call: Call<Department> = ApiClient.getClient.getDepartment(id)

        call.enqueue(object : Callback<Department> {
            override fun onFailure(call: Call<Department>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Department>, response: Response<Department>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val department: Department = response.body()!!
                    callback.onDepartmentLoaded(department)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

}

