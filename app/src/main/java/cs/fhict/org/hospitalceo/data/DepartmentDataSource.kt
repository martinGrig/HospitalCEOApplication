package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Department

interface DepartmentDataSource {
    interface LoadDepartmentsCallBack {
        fun onDepartmentsLoaded(departmentList: ArrayList<Department>)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }
    interface LoadDepartmentCallBack {
        fun onDepartmentLoaded(department: Department)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }
    interface LoadDepartmentsCountCallBack {
        fun onDepartmentsCountLoaded(depCount : Int)
        fun onDataNotAvailable()
        fun onError(t: Throwable)
    }

    fun getDepartments(callback: LoadDepartmentsCallBack)
    fun getDepartmentsCount(callback:LoadDepartmentsCountCallBack)
    fun getDepartment(id: Int, callback: LoadDepartmentCallBack)

}