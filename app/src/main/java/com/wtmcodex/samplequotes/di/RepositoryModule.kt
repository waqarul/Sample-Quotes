package com.wtmcodex.samplequotes.di

import com.wtmcodex.samplequotes.data.repository.QuoteRepository
import com.wtmcodex.samplequotes.data.repository.QuotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindQuoteRepository(repository: QuotesRepositoryImpl): QuoteRepository
}