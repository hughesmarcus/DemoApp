package com.example.mailchimpapplication.data

import com.example.mailchimpapplication.ui.SubListAdapterType
import com.example.mailchimpapplication.ui.SubListItemUIModel
import com.example.mailchimpapplication.utils.safeCall

class SubRepository(private val subService: SubService) {
    suspend fun getLists() = safeCall { subService.getLists() }?.lists
    suspend fun getMembers(listId: String) = safeCall { subService.getListMembers(listId) }?.members

    // This is usually in a interactor, Also using a datebase for caching
    suspend fun getUiList(): List<SubListAdapterType> {
        val uiList: MutableList<SubListAdapterType> = mutableListOf()
        val list = getLists()
        list?.forEach {
            uiList.add(
                SubListItemUIModel.SubListTitleUiModel(it.name)
            )
            val members = getMembers(it.id)
            members?.forEach { member ->
                uiList.add(
                    SubListItemUIModel.SubMemberItemUiModel(
                        member,
                        member.merge_fields.FNAME,
                        member.merge_fields.LNAME,
                        member.email_address,
                        member.merge_fields.PHOTO
                    )
                )
            }
        }
        return uiList
    }

}