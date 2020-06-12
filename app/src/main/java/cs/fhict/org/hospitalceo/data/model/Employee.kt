package cs.fhict.org.hospitalceo.data.model

import java.io.Serializable
import java.util.*

data class Employee(
    val id : Int?,
    val name_first: String?,
    val name_initials : String?,
    val name_last: String?,
    val gender : Gender?,
    val birthday: Date?,
    val job : String?,
    val department : String?) : Serializable

enum class Gender : Serializable {
    male,
    female
}