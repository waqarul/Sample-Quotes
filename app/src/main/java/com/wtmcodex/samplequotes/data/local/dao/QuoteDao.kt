package com.wtmcodex.samplequotes.data.local.dao

import androidx.room.*
import com.wtmcodex.samplequotes.constants.DatabaseConstants
import com.wtmcodex.samplequotes.data.local.entity.QuoteEntity

@Dao
interface QuoteDao : BaseDao<QuoteEntity> {
    @Insert
    suspend fun insertQuote(quote: QuoteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuote(quote: QuoteEntity)

    @Query(DatabaseConstants.QUERY_SELECT_QUOTES)
    suspend fun getAllQuotes(): List<QuoteEntity>?

    @Query(DatabaseConstants.QUERY_SELECT_QUOTES_BY_ID)
    suspend fun getQuoteByID(id: String): QuoteEntity?

    @Query(DatabaseConstants.QUERY_DELETE_QUOTES)
    suspend fun deleteAllQuotes()
}