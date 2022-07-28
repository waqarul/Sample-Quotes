package com.wtmcodex.samplequotes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wtmcodex.samplequotes.data.local.dao.QuoteDao
import com.wtmcodex.samplequotes.data.local.entity.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}