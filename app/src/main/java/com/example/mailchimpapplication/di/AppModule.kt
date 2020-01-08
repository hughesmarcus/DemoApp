package com.example.mailchimpapplication.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetModule::class])
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindApplicationContext(application: Application): Context
}
