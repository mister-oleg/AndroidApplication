package com.example.electronicstudent.data.api

import com.example.electronicstudent.data.model.LoginRegurst
import com.example.electronicstudent.data.model.StudentData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiService {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun login(collegeCode: String, studentCode: String): StudentData {
        val response = client.post(LOGIN_URL) {
            contentType(ContentType.Application.Json)
            setBody(LoginRegurst(collegeCode, studentCode))
        }

        if (!response.status.isSuccess()) {
            throw IllegalStateException("HTTP ${response.status.value}")
        }

        return response.body()
    }

    private companion object {
        const val LOGIN_URL = "https://d5dnjgh3l77bbls255e1.laqt4bj7.apigw.yandexcloud.net/login"
    }
}
