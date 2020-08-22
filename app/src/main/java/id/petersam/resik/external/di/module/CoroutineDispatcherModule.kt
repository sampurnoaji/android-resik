package id.petersam.resik.external.di.module

import dagger.Binds
import dagger.Module
import id.petersam.resik.data.dispatcher.CoroutineDispatcherProvider
import id.petersam.resik.data.dispatcher.DispatcherProvider

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}
