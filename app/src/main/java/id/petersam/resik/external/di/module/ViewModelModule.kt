package id.petersam.resik.external.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.petersam.resik.external.di.annotation.ViewModelKey
import id.petersam.resik.external.di.factory.ViewModelFactory
import id.petersam.resik.presentation.login.LoginViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun providesLoginViewModel(viewModel: LoginViewModel): ViewModel
}
