package com.eishon.githubdemo.ui.screens.home.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.eishon.githubdemo.ui.screens.home.data.HomeUiState

@Composable
fun HomeScreen(uiState: HomeUiState) {
    Column {
        uiState.data.forEach {
            Text(text = it.name)
            HorizontalDivider()
        }
    }
}