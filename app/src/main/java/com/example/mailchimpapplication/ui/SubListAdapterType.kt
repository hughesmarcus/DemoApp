package com.example.mailchimpapplication.ui

interface SubListAdapterType {
    val subType: SubType
}

enum class SubType {
    TITLE,
    MEMBER
}