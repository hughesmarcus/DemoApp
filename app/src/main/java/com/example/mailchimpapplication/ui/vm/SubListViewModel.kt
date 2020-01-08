package com.example.mailchimpapplication.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.ui.sublist.SubListAdapterType
import com.example.mailchimpapplication.utils.ScopedViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubListViewModel @Inject constructor(private val subRepository: SubRepository) :
    ScopedViewModel() {

    private val subsLiveData = MutableLiveData<List<SubListAdapterType>>()
    val subList: LiveData<List<SubListAdapterType>>
        get() = subsLiveData

    fun setSubs() {
        launch {
            subsLiveData.postValue(subRepository.getUiList())
        }
    }

}