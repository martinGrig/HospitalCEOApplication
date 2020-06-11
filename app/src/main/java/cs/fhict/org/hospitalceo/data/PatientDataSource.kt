package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Patient

interface PatientDataSource {

    interface LoadPatientsCallback {
        fun onPatientsLoaded(patientList: ArrayList<Patient>)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    interface LoadPatientCallback {
        fun onPatientLoaded(patient: Patient)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }
    interface LoadPatientsCountCallback {
        fun onPatientsCountLoaded(patientsCount : Int)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }
    fun getPatients(callback: LoadPatientsCallback)
    fun getPatientsCount(callback: LoadPatientsCountCallback)
    fun getPatient(id: Int, callback: LoadPatientCallback)
    fun getPastPatients(callback: LoadPatientsCallback)
    fun getPastPatientsCount(callback: LoadPatientsCountCallback)
    fun getCurrentPatients(callback: LoadPatientsCallback)
    fun getCurrentPatientsCount(callback: LoadPatientsCountCallback)
    fun getFuturePatients(callback: LoadPatientsCallback)
    fun getFuturePatientsCount(callback: LoadPatientsCountCallback)

}