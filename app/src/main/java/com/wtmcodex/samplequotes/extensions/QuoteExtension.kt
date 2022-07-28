package com.wtmcodex.samplequotes.extensions

import com.wtmcodex.samplequotes.model.quote.Quote
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT_CURRENT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val DATE_FORMAT_NEW = "LLLL dd, yyyy"

fun Quote.getFormattedCreatedDate(): String =
    formatDateFromString(DATE_FORMAT_CURRENT, DATE_FORMAT_NEW, createdAt)


private fun formatDateFromString(
    inputFormat: String,
    outputFormat: String,
    inputDate: String?
): String {
    var parsed: Date?
    var outputDate = ""
    val dfInput = SimpleDateFormat(inputFormat, Locale.getDefault())
    val dfOutput = SimpleDateFormat(outputFormat, Locale.getDefault())
    try {
        parsed = dfInput.parse(inputDate)
        outputDate = dfOutput.format(parsed)
    } catch (e: ParseException) {
        print(e)
    }
    return outputDate
}