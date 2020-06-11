package cs.fhict.org.hospitalceo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Department (
    @Expose
    @SerializedName("name")
    val name : String?,
    @Expose
    @SerializedName("location")
    val location: String?
) : Serializable
