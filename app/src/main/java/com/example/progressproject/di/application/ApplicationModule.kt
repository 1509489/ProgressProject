package com.example.progressproject.di.application

import android.app.Application
import android.content.Context
import com.example.progressproject.data.repository.RepositoryImpl
import com.example.progressproject.di.NetworkModule
import com.example.progressproject.network.NetworkService
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class ApplicationModule(val application: Application) {
    @Provides
    @ApplicationScope
    fun providesContext(): Context = application

    @Provides
    @ApplicationScope
    fun providesRepository(networkService: NetworkService) : RepositoryImpl = RepositoryImpl(networkService)
}