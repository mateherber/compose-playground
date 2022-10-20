package org.composeplayground.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.composeplayground.app.theme.CombinedPreviews
import org.composeplayground.app.theme.ComposePlaygroundPreview
import org.composeplayground.app.theme.spacing

@Composable
fun MainScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello Compose",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineLarge
        )
        Button(
            modifier = Modifier.padding(top = MaterialTheme.spacing.small),
            onClick = onClick
        ) {
            Text(text = "Load")
        }
    }
}

@CombinedPreviews
@Composable
fun TransferSummaryScreenPreview() {
    ComposePlaygroundPreview {
        MainScreen {}
    }
}