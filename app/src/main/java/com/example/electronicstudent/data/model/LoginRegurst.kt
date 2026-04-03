package com.example.electronicstudent.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRegurst(
    @SerialName("college_id")
    val collegeId: String,
    @SerialName("student_id")
    val studentId: String
)
