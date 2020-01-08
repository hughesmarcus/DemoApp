package com.example.mailchimpapplication.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.data.models.Member
import com.example.mailchimpapplication.utils.ScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MemberViewModel @Inject constructor(private val subRepository: SubRepository) :
    ScopedViewModel() {


    private val memberLiveData = MutableLiveData<Member>()
    val member: LiveData<Member>
        get() = memberLiveData

    fun getMember(memberId: String, memberListId: String) {
        launch(Dispatchers.IO) {
            memberLiveData.postValue(subRepository.getMember(memberId, memberListId))
        }
    }

    fun updateMember(memberId: String, memberListId: String, member: Member) {
        launch(Dispatchers.IO) {
            subRepository.updateMember(memberListId, memberId, member)
        }
    }

}