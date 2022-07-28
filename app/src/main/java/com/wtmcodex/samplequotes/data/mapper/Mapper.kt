package com.wtmcodex.samplequotes.data.mapper

import com.wtmcodex.samplequotes.model.network.QuoteDTO
import com.wtmcodex.samplequotes.model.quote.Quote

fun QuoteDTO.toDomain(): Quote = Quote(
    id = id,
    text = text,
    language = language,
    createdAt = createdAt
)