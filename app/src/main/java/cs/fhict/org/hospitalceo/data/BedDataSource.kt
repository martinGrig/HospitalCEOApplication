package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Bed

interface BedDataSource {
    interface LoadBedsCallBack {
        fun onBedsLoaded(bedList: ArrayList<Bed>)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    interface LoadBedCallBack {
        fun onBedLoaded(bed: Bed)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    interface LoadBedsCountCallBack {
        fun onBedsCountLoaded(count: Int)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    fun getBeds(callback: LoadBedsCallBack)
    fun getBedsCount(callback: LoadBedsCountCallBack);
    fun getBed(id: Int, callback: LoadBedCallBack)
    fun getFreeBeds(callback: LoadBedsCallBack)
    fun getFreeBedsCount(callback: LoadBedsCountCallBack)
    fun getUsedBeds(callback: LoadBedsCallBack)
    fun getUsedBedsCount(callback: LoadBedsCountCallBack)


}