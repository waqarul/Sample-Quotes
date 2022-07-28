package com.wtmcodex.samplequotes.ui.features.home

import com.wtmcodex.samplequotes.data.base.ScreenState
import com.wtmcodex.samplequotes.model.quote.Quote

data class HomeScreenState(
    val screenState: ScreenState = ScreenState.Loading,
    val quote: Quote? = null,
    val languages: List<LanguageViewItem>? = null,
    val error: String? = null,
) {
    companion object {
        val Empty = HomeScreenState()
    }
}
