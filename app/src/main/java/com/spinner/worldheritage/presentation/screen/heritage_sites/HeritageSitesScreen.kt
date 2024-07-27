package com.spinner.worldheritage.presentation.screen.heritage_sites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.spinner.worldheritage.domain.common.CommonMockResponseFactory
import com.spinner.worldheritage.presentation.ui.UIModePreviews

@Composable
fun HeritageSitesScreen(
    viewModel: HeritageSitesViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    HeritageListContentView(state.value)
}

@Composable
private fun HeritageListContentView(state: HeritageListState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)) {
            items(state.sites) { site ->
                HeritageSiteItemView(site = site)
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@UIModePreviews
@Composable
private fun HeritageListContentPreview() {
    val sites = CommonMockResponseFactory.createHeritageList()
    HeritageListContentView(state = HeritageListState(sites = sites))
}