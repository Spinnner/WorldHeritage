package com.spinner.worldheritage.domain.usecase

import com.spinner.worldheritage.common.ResourceState
import com.spinner.worldheritage.domain.model.HeritageSite
import com.spinner.worldheritage.domain.repository.HeritageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class GetHeritageSitesUseCase @Inject constructor(
    private val repository: HeritageRepository
) {

    operator fun invoke(): Flow<ResourceState<List<HeritageSite>>> = flow {
        try {
            emit(ResourceState.Loading())
            val coins = repository.getHeritageSites()
            emit(ResourceState.Success(coins))
        } catch(e: IOException) {
            emit(ResourceState.Error(message = "A problem occurred while opening file: \n${e.message}"))
        }
    }.flowOn(Dispatchers.IO)
}