package com.wtmcodex.samplequotes.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wtmcodex.samplequotes.constants.DatabaseConstants

@Entity(tableName = DatabaseConstants.TABLE_QUOTES)
class QuoteEntity(
    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey val id: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "lang") val language: String,
    @ColumnInfo(name = "created_at") val createdAt: String,
    @ColumnInfo(name = "updated_at") val updatedAt: String
)