package com.wtmcodex.samplequotes.constants

interface DatabaseConstants {
    companion object {
        const val DATABASE_NAME = "QUOTESDatabase.db"
        const val TABLE_QUOTES = "QUOTES"
        const val QUERY_SELECT_QUOTES = "SELECT * FROM $TABLE_QUOTES"
        const val QUERY_SELECT_QUOTES_BY_ID = "SELECT * FROM $TABLE_QUOTES WHERE id=:id "
        const val QUERY_DELETE_QUOTES = "DELETE FROM $TABLE_QUOTES"
    }
}