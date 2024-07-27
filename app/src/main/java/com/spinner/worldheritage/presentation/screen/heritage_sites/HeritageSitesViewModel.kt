package com.spinner.worldheritage.presentation.screen.heritage_sites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spinner.worldheritage.common.ResourceState
import com.spinner.worldheritage.domain.usecase.GetHeritageSitesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeritageSitesViewModel @Inject constructor(private val useCase: GetHeritageSitesUseCase) : ViewModel() {

    private val _state = MutableStateFlow(HeritageListState())
    val state = _state.asStateFlow()

    init {
        getHeritageSitesList()
    }

    private fun getHeritageSitesList() {
        viewModelScope.launch {
            useCase().collect { result ->
                when (result) {
                    is ResourceState.Success -> {
                        _state.value = HeritageListState(sites = result.data ?: emptyList())
                    }

                    is ResourceState.Error -> {
                        _state.value = HeritageListState(error = result.message ?: "An unexpected error occured")
                    }

                    is ResourceState.Loading -> {
                        _state.value = HeritageListState(isLoading = true)
                    }
                }
            }
        }
    }
}