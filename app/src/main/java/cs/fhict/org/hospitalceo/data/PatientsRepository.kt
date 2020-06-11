package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Patient
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.PatientRemoteDataSource


public class PatientsRepository(patientData: PatientRemoteDataSource): PatientDataSource {

    var patientData = patientData.getInstance()

    override fun getPatients(callback: PatientDataSource.LoadPatientsCallback) {
        patientData?.getPatients(object:PatientDataSource.LoadPatientsCallback{
            override fun onPatientsLoaded(patientList: ArrayList<Patient>) {
                callback.onPatientsLoaded(patientList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
               callback.onError(t)
            }

        })
    }

    override fun getPatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        patientData?.getPatientsCount(object:PatientDataSource.LoadPatientsCountCallback{
            override fun onPatientsCountLoaded(patientsCount: Int) {
                callback.onPatientsCountLoaded(patientsCount)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getPatient(id: Int, callback: PatientDataSource.LoadPatientCallback) {
        patientData?.getPatient(id, object : PatientDataSource.LoadPatientCallback{
            override fun onPatientLoaded(patient: Patient) {
                callback.onPatientLoaded(patient)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getPastPatients(callback: PatientDataSource.LoadPatientsCallback) {
        patientData?.getPastPatients(object:PatientDataSource.LoadPatientsCallback{
            override fun onPatientsLoaded(patientList: ArrayList<Patient>) {
                callback.onPatientsLoaded(patientList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getPastPatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        patientData?.getPastPatientsCount(object:PatientDataSource.LoadPatientsCountCallback{
            override fun onPatientsCountLoaded(patientsCount: Int) {
                callback.onPatientsCountLoaded(patientsCount)
            }

            override fun onDataNotAvailable() {
               callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getCurrentPatients(callback: PatientDataSource.LoadPatientsCallback) {
        patientData?.getCurrentPatients(object:PatientDataSource.LoadPatientsCallback{
            override fun onPatientsLoaded(patientList: ArrayList<Patient>) {
                callback.onPatientsLoaded(patientList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getCurrentPatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        patientData?.getCurrentPatientsCount(object:PatientDataSource.LoadPatientsCountCallback{
            override fun onPatientsCountLoaded(patientsCount: Int) {
                callback.onPatientsCountLoaded(patientsCount)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getFuturePatients(callback: PatientDataSource.LoadPatientsCallback) {
        patientData?.getFuturePatients(object:PatientDataSource.LoadPatientsCallback{
            override fun onPatientsLoaded(patientList: ArrayList<Patient>) {
                callback.onPatientsLoaded(patientList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getFuturePatientsCount(callback: PatientDataSource.LoadPatientsCountCallback) {
        patientData?.getFuturePatientsCount(object:PatientDataSource.LoadPatientsCountCallback{
            override fun onPatientsCountLoaded(patientsCount: Int) {
                callback.onPatientsCountLoaded(patientsCount)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }
}