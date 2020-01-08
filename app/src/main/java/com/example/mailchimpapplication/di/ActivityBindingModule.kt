package com.example.mailchimpapplication.di

import com.example.mailchimpapplication.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun contributeMainActivityInjector(): MainActivity
}