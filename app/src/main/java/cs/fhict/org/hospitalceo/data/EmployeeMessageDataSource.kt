package cs.fhict.org.hospitalceo.data

import cs.fhict.org.hospitalceo.data.model.Employee
import cs.fhict.org.hospitalceo.data.model.EmployeeMessage


interface EmployeeMessageDataSource {
    companion object{

        fun createDataSet(): ArrayList<EmployeeMessage>{
            val list = ArrayList<EmployeeMessage>()
            list.add(
                EmployeeMessage(
                    "Maria Harris",
                    "This if we have title",
                    "Could we meet tomorrow at 13:00?",
                    "this if we have images"
                )
            )
            list.add(
                EmployeeMessage(
                    "John Marel",
                    "This if we have title",
                    "We will schedule a maintainance for the hospital website.",
                    "this if we have images"
                )
            )
            list.add(
                EmployeeMessage(
                    "sara almkara",
                    "This if we have title",
                    "Hello ms. i would like to inform you to fuck off",
                    "this if we have images"
                )
            )
            list.add(
                EmployeeMessage(
                    "donald trump almkara",
                    "This if we have title",
                    "oh we gonna be great , everything is alright",
                    "this if we have images"
                )
            )
            return list
        }

}}
