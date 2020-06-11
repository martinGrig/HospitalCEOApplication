package cs.fhict.org.hospitalceo.data.model


data class EmployeeMessage(

    var employeeName: String,
    var title: String,
    var body: String,
    var image: String
)
{
    override fun toString(): String {
        return "employee(username='$employeeName', title='$title',body='$body' image='$image')"
    }
}

