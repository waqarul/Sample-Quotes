package com.wtmcodex.samplequotes.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.wtmcodex.samplequotes.model.enum.SupportedLanguage
import com.wtmcodex.samplequotes.ui.features.home.LanguageViewItem
import com.wtmcodex.samplequotes.ui.theme.AppColor
import com.wtmcodex.samplequotes.ui.theme.Gray300

@Composable
fun RadioGroup(
    title: String,
    modifier: Modifier,
    options: List<LanguageViewItem>?,
    onOptionSelected: (LanguageViewItem) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = typography.headlineLarge
        )
        options?.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = item.isSelected,
                    onClick = { onOptionSelected(item) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = AppColor,
                        unselectedColor = Gray300
                    )
                )
                ClickableText(
                    text = AnnotatedString(item.name),
                    style = typography.headlineSmall,
                    onClick = {
                        onOptionSelected(item)
                    }
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun RadioGroupPreview() {
    RadioGroup(
        title = "Choose Language",
        modifier = Modifier,
        options = SupportedLanguage.values().map {
            LanguageViewItem(it.getLanguageName(), it.language, false)
        },
        onOptionSelected = {}
    )
}