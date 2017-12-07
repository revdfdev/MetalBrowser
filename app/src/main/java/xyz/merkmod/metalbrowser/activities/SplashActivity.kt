package xyz.merkmod.metalbrowser.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.merkmod.metalbrowser.coroutines.UI
import xyz.merkmod.metalbrowser.coroutines.bg
import xyz.merkmod.metalbrowser.di.Properties
import xyz.merkmod.metalbrowser.entities.Sources
import xyz.merkmod.metalbrowser.services.NewSource
import xyz.merkmod.metalbrowser.ui.SplashScreenUI

/**
 * Created by thepunkprogrammer on 12/7/17.
 */
class SplashActivity: AppCompatActivity() {

    val preference: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SplashScreenUI().setContentView(this)


/*        launch(UI) {
            val query = HashMap<String, String>()
            query.put("apiKey", Properties.apiKey)
            val result = bg { service.getSources(query).execute() }
            val response = result.await()
            val body = response.body()
            toast(body?.status!!)
        }*/
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