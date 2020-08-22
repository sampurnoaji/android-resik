package id.petersam.resik.domain.usecase

import id.petersam.resik.domain.repository.UserRepository
import javax.inject.Inject

class LoginStateUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Boolean = repository.isLoggedIn()
}
