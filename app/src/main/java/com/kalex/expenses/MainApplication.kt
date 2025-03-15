package com.kalex.expenses

import android.app.Application
import com.kalex.expenses.di.coreModule
import org.koin.core.context.startKoin

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            coreModule
        }
    }
}