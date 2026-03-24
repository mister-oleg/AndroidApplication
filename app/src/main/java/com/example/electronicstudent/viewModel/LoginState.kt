package com.example.electronicstudent.viewModel

import com.example.electronicstudent.data.model.StudentData

data class LoginState(
    val colleigeCode: String = "",
    val studentCode: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val student: StudentData? = null
)
