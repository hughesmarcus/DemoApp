package com.example.mailchimpapplication.ui.vm

import androidx.lifecycle.liveData
import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.utils.ScopedViewModel
import javax.inject.Inject

class SubListViewModel @Inject constructor(private val subRepository: SubRepository) :
    ScopedViewModel() {

    var subsLiveData = liveData {
        emit(
           subRepository.getUiList()
        )
    }
}