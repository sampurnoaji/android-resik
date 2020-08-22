package id.petersam.resik.external.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.petersam.resik.presentation.MainActivity

@Module
abstract class ActivityInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
