package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.EmployeeDataSource
import cs.fhict.org.hospitalceo.data.model.Employee

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class EmployeeRemoteDataSource() : EmployeeDataSource {

     private object SingletonHolder {
         val INSTANCE: EmployeeRemoteDataSource = EmployeeRemoteDataSource()
     }
    fun getInstance(): EmployeeRemoteDataSource? {

        return SingletonHolder.INSTANCE
    }


    override fun getEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {
        val call: retrofit2.Call<ArrayList<Employee>> = ApiClient.getClient.getEmployees()

        call.enqueue(object : Callback<ArrayList<Employee>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Employee>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Employee>>, response: Response<ArrayList<Employee>>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val employees : ArrayList<Employee> = response.body()!!
                    callback.onEmployeesLoaded(employees)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getEmployeesCount(callback: EmployeeDataSource.LoadEmployeesCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getEmployeesCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val empCount: Int = response.body()!!
                    callback.onEmployeesCountLoaded(empCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getEmployee(id: Int, callback: EmployeeDataSource.LoadEmployeeCallback) {
        val call: Call<Employee> = ApiClient.getClient.getEmployee(id)

        call.enqueue(object : Callback<Employee> {
            override fun onFailure(call: Call<Employee>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val employee : Employee = response.body()!!
                    callback.onEmployeeLoaded(employee)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getBirthdayEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {
        val call: retrofit2.Call<ArrayList<Employee>> = ApiClient.getClient.getEmployeesBirthdays()

        call.enqueue(object : Callback<ArrayList<Employee>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Employee>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Employee>>, response: Response<ArrayList<Employee>>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val employees : ArrayList<Employee> = response.body()!!
                    callback.onEmployeesLoaded(employees)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getBirthdayEmployeeCount(callback: EmployeeDataSource.LoadEmployeesCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getEmployeesBirthdayCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val empCount: Int = response.body()!!
                    callback.onEmployeesCountLoaded(empCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getAnniversaryEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {
        val call: retrofit2.Call<ArrayList<Employee>> = ApiClient.getClient.getEmployees()

        call.enqueue(object : Callback<ArrayList<Employee>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Employee>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Employee>>, response: Response<ArrayList<Employee>>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val employees : ArrayList<Employee> = response.body()!!
                    callback.onEmployeesLoaded(employees)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getAnniversaryEmployeesCount(callback: EmployeeDataSource.LoadEmployeesCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getEmployeesAnniversaryCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val empCount: Int = response.body()!!
                    callback.onEmployeesCountLoaded(empCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

}