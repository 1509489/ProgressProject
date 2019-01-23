package com.example.progressproject.di.activity

import com.example.progressproject.ui.home.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun injectHomeScreen(mainActivity: MainActivity)
}