package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Bed
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.BedRemoteDataSource

 class BedsRepository(bedData : BedRemoteDataSource) : BedDataSource{

    var bedData : BedRemoteDataSource? = bedData.getInstance()

    override fun getBeds(callback: BedDataSource.LoadBedsCallBack) {
        bedData?.getBeds(object : BedDataSource.LoadBedsCallBack{
            override fun onBedsLoaded(bedList: ArrayList<Bed>) {
                callback.onBedsLoaded(bedList)
            }

            override fun onDataNotAvailable() {
               callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getBedsCount(callback: BedDataSource.LoadBedsCountCallBack) {
       bedData?.getBedsCount(object : BedDataSource.LoadBedsCountCallBack{
           override fun onBedsCountLoaded(count: Int) {
               callback.onBedsCountLoaded(count)
           }

           override fun onDataNotAvailable() {
               callback.onDataNotAvailable()
           }

           override fun onError(t: Throwable) {
               callback.onError(t)
           }

       })
    }

    override fun getBed(id: Int, callback: BedDataSource.LoadBedCallBack) {
        bedData?.getBed(id,object :BedDataSource.LoadBedCallBack{
            override fun onBedLoaded(bed: Bed) {
                callback.onBedLoaded(bed)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getFreeBeds(callback: BedDataSource.LoadBedsCallBack) {
        bedData?.getFreeBeds(object : BedDataSource.LoadBedsCallBack{
            override fun onBedsLoaded(bedList: ArrayList<Bed>) {
                callback.onBedsLoaded(bedList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getFreeBedsCount(callback: BedDataSource.LoadBedsCountCallBack) {
        bedData?.getFreeBedsCount(object : BedDataSource.LoadBedsCountCallBack{
            override fun onBedsCountLoaded(count: Int) {
                callback.onBedsCountLoaded(count)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getUsedBeds(callback: BedDataSource.LoadBedsCallBack) {
        bedData?.getUsedBeds(object : BedDataSource.LoadBedsCallBack{
            override fun onBedsLoaded(bedList: ArrayList<Bed>) {
                callback.onBedsLoaded(bedList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getUsedBedsCount(callback: BedDataSource.LoadBedsCountCallBack) {
        bedData?.getUsedBedsCount(object : BedDataSource.LoadBedsCountCallBack{
            override fun onBedsCountLoaded(count: Int) {
                callback.onBedsCountLoaded(count)
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