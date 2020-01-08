package com.example.mailchimpapplication.ui.vm

import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.utils.ScopedViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MemberViewModel @Inject constructor(private val subRepository: SubRepository) : ScopedViewModel() {

    fun updateMember(memberId: String, memberListId: String, email: String) {
        launch {
            subRepository.updateMember(memberListId, memberId)
        }
    }

}