package com.spinner.worldheritage.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.spinner.worldheritage.data.Utils
import com.spinner.worldheritage.data.dto.HeritageSiteDto
import com.spinner.worldheritage.data.dto.toHeritageSite
import com.spinner.worldheritage.domain.model.HeritageSite
import com.spinner.worldheritage.domain.repository.HeritageRepository
import javax.inject.Inject

class HeritageRepositoryImpl @Inject constructor(private val context: Context): HeritageRepository {

    override suspend fun getHeritageSites(): List<HeritageSite> {
        val jsonString = Utils.loadJSONFromAsset(context, "data.json")
        return jsonString.toHeritageDtoList().map { it.toHeritageSite() }
    }

    private fun String.toHeritageDtoList(): List<HeritageSiteDto> {
        val listType = object : TypeToken<List<HeritageSiteDto?>?>() {}.type
        return Gson().fromJson(this, listType)
    }
}