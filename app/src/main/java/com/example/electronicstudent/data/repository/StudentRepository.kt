package com.example.electronicstudent.data.repository

import com.example.electronicstudent.data.api.ApiService

class StudentRepository(private val api: ApiService) {
    suspend fun login(colleageCode: String, studentCode: String) = api.login(colleageCode, studentCode)
}