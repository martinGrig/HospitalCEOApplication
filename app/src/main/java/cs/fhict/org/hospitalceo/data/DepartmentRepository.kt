package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Department
import cs.fhict.org.hospitalceo.data.remote.hospitalApi.DepartmentRemoteDataSource


class DepartmentRepository(depData : DepartmentRemoteDataSource?) : DepartmentDataSource {

    var depData : DepartmentRemoteDataSource? = depData?.getInstance()

    override fun getDepartments(callback: DepartmentDataSource.LoadDepartmentsCallBack) {
        depData?.getDepartments(object : DepartmentDataSource.LoadDepartmentsCallBack {
            override fun onDepartmentsLoaded(departmentList: ArrayList<Department>) {
                callback.onDepartmentsLoaded(departmentList)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getDepartmentsCount(callback: DepartmentDataSource.LoadDepartmentsCountCallBack) {
        depData?.getDepartmentsCount(object : DepartmentDataSource.LoadDepartmentsCountCallBack{
            override fun onDepartmentsCountLoaded(depCount: Int) {
               callback.onDepartmentsCountLoaded(depCount)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getDepartment(id: Int, callback: DepartmentDataSource.LoadDepartmentCallBack) {
        TODO("Not yet implemented")
    }
}