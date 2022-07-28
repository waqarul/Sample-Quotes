package com.wtmcodex.samplequotes.data.local

import com.wtmcodex.samplequotes.data.local.entity.QuoteEntity

interface QuoteLocalDataSource {
    suspend fun insertAll(quotes: List<QuoteEntity>)
    suspend fun insertOrUpdate(quote: QuoteEntity)
    suspend fun getAllQuotes(): List<QuoteEntity>?
    suspend fun getQuoteByID(id: String): QuoteEntity?
    suspend fun deleteAllQuotes()
}