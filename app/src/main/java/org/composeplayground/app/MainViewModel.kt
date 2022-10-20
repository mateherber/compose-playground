package org.composeplayground.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.random.Random
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val random = Random(System.currentTimeMillis())
    private val _state = MutableStateFlow<MainState>(MainState.Welcome)
    val state = _state.asStateFlow()

    fun load() {
        _state.value = MainState.Loading
        viewModelScope.launch {
            delay(5000)
            _state.value =
                MainState.Items((1..1000).map { Item(random.nextLong(0xFFFFFFFF), "Item $it") })
        }
    }
}

sealed interface MainState {

    object Welcome : MainState
    object Loading : MainState
    data class Items(val items: List<Item>) : MainState
}

data class Item(val color: Long, val title: String)
