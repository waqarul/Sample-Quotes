package com.wtmcodex.samplequotes.model.enum

enum class SupportedLanguage(val language: String) {
    ENGLISH("en") {
        override fun getLanguageName(): String = "English"
    },
    DUTCH("nl") {
        override fun getLanguageName(): String = "Dutch"
    },
    FRENCH("fr") {
        override fun getLanguageName(): String = "French"
    },
    GERMAN("de") {
        override fun getLanguageName(): String = "German"
    };

    abstract fun getLanguageName(): String

    companion object {
        fun fromLanguage(language: String) =
            values().firstOrNull() { it.language == language } ?: ENGLISH
    }
}