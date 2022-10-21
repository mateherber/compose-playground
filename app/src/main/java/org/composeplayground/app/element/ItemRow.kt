package org.composeplayground.app.element

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.composeplayground.app.theme.CombinedPreviews
import org.composeplayground.app.theme.ComposePlaygroundPreview
import org.composeplayground.app.theme.spacing

@Composable
fun ItemRow(modifier: Modifier = Modifier, color: Long, title: String) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color(color))
                .size(80.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@CombinedPreviews
@Composable
fun ItemRowPreview() {
    ComposePlaygroundPreview {
        ItemRow(color = 0xFFAABBCC, title = "Preview Item")
    }
}