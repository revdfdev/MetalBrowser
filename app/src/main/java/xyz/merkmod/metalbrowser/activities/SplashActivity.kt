package xyz.merkmod.metalbrowser.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import xyz.merkmod.metalbrowser.ui.SplashScreenUI

/**
 * Created by thepunkprogrammer on 12/7/17.
 */
class SplashActivity: AppCompatActivity() {

    val preference: SharedPreferences by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SplashScreenUI().setContentView(this)
        preference.edit().putString("name", "Rehan").apply()
        toast("hello ${preference.getString("name", "")}")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }
}