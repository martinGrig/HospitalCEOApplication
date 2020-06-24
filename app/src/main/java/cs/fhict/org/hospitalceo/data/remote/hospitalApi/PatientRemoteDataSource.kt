package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import android.util.Log
import cs.fhict.org.hospitalceo.data.PatientDataSource
import cs.fhict.org.hospitalceo.data.model.Patient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientRemoteDataSource : PatientDataSource {


    private object SingletonHolder {
        val INSTANCE: PatientRemoteDataSource = PatientRemoteDataSource()
    }
    fun getInstance(): PatientRemoteDataSource? {

        return SingletonHolder.INSTANCE
    }

    override fun getPatients(callback: PatientDataSource.LoadPatientsCallback) {
        val call: retrofit2.Call<ArrayList<Patient>> = ApiClient.getClient.getAllPatients()

        call.enqueue(object : Callback<ArrayList<Patient>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Patient>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Patient>>, response: Response<ArrayList<Patient>>) {
                if (response.isSuccessful) {


                    val patients : ArrayList<Patient> = response.body()!!
                    callback.onPatientsLoaded(patients)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getPatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getAllPatientsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val patientCount: Int = response.body()!!
                    callback.onPatientsCountLoaded(patientCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getPatient(id: Int, callback: PatientDataSource.LoadPatientCallback) {
        val call: retrofit2.Call<Patient> = ApiClient.getClient.getPatient(id)

        call.enqueue(object : Callback<Patient> {
            override fun onFailure(call: retrofit2.Call<Patient>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<Patient>, response: Response<Patient>) {
                if (response.isSuccessful) {

                    val patient : Patient = response.body()!!
                    callback.onPatientLoaded(patient)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getPastPatients(callback: PatientDataSource.LoadPatientsCallback) {
        val call: retrofit2.Call<ArrayList<Patient>> = ApiClient.getClient.getPastPatients()

        call.enqueue(object : Callback<ArrayList<Patient>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Patient>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Patient>>, response: Response<ArrayList<Patient>>) {
                if (response.isSuccessful) {
                    Log.d("TAG SUCCESS", response.toString())

                    val patients : ArrayList<Patient> = response.body()!!
                    callback.onPatientsLoaded(patients)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getPastPatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getPastPatientsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val patientCount: Int = response.body()!!
                    callback.onPatientsCountLoaded(patientCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getCurrentPatients(callback: PatientDataSource.LoadPatientsCallback) {
        val call: retrofit2.Call<ArrayList<Patient>> = ApiClient.getClient.getCurrentPatients()

        call.enqueue(object : Callback<ArrayList<Patient>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Patient>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Patient>>, response: Response<ArrayList<Patient>>) {
                if (response.isSuccessful) {

                    val patients : ArrayList<Patient> = response.body()!!
                    callback.onPatientsLoaded(patients)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getCurrentPatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getCurrentPatientsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val patientCount: Int = response.body()!!
                    callback.onPatientsCountLoaded(patientCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getFuturePatients(callback: PatientDataSource.LoadPatientsCallback) {
        val call: retrofit2.Call<ArrayList<Patient>> = ApiClient.getClient.getFuturePatients()

        call.enqueue(object : Callback<ArrayList<Patient>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<Patient>>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: retrofit2.Call<ArrayList<Patient>>, response: Response<ArrayList<Patient>>) {
                if (response.isSuccessful) {

                    val patients : ArrayList<Patient> = response.body()!!
                    callback.onPatientsLoaded(patients)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }

    override fun getFuturePatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        val call: Call<Int> = ApiClient.getClient.getFuturePatientsCount()

        call.enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("TAG FAIL", t.message!!)

                callback.onError(t);

            }
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    val patientCount: Int = response.body()!!
                    callback.onPatientsCountLoaded(patientCount)

                } else {
                    callback.onDataNotAvailable();
                }
            }
        })
    }
}