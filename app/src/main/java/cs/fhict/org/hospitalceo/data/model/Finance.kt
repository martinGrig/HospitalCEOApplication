package cs.fhict.org.hospitalceo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Finance (
    @SerializedName("costs") val costs : Costs,
    @SerializedName("income") val income : Income,
    @SerializedName("new_insurance_contracts") val new_insurance_contracts : New_insurance_contracts,
    @SerializedName("format") val format : String
) : Serializable


data class Costs(
    @SerializedName("today") val today : Int

) : Serializable


data class Income(
    @SerializedName("today") val today : Int

) : Serializable


data class New_insurance_contracts(
    @SerializedName("today") val today : Int

) : Serializable