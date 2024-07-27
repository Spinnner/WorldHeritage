package com.spinner.worldheritage.presentation.screen.heritage_sites

import com.spinner.worldheritage.domain.model.HeritageSite

data class HeritageListState(
    val isLoading: Boolean = false,
    val sites: List<HeritageSite> = emptyList(),
    val error: String = ""
)