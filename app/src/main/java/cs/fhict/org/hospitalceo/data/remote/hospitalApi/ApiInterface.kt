package cs.fhict.org.hospitalceo.data.remote.hospitalApi

import cs.fhict.org.hospitalceo.data.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

public interface HospitalInterface  {
//    @GET("routes")
//    fun getAllRoutes(): Call<ArrayList<Route>>

    //PATIENTS
    @GET("patients")
    fun getAllPatients(): Call<ArrayList<Patient>>

    @GET("patients/count")
    fun getAllPatientsCount(): Call<Int>

    @GET("patients/{id}") // not working because there is no id, talk to clients to fix it
    fun getPatient(@Path("id")  id: Int?) : Call<Patient>

    @GET("patients/past")
    fun getPastPatients() : Call<ArrayList<Patient>>

    @GET("patients/past/count")
    fun getPastPatientsCount() : Call<Int>

    @GET("patients/future")
    fun getFuturePatients() : Call<ArrayList<Patient>>

    @GET("patients/future/count")
    fun getFuturePatientsCount() : Call<Int>

    @GET("patients/current")
    fun getCurrentPatients() : Call<ArrayList<Patient>>

    @GET("patients/current/count")
    fun getCurrentPatientsCount() : Call<Int>



    //DEPARTMENTS
    @GET("departments")
    fun getDepartments(): Call<ArrayList<Department>>

    @GET("departments/count")
    fun getDepartmentsCount(): Call<Int>

    @GET("departments/{id}") // not working because there is no id, talk to clients to fix it
    fun getDepartment(@Path("id")   id: Int?) : Call<Department>

    //EMPLOYEES
    @GET("employees")
    fun getEmployees(): Call<ArrayList<Employee>>

    @GET("employees/count")
    fun getEmployeesCount(): Call<Int>

    @GET("employees/{id}")
    fun getEmployee(@Path("id")  id: Int?) : Call<Employee>

    @GET("employees/birthdays")
    fun getEmployeesBirthdays() : Call<ArrayList<Employee>>
    @GET("employees/birthdays/count")
    fun getEmployeesBirthdayCount(): Call<Int>

    @GET("employees/anniversaries")
    fun getEmployeesAniversaries() : Call<ArrayList<Employee>>
    @GET("employees/anniversaries/count")
    fun getEmployeesAnniversaryCount(): Call<Int>


    //BEDS
    @GET("beds")
    fun getBeds(): Call<ArrayList<Bed>>

    @GET("beds/{id}")
    fun getBedsById(@Path("id") id : Int?): Call<Bed>

    @GET("beds/count")
    fun getBedsCount(): Call<Int>

    @GET("beds/free")
    fun getFreeBeds(): Call<ArrayList<Bed>>

    @GET("beds/free/count")
    fun getFreeBedsCount(): Call<Int>

    @GET("beds/used")
    fun getUsedBeds(): Call<ArrayList<Bed>>

    @GET("beds/used/count")
    fun getUsedBedsCount(): Call<Int>


    //MEDICINES
    @GET("medicines")
    fun getMedicines(): Call<ArrayList<Medicine>>

    @GET("medicines/{id}")
    fun getMedicineById(@Path("id") id : Int?): Call<Medicine>

    @GET("medicines/count")
    fun getMedicinesCount(): Call<Int>

    @GET("medicines/stock")
    fun getMedicinesStock(): Call<ArrayList<Medicine>>

    @GET("medicines/stock/count")
    fun getMedicinesStockCount(): Call<Int>

    @GET("medicines/restock")
    fun getMedicinesRestock(): Call<ArrayList<Medicine>>

    @GET("medicines/restock/count")
    fun getMedicinesRestockCount(): Call<Int>

    //FINANCES

    @GET("finance")
    fun getFinances(): Call<Finance>



}
