package id.petersam.resik.external.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import id.petersam.resik.data.vo.Preference
import javax.inject.Singleton

@Module
class SharedPreferenceModule {
    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(Preference.PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferenceEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }
}
