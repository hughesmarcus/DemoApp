package com.example.mailchimpapplication.ui.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mailchimpapplication.data.SubRepository

class MemberViewModelFactory(
    application: Application,
    private val subRepository: SubRepository
) : ViewModelProvider.AndroidViewModelFactory(application) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MemberViewModel(
            subRepository
        ) as T
    }
}