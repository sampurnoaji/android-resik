package id.petersam.resik.data.service

import id.petersam.resik.data.request.LoginRequest
import id.petersam.resik.data.response.LoginDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginDto
}
