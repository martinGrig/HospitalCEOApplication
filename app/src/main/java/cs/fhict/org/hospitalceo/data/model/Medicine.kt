package cs.fhict.org.hospitalceo.data.model

import java.io.Serializable

data class Medicine(val name : String?, val minimum_stock : Int?, val stock : Int?,val restock_needed : Boolean?) : Serializable
