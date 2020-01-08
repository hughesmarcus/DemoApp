package com.example.mailchimpapplication.ui.di

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.di.FragmentScope
import com.example.mailchimpapplication.ui.MemberFragment
import com.example.mailchimpapplication.ui.vm.MemberViewModel
import com.example.mailchimpapplication.ui.vm.MemberViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MemberFragmentModule {
    @Provides
    @FragmentScope
    fun provideMemberViewModelFactory(
        application: Application,
        subRepository: SubRepository
    ): MemberViewModelFactory {
        return MemberViewModelFactory(application, subRepository)
    }

    @Provides
    @FragmentScope
    fun provideMemberViewModel(
        fragment: MemberFragment,
        factory: MemberViewModelFactory
    ): MemberViewModel {
        return ViewModelProviders.of(fragment, factory).get(MemberViewModel::class.java)
    }
}