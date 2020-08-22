package id.petersam.resik.data.repository

import id.petersam.resik.data.dispatcher.DispatcherProvider
import id.petersam.resik.data.mapper.LoginMapper
import id.petersam.resik.data.request.LoginRequest
import id.petersam.resik.data.source.local.UserLocalDataSource
import id.petersam.resik.data.source.remote.UserRemoteDataSource
import id.petersam.resik.data.vo.LoadResult
import id.petersam.resik.domain.entity.LoginData
import id.petersam.resik.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val loginMapper: LoginMapper,
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) : UserRepository {
    override suspend fun login(request: LoginRequest): LoadResult<LoginData> {
        return when (val apiResult = remoteDataSource.login(dispatcher.io, request)) {
            is LoadResult.Success -> LoadResult.Success(loginMapper.map(apiResult.data))
            is LoadResult.Error -> LoadResult.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> LoadResult.Error()
        }
    }

    override fun setLoggedIn(isLoggedIn: Boolean) = localDataSource.setLoggedIn(isLoggedIn)
    override fun saveUserSession(name: String, token: String) = localDataSource.saveUserSession(name, token)
    override fun isLoggedIn(): Boolean = localDataSource.isLoggedIn()
    override fun getUsername(): String = localDataSource.getUsername()
    override fun getToken(): String = localDataSource.getToken()
}
