package xyz.merkmod.metalbrowser

import android.app.Application
import android.content.pm.ApplicationInfo
import com.github.ajalt.timberkt.Timber
import com.vicpin.krealmextensions.RealmConfigStore
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.Koin
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger
import xyz.merkmod.metalbrowser.di.MetalModules
import xyz.merkmod.metalbrowser.entities.Article
import xyz.merkmod.metalbrowser.entities.Source

/**
 * Created by thepunkprogrammer on 12/7/17.
 */
class Metal: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("metal-db")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        Realm.deleteRealm(Realm.getDefaultConfiguration())
        Realm.deleteRealm(config)

        RealmConfigStore.init(Source::class.java, config)
        RealmConfigStore.init(Article::class.java, config)
        initLogging()
        startKoin(this, MetalModules())
    }

    fun initLogging() {
        val isDebug = (0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE)
        if (isDebug) {
            Koin.logger = AndroidLogger()
            Timber.plant(timber.log.Timber.DebugTree())
        }
    }
}