package com.wtmcodex.samplequotes.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wtmcodex.samplequotes.R
import com.wtmcodex.samplequotes.data.base.ScreenState
import com.wtmcodex.samplequotes.extensions.getFormattedCreatedDate
import com.wtmcodex.samplequotes.model.quote.Quote
import com.wtmcodex.samplequotes.ui.common.ErrorItem
import com.wtmcodex.samplequotes.ui.common.HomeAppBar
import com.wtmcodex.samplequotes.ui.common.LoadingView
import com.wtmcodex.samplequotes.ui.common.RadioGroup
import com.wtmcodex.samplequotes.ui.theme.AppColor

@Composable
fun HomeScreen(
    openSearch: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    Scaffold(topBar = {
        HomeAppBar(
            title = stringResource(id = R.string.home_app_bar_title),
            searchClick = { openSearch.invoke() }
        )
    },
        scaffoldState = scaffoldState,
        content = {
            HomeScreen(viewModel)
        }
    )
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.uiState.collectAsState()

    when (state.screenState) {
        is ScreenState.Loading -> {
            LoadingView(modifier = Modifier.fillMaxSize())
        }
        is ScreenState.Error -> {
            ErrorItem {
                viewModel.getQuote()
            }
        }
        is ScreenState.Success -> {
            state.quote?.let {
                QuoteDetails(
                    quote = it,
                    languages = state.languages,
                    buttonClick = { viewModel.getQuote() },
                    onOptionSelected = { viewModel.setLanguage(it) }
                )
            }
        }
    }
}

@Composable
fun QuoteDetails(
    quote: Quote,
    languages: List<LanguageViewItem>?,
    buttonClick: () -> Unit,
    onOptionSelected: (LanguageViewItem) -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .testTag("QuoteDetailsParent")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Text(
                text = quote.text,
                style = typography.displayMedium
            )
            Text(
                text = stringResource(id = R.string.home_screen_quote_create_date),
                style = typography.headlineLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = quote.getFormattedCreatedDate(),
                style = typography.bodyLarge
            )
            RadioGroup(
                title = stringResource(id = R.string.home_screen_choose_language),
                modifier = Modifier.padding(top = 16.dp),
                options = languages,
                onOptionSelected = onOptionSelected
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                onClick = buttonClick,
                colors = ButtonDefaults.buttonColors(containerColor = AppColor)
            ) {
                Text(
                    text = stringResource(id = R.string.home_screen_next_quote),
                    style = typography.labelLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteDetailsPreview() {

    QuoteDetails(
        quote = Quote("1", "Dummy text", "en", "2019-04-25T17:30:23.983Z"),
        languages = null,
        buttonClick = { },
        onOptionSelected = { }
    )
}