package cs.fhict.org.hospitalceo.data.model

import java.io.Serializable
import java.util.*

data class Patient(val patient_nr : Int?, val hosp_start : Date? , val hosp_end :Date?,val passed_away : Boolean?, val moment : Moment?,
                   val bed_needed : Boolean?) : Serializable

enum class Moment : Serializable {
    current,
    past,
    future
}
