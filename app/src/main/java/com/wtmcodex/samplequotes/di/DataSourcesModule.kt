package com.wtmcodex.samplequotes.di

import com.wtmcodex.samplequotes.data.local.QuoteLocalDataSource
import com.wtmcodex.samplequotes.data.local.QuoteLocalDataSourceImpl
import com.wtmcodex.samplequotes.data.remote.QuoteRemoteDataSource
import com.wtmcodex.samplequotes.data.remote.QuoteRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: QuoteLocalDataSourceImpl): QuoteLocalDataSource

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: QuoteRemoteDataSourceImpl): QuoteRemoteDataSource
}