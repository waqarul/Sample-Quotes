package com.wtmcodex.samplequotes.data.repository

import com.wtmcodex.samplequotes.data.base.Result
import com.wtmcodex.samplequotes.model.quote.Quote

interface QuoteRepository {
    suspend fun getQuotes(language: String, uid: String): Result<Quote?>
}