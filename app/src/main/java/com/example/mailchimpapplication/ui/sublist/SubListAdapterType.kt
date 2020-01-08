package com.example.mailchimpapplication.ui.sublist

interface SubListAdapterType {
    val subType: SubType
}

enum class SubType {
    TITLE,
    MEMBER
}