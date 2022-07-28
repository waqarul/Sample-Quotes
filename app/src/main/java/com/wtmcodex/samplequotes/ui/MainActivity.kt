package com.wtmcodex.samplequotes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wtmcodex.samplequotes.ui.features.SampleQuotesApp
import com.wtmcodex.samplequotes.ui.theme.SampleQuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleQuotesTheme {
                SampleQuotesApp()
            }
        }
    }
}