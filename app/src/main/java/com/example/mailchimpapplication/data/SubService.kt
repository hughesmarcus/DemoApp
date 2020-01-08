package com.example.mailchimpapplication.data

import com.example.mailchimpapplication.data.models.ListsResponse
import com.example.mailchimpapplication.data.models.MembersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SubService {
    @GET("3.0/lists")
    suspend fun getLists(): Response<ListsResponse>

    @GET("3.0/lists/{list_id}/members")
    suspend fun getListMembers(@Path("list_id") listId: String): Response<MembersResponse>
}