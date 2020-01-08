package com.example.mailchimpapplication.di

import com.example.mailchimpapplication.ui.SubListFragment
import com.example.mailchimpapplication.ui.di.SubListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [SubListModule::class])
    abstract fun contributeSubListFragment(): SubListFragment
}