package id.petersam.resik.external.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.petersam.resik.presentation.login.LoginFragment

@Module
abstract class FragmentInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}
