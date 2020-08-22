package id.petersam.resik.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.petersam.resik.data.vo.LoadResult
import id.petersam.resik.domain.entity.LoginParams
import id.petersam.resik.domain.usecase.LoginStateUseCase
import id.petersam.resik.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginStateUseCase: LoginStateUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _login = MutableLiveData<LoadResult<Boolean>>()
    val login: LiveData<LoadResult<Boolean>>
        get() = _login

    fun isLoggedIn() = loginStateUseCase.invoke()

    fun login(username: String, password: String) {
        _login.value = LoadResult.Loading
        viewModelScope.launch {
            _login.value = loginUseCase.invoke(LoginParams(username, password))
        }
    }
}
