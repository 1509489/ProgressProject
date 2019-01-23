package com.example.progressproject.di.application

import com.example.progressproject.di.activity.ActivityComponent
import com.example.progressproject.di.activity.ActivityModule
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}