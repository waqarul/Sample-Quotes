package com.wtmcodex.samplequotes.data.remote

import com.wtmcodex.samplequotes.data.base.Result
import com.wtmcodex.samplequotes.model.network.QuoteDTO

interface QuoteRemoteDataSource {
    suspend fun getQuotes(language: String, uid: String): Result<QuoteDTO?>
}