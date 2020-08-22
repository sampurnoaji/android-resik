package id.petersam.resik.data.source.local

import android.content.SharedPreferences
import id.petersam.resik.data.vo.Preference.PREF_KEY_AUTH_TOKEN
import id.petersam.resik.data.vo.Preference.PREF_KEY_LOGIN
import id.petersam.resik.data.vo.Preference.PREF_KEY_USER_NAME
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor
) {
    fun setLoggedIn(isLoggedIn: Boolean) {
        editor.putBoolean(PREF_KEY_LOGIN, isLoggedIn)
        editor.apply()
    }

    fun saveUserSession(name: String, token: String) {
        editor.putString(PREF_KEY_USER_NAME, name)
        editor.putString(PREF_KEY_AUTH_TOKEN, token)
        editor.apply()
    }

    fun isLoggedIn() = sharedPreferences.getBoolean(PREF_KEY_LOGIN, false)
    fun getUsername() = sharedPreferences.getString(PREF_KEY_USER_NAME, null) ?: ""
    fun getToken() = sharedPreferences.getString(PREF_KEY_AUTH_TOKEN, null) ?: ""
}
