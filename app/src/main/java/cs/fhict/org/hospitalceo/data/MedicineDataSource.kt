package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Medicine


public interface MedicineDataSource {

    interface LoadMedicinesCallback {
        fun onMedicinesLoaded(medicineList: ArrayList<Medicine>)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }
    interface LoadMedicineCallback {
        fun onMedicineLoaded(medicine: Medicine)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }
    interface LoadMedicinesCountCallback {
        fun onMedicinesCountLoaded(medCount: Int)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    fun getMedicines(callback: LoadMedicinesCallback)
    fun getMedicinesCount(callback: LoadMedicinesCountCallback)
    fun getMedicine(id: Int, callback: LoadMedicineCallback)
    fun getStockMedicines(callback: LoadMedicinesCallback)
    fun getStockMedicinesCount(callback: LoadMedicinesCountCallback)
    fun getRestockMedicines(callback: LoadMedicinesCallback)
    fun getRestockMedicinesCount(callback: LoadMedicinesCountCallback)


}