package id.petersam.resik.data.mapper

import id.petersam.resik.data.response.LoginDto
import id.petersam.resik.domain.entity.LoginData
import id.petersam.resik.external.base.BaseMapper
import javax.inject.Inject

class LoginMapper @Inject constructor() : BaseMapper<LoginDto, LoginData>() {
    override fun map(input: LoginDto): LoginData {
        return LoginData(
            name = input.name ?: "",
            token = input.token ?: ""
        )
    }
}
