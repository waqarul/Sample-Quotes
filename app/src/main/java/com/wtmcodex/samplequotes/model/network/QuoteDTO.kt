package com.wtmcodex.samplequotes.model.network

import com.google.gson.annotations.SerializedName

data class QuoteDTO(
    @SerializedName("id") val id: String,
    @SerializedName("text") val text: String,
    @SerializedName("lang") val language: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)