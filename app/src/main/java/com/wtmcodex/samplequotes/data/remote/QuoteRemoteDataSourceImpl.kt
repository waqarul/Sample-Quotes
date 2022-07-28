package com.wtmcodex.samplequotes.data.remote

import com.wtmcodex.samplequotes.data.base.Result
import com.wtmcodex.samplequotes.data.remote.retrofit.QuoteApiService
import com.wtmcodex.samplequotes.di.scopes.IoDispatcher
import com.wtmcodex.samplequotes.model.network.QuoteDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteRemoteDataSourceImpl @Inject constructor(
    private val apiService: QuoteApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) :
    QuoteRemoteDataSource {
    override suspend fun getQuotes(language: String, uid: String): Result<QuoteDTO?> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = apiService.getQuotes(language, uid)
                if (result.isSuccessful) {
                    val data = result.body()?.data
                    Result.Success(data)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
}