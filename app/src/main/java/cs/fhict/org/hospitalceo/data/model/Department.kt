package cs.fhict.org.hospitalceo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Department (
    @Expose
    @SerializedName("id")
    val id : Int?,
    @Expose
    @SerializedName("patients")
    val patients : ArrayList<Patient>?,
    @Expose
    @SerializedName("name")
    val name : String?,
    @Expose
    @SerializedName("employees")
    val employees : ArrayList<Employee>?,
    @Expose
    @SerializedName("location")
    val location: String?,
    @Expose
    @SerializedName("beds")
    val beds : ArrayList<Bed>? = ArrayList(),
    //hardcoded
    @Expose(serialize=false)
    val notifications : ArrayList<DepartmentNotification>?

) : Serializable

data class DepartmentNotification(
    val id: String?,
    val department: Department?,
    val body : String?,
    val time : Date?,
    val priority: Boolean?,
    val type : Int
)

data class AgendaNotification(
    val id: String?,
    val body : String?,
    val time : Date?,
    val type : AgendaType?
)

enum class AgendaType {
    BIRTHDAY,
    EQUIPMENT,
    DEPARTMENT

}

