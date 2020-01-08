package com.example.mailchimpapplication.ui

import com.example.mailchimpapplication.data.models.Member

sealed class SubListItemUIModel {
    data class SubListTitleUiModel(
        val title: String?,
        override val subType: SubType = SubType.TITLE
    ) :
        SubListItemUIModel(), SubListAdapterType

    data class SubMemberItemUiModel(
        val member: Member?,
        val firstName: String?,
        val lastName: String?,
        val email: String,
        val imageUrl: String?,
        override val subType: SubType = SubType.MEMBER
    ) :
        SubListItemUIModel(), SubListAdapterType
}