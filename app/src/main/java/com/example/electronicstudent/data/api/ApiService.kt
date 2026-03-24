package com.example.electronicstudent.data.api

import androidx.compose.ui.text.font.AndroidFont
import com.example.electronicstudent.data.model.LoginRegurst
import com.example.electronicstudent.data.model.StudentData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.engine.config
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.serialization.kotlinx.json.json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiService {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json() {ignoreUnknownKeys=true }
        }
    }

    suspend fun login (collegeCode: String, studentCode: String) : StudentData{
        val response = client.post("") {
            setBody(LoginRegurst(collegeCode, studentCode))
        }

        response.status.value
        return response.body()
    }
}