package com.spinner.worldheritage.data

import android.content.Context
import okio.buffer
import okio.source
import java.nio.charset.Charset

object Utils {

    fun loadJSONFromAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val source = inputStream.source().buffer()
            source.readByteString().string(Charset.forName("utf-8"))
        }
    }
}