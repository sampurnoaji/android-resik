package id.petersam.resik.domain.repository

import id.petersam.resik.data.request.LoginRequest
import id.petersam.resik.domain.entity.LoginData
import id.petersam.resik.data.vo.LoadResult

interface UserRepository {
    suspend fun login(request: LoginRequest): LoadResult<LoginData>

    fun setLoggedIn(isLoggedIn: Boolean)
    fun saveUserSession(name: String, token: String)
    fun isLoggedIn(): Boolean
    fun getUsername(): String
    fun getToken(): String
}
