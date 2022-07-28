package com.wtmcodex.samplequotes.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wtmcodex.samplequotes.data.base.Result
import com.wtmcodex.samplequotes.data.base.ScreenState
import com.wtmcodex.samplequotes.di.scopes.IoDispatcher
import com.wtmcodex.samplequotes.domain.GetQuoteUseCase
import com.wtmcodex.samplequotes.model.enum.SupportedLanguage
import com.wtmcodex.samplequotes.model.quote.Quote
import com.wtmcodex.samplequotes.utils.StringUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val quoteUseCase: GetQuoteUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel() {
    private val TAG = this::class.simpleName

    private var currentLanguage = SupportedLanguage.ENGLISH
    private val _viewModelState = MutableStateFlow(HomeScreenState.Empty)

    val uiState = _viewModelState
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            HomeScreenState.Empty
        )

    init {
        getQuote()
    }

    fun setLanguage(language: LanguageViewItem) {
        currentLanguage = SupportedLanguage.fromLanguage(language.code)
        _viewModelState.update {
            it.copy(
                languages = getSupportedLanguageList()
            )
        }
    }

    fun getQuote() {
        _viewModelState.update {
            it.copy(
                screenState = ScreenState.Loading
            )
        }

        viewModelScope.launch(ioDispatcher) {
            quoteUseCase(
                GetQuoteUseCase.Param(
                    language = currentLanguage.language,
                    StringUtil.getRandomString()
                )
            ).handle(
                onSuccess = { onQuoteFetchSuccess(it) },
                onError = { onQuoteFailedSuccess(it.localizedMessage) }
            )
        }
    }

    private fun onQuoteFetchSuccess(result: Result<Quote?>) {
        when (result) {
            is Result.Success -> {
                if (result.data != null) {
                    _viewModelState.update {
                        it.copy(
                            screenState = ScreenState.Success,
                            quote = result.data,
                            languages = getSupportedLanguageList(),
                            error = null
                        )
                    }
                } else {
                    onQuoteFailedSuccess("Please try again.")
                }
            }
            is Result.Error -> {
                onQuoteFailedSuccess(result.exception.localizedMessage)
            }
        }
    }

    private fun onQuoteFailedSuccess(error: String?) {
        _viewModelState.update {
            it.copy(
                screenState = ScreenState.Error,
                quote = null,
                error = error
            )
        }
    }

    private fun getSupportedLanguageList(): List<LanguageViewItem> {
        return SupportedLanguage.values().map {
            LanguageViewItem(it.getLanguageName(), it.language, it == currentLanguage)
        }
    }
}