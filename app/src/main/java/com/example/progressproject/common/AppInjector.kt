package com.example.progressproject.common

import android.app.Application
import com.example.progressproject.di.application.ApplicationComponent
import com.example.progressproject.di.application.ApplicationModule
import com.example.progressproject.di.application.DaggerApplicationComponent

class AppInjector:Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}