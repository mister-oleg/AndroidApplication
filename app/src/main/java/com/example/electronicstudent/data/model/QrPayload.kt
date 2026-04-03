package com.example.electronicstudent.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QrPayload(
    @SerialName("college_id")
    val collegeId: String,
    @SerialName("student_id")
    val studentCode: String
)
