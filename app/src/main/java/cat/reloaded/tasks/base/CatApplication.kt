package cat.reloaded.tasks.base

import android.app.Application
import cat.reloaded.tasks.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class CatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            // TODO add crash reporting library
        }
    }
}