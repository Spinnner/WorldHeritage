package com.spinner.worldheritage.domain.repository

import com.spinner.worldheritage.domain.model.HeritageSite

interface HeritageRepository {

    suspend fun getHeritageSites(): List<HeritageSite>
}