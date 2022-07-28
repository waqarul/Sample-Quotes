package com.wtmcodex.samplequotes.model.network

import com.google.gson.annotations.SerializedName


class BaseDTO<T>(
    @SerializedName("data") var data: T? = null
)