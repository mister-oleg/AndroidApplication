package com.example.electronicstudent.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StudentData(
    @SerialName("student_id")
    var group: String,
    @SerialName("college_id")
    var college: String,
    @SerialName("firstname")
    var name: String,
    var lastname: String,
    var avatar: String
)
