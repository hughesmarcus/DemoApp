package com.example.mailchimpapplication.ui.di

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.di.FragmentScope
import com.example.mailchimpapplication.ui.SubListFragment
import com.example.mailchimpapplication.ui.vm.SubListViewModel
import com.example.mailchimpapplication.ui.vm.SubListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SubListModule {
    @Provides
    @FragmentScope
    fun provideSubViewModelFactory(
        application: Application,
        subRepository: SubRepository
    ): SubListViewModelFactory {
        return SubListViewModelFactory(application, subRepository)
    }

    @Provides
    @FragmentScope
    fun provideSubViewModel(
        fragment: SubListFragment,
        factory: SubListViewModelFactory
    ): SubListViewModel {
        return ViewModelProviders.of(fragment, factory).get(SubListViewModel::class.java)
    }
}