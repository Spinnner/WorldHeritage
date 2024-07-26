package com.spinner.worldheritage.domain.common

import com.spinner.worldheritage.domain.model.HeritageSite

object CommonMockResponseFactory {

    fun createHeritageList(): List<HeritageSite> {
        return mutableListOf<HeritageSite>().apply {
            add(
                HeritageSite(
                    id = "1",
                    year = 1978,
                    name = "Aachen Cathedral",
                    regionLong = "Europe and North America",
                    image = "https://whc.unesco.org/uploads/thumbs/site_0009_0001-1000-750-20151104173658.jpg"
                )
            )
            add(
                HeritageSite(
                    id = "2",
                    year = 1979,
                    name = "Independence Hall",
                    regionLong = "Europe and North America",
                    image = "https://whc.unesco.org/uploads/thumbs/site_0078_0003-750-750-20160810112655.jpg",
                )
            )
        }
    }
}