package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Medicine
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.MedicineRemoteDataSource


public class MedicineRepository(medData : MedicineRemoteDataSource)  : MedicineDataSource {

    var medData = medData.getInstance()

    override fun getMedicines(callback: MedicineDataSource.LoadMedicinesCallback) {
        medData?.getMedicines(object : MedicineDataSource.LoadMedicinesCallback{
            override fun onMedicinesLoaded(medicineList: ArrayList<Medicine>) {
                callback.onMedicinesLoaded(medicineList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getMedicinesCount(callback: MedicineDataSource.LoadMedicinesCountCallback) {
        medData?.getMedicinesCount(object:MedicineDataSource.LoadMedicinesCountCallback{
            override fun onMedicinesCountLoaded(medCount: Int) {
                callback.onMedicinesCountLoaded(medCount)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getMedicine(id: Int, callback: MedicineDataSource.LoadMedicineCallback) {
        medData?.getMedicine(id, object : MedicineDataSource.LoadMedicineCallback{
            override fun onMedicineLoaded(medicine: Medicine) {
                callback.onMedicineLoaded(medicine)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getStockMedicines(callback: MedicineDataSource.LoadMedicinesCallback) {
        medData?.getMedicines(object : MedicineDataSource.LoadMedicinesCallback{
            override fun onMedicinesLoaded(medicineList: ArrayList<Medicine>) {
                callback.onMedicinesLoaded(medicineList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getStockMedicinesCount(callback: MedicineDataSource.LoadMedicinesCountCallback) {
        medData?.getStockMedicinesCount(object:MedicineDataSource.LoadMedicinesCountCallback{
            override fun onMedicinesCountLoaded(medCount: Int) {
                callback.onMedicinesCountLoaded(medCount)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getRestockMedicines(callback: MedicineDataSource.LoadMedicinesCallback) {
        medData?.getMedicines(object : MedicineDataSource.LoadMedicinesCallback{
            override fun onMedicinesLoaded(medicineList: ArrayList<Medicine>) {
                callback.onMedicinesLoaded(medicineList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getRestockMedicinesCount(callback: MedicineDataSource.LoadMedicinesCountCallback) {
        medData?.getRestockMedicinesCount(object:MedicineDataSource.LoadMedicinesCountCallback{
            override fun onMedicinesCountLoaded(medCount: Int) {
                callback.onMedicinesCountLoaded(medCount)
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