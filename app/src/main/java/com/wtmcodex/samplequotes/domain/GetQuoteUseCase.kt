package com.wtmcodex.samplequotes.domain

import com.wtmcodex.samplequotes.data.base.Result
import com.wtmcodex.samplequotes.data.base.UseCase
import com.wtmcodex.samplequotes.data.repository.QuoteRepository
import com.wtmcodex.samplequotes.di.scopes.IoDispatcher
import com.wtmcodex.samplequotes.model.quote.Quote
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) :
    UseCase<GetQuoteUseCase.Param, Result<Quote?>>(ioDispatcher) {

    override suspend fun execute(parameters: Param): Result<Quote?> {
        return repository.getQuotes(parameters.language, parameters.uid)
    }

    data class Param(
        val language: String,
        val uid: String
    )
}