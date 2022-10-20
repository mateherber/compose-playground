package org.composeplayground.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.composeplayground.app.theme.CombinedPreviews
import org.composeplayground.app.theme.ComposePlaygroundPreview
import org.composeplayground.app.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val mainState by viewModel.state.collectAsStateWithLifecycle()
    MainScreen(mainState, viewModel::load)
}

@Composable
fun MainScreen(state: MainState, onClick: () -> Unit) {
    when (state) {
        is MainState.Items -> {
            LazyColumn(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
            ) {
                items(state.items, { it.title }) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color(item.color))
                                .size(80.dp)
                        )
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }

        MainState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        MainState.Welcome -> Column(
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
}

@CombinedPreviews
@Composable
fun MainScreenPreview() {
    ComposePlaygroundPreview {
        MainScreen(MainState.Welcome) {}
    }
}

@CombinedPreviews
@Composable
fun MainScreenLoading() {
    ComposePlaygroundPreview {
        MainScreen(MainState.Loading) {}
    }
}

@CombinedPreviews
@Composable
fun MainScreenContent() {
    ComposePlaygroundPreview {
        MainScreen(
            MainState.Items(
                listOf(
                    Item(0xFFAABBCC, "Item 1"),
                    Item(0xFFBBAACC, "Item 2"),
                    Item(0xFFBBCCAA, "Item 3"),
                )
            )
        ) {}
    }
}