package com.wtmcodex.samplequotes.utils

class StringUtil {
    companion object {
        fun getRandomString(size: Int = 4): String = List(size) {
            (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
        }.joinToString("")
    }
}