package com.example.electronicstudent.viewModel

import android.content.Context
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronicstudent.data.model.StudentData
import com.example.electronicstudent.data.repository.StudentRepository
import kotlinx.coroutines.launch

class LoginViewModel(private var repository: StudentRepository) : ViewModel() {
    var state by mutableStateOf(LoginState())

        private set

    fun onCollegeChanged(value: String) {
        state = state.copy(colleigeCode = value)
    }
    fun onStudentChanged(value: String) {
        state = state.copy(studentCode = value)
    }

    fun login() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                val student = repository.login(state.colleigeCode, state.studentCode)
                state = state.copy(isLoading = false, student = student)
            }
            catch (e: Exception) {
                Log.e("LoginViewModel", "Login request failed", e)
                state = state.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "Ошибка входа"
                )
            }
        }
    }
}
