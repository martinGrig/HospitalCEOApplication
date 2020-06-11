package cs.fhict.org.hospitalceo.utils.mvp

interface IBasePresenter<View> {
    fun onViewActive(view: View)
    fun onViewInactive()
}