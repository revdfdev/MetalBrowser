package xyz.merkmod.metalbrowser.di

import android.content.SharedPreferences
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.merkmod.metalbrowser.services.NewSource
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by thepunkprogrammer on 12/7/17.
 */

object Properties {
    val BASE_URL = "https://newsapi.org/v1/"
    val apiKey = "a30d8a5ddb944651aa5093177836b6f1"
}

fun MetalModules() = listOf(SharedPreferenceModule(), NetworkModule())

class SharedPreferenceModule: AndroidModule() {
    override fun context() = applicationContext {
        provide {
            createSharePreference(this@SharedPreferenceModule.context)
        }
    }

}

class NetworkModule: AndroidModule() {
    override fun context() = applicationContext {
        provide { createOkttpClient(this@NetworkModule.context) }
        provide { createPicasso(this@NetworkModule.context, get()) }
        provide { createWebService(get(), Properties.BASE_URL) }
    }
}



fun createSharePreference(context: android.content.Context) :SharedPreferences
        = context.getSharedPreferences(context.packageName, android.content.Context.MODE_PRIVATE)


fun createOkttpClient(context: android.content.Context): OkHttpClient {
    val cache = (Cache(File(context.cacheDir,"okhttp_cache"), 10 * 1000 * 1000))
    val httpLogingInterceptor = HttpLoggingInterceptor()
    httpLogingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(httpLogingInterceptor)
            .cache(cache)
            .build()
}

fun createPicasso(context: android.content.Context, okHttpClient: OkHttpClient): Picasso {
    val okhttp3Downloader = OkHttp3Downloader(okHttpClient)
    return Picasso.Builder(context)
            .downloader(okhttp3Downloader)
            .build()
}


fun createWebService(okHttpClient: OkHttpClient, url: String): NewSource {
    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    return retrofit.create(NewSource::class.java)
}
