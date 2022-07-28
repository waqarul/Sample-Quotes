package com.wtmcodex.samplequotes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleQuotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}