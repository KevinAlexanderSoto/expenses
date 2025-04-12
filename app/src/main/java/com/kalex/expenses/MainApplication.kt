package com.kalex.expenses

import android.app.Application
import com.kalex.expenses.di.coreModule
import com.kalex.expenses.di.dataBaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                coreModule,
                dataBaseModule
            )
        }
    }
}