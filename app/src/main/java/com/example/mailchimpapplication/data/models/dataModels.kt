package com.example.mailchimpapplication.data.models

data class ListsResponse(val lists: List<MailChimpList>)
data class MailChimpList(val id: String, val name:String)

data class MembersResponse(val members: List<Member>)
data class Member(
    val id: String,
    val email_address: String,
    val status: String,
    val last_changed: String,
    val list_id: String,
    val merge_fields: MergeFields
)

data class MergeFields(
    val FNAME: String,
    val LNAME: String,
    val ADDRESS: Address? = null,
    val PHONE: String? = null,
    val COMPANY: String? = null,
    val CITY: String? = null,
    val COUNTRY: String? = null,
    val PHOTO: String? = null,
    val BIRTHDAY: String? = null,
    val LANGUAGE: String? = null
)

data class Address(
    val addr1: String,
    val addr2: String,
    val city: String,
    val state: String,
    val zip: String,
    val country: String
)