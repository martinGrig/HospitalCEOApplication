package cs.fhict.org.hospitalceo.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.io.Serializable
import java.util.*

@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey
    @NonNull
    val id : Int?,
    val name_first: String?,
    val name_initials : String?,
    val name_last: String?,
    val gender : Gender?,
    val birthday: Date?,
    val job : String?,
    val department : String?,
    val job_start : Date?,
    @Expose(serialize = false)
    val notification : Notification
    ) : Serializable

data class Notification(
    val title : String?,
    val body : String?,
    val date: Date?
) : Serializable

enum class Gender : Serializable {
    male,
    female
}