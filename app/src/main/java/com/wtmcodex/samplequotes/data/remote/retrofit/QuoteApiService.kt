package com.wtmcodex.samplequotes.data.remote.retrofit

import com.wtmcodex.samplequotes.constants.APIConstants
import com.wtmcodex.samplequotes.model.network.BaseDTO
import com.wtmcodex.samplequotes.model.network.QuoteDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApiService {
    @GET(APIConstants.GET_QUOTES)
    suspend fun getQuotes(
        @Query("lang") language: String,
        @Query("uid") uid: String
    ): Response<BaseDTO<QuoteDTO>>
}