package com.ohatv.app.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface OhaTVApiService {

    @GET("search")
    suspend fun searchContent(
        @Query("q") query: String
    ): SearchResponse

    @GET("item")
    suspend fun getContentDetails(
        @Query("id") contentId: String
    ): ContentDetailsResponse
}

data class SearchResponse(
    val results: List<ContentItem>
)

data class ContentItem(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String?,
    val type: String // "movie" or "series"
)

data class ContentDetailsResponse(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String?,
    val sources: List<StreamSource>
)

data class StreamSource(
    val name: String,
    val url: String,
    val language: String
)
