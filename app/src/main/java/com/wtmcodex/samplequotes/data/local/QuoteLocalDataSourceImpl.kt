package com.wtmcodex.samplequotes.data.local

import com.wtmcodex.samplequotes.data.local.dao.QuoteDao
import com.wtmcodex.samplequotes.data.local.entity.QuoteEntity
import com.wtmcodex.samplequotes.di.scopes.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteLocalDataSourceImpl @Inject constructor(
    private val quoteDao: QuoteDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : QuoteLocalDataSource {
    override suspend fun insertAll(quotes: List<QuoteEntity>) = withContext(ioDispatcher) {
        return@withContext quoteDao.insertAll(quotes)
    }

    override suspend fun insertOrUpdate(quote: QuoteEntity) =
        withContext(ioDispatcher) {
            val item = quoteDao.getQuoteByID(quote.id)
            if (item == null) {
                quoteDao.insertQuote(quote)
            } else {
                quoteDao.updateQuote(quote)
            }
        }

    override suspend fun getAllQuotes(): List<QuoteEntity>? =
        withContext(ioDispatcher) {
            return@withContext quoteDao.getAllQuotes()
        }

    override suspend fun getQuoteByID(id: String): QuoteEntity? =
        withContext(ioDispatcher) {
            return@withContext quoteDao.getQuoteByID(id)
        }

    override suspend fun deleteAllQuotes() = withContext(ioDispatcher) {
        return@withContext quoteDao.deleteAllQuotes()
    }
}