package id.petersam.resik.external.di.module

import dagger.Binds
import dagger.Module
import id.petersam.resik.data.repository.UserRepositoryImpl
import id.petersam.resik.domain.repository.UserRepository

@Module
interface RepositoryModule {
    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository
}
