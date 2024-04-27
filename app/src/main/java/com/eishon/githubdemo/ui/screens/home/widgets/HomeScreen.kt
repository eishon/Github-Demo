package com.eishon.githubdemo.ui.screens.home.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eishon.githubdemo.ui.screens.home.data.HomeUiState

@Composable
fun HomeScreen(uiState: HomeUiState) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp)
            )
            return
        }

        if (uiState.isError) {
            Text(text = uiState.errorMessage)
            return
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(
                    items = uiState.data,
                    itemContent = { repo ->
                        Column {
                            Text(text = repo.name)
                            HorizontalDivider()
                        }
                    }
                )
            }
        }
    }
}