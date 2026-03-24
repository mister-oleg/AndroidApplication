package com.example.electronicstudent.data.model

import kotlinx.serialization.SerialName

data class LoginRegurst(
    @SerialName("college_id")
    val collegeId: String,
    @SerialName("student_id")
    val studentId: String
)
