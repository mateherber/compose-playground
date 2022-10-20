package org.composeplayground.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.composeplayground.app.theme.CombinedPreviews
import org.composeplayground.app.theme.ComposePlaygroundPreview

@Composable
fun MainScreen() {
    Text(
        text = "Hello Compose",
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineLarge
    )
}

@CombinedPreviews
@Composable
fun TransferSummaryScreenPreview() {
    ComposePlaygroundPreview {
        MainScreen()
    }
}