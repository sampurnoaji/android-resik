package id.petersam.resik.data.source.remote

import id.petersam.resik.data.request.LoginRequest
import id.petersam.resik.data.response.LoginDto
import id.petersam.resik.data.service.ApiService
import id.petersam.resik.data.vo.LoadResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val service: ApiService) :
    RemoteDataSource() {
    suspend fun login(dispatcher: CoroutineDispatcher, request: LoginRequest): LoadResult<LoginDto> {
        return safeApiCall(dispatcher) { service.login(request) }
    }
}
