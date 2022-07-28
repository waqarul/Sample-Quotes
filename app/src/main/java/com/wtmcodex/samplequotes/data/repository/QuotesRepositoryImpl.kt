package com.wtmcodex.samplequotes.data.repository

import com.wtmcodex.samplequotes.data.base.Result
import com.wtmcodex.samplequotes.data.local.QuoteLocalDataSource
import com.wtmcodex.samplequotes.data.mapper.toDomain
import com.wtmcodex.samplequotes.data.remote.QuoteRemoteDataSource
import com.wtmcodex.samplequotes.di.scopes.IoDispatcher
import com.wtmcodex.samplequotes.model.quote.Quote
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val localDataSource: QuoteLocalDataSource,
    private val remoteDataSource: QuoteRemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : QuoteRepository {

    override suspend fun getQuotes(
        language: String,
        uid: String
    ): Result<Quote?> =
        withContext(ioDispatcher) {
            try {
                return@withContext when (val response =
                    remoteDataSource.getQuotes(language, uid)) {
                    is Result.Success -> {
                        if (response.data != null) {
                            val result = response.data.toDomain()
                            Result.Success(result)
                        } else {
                            Result.Success(null)
                        }
                    }
                    is Result.Error -> {
                        Result.Error(response.exception)
                    }
                    else -> Result.Success(null)
                }
            } catch (ex: Exception) {
                Result.Error(ex)
            }
        }
}
