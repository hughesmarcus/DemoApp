package com.example.mailchimpapplication.di

import com.example.mailchimpapplication.ui.MemberFragment
import com.example.mailchimpapplication.ui.di.MemberFragmentModule
import com.example.mailchimpapplication.ui.sublist.SubListFragment
import com.example.mailchimpapplication.ui.di.SubListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [SubListModule::class])
    abstract fun contributeSubListFragment(): SubListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MemberFragmentModule::class])
    abstract fun contributeMemberFragment(): MemberFragment
}