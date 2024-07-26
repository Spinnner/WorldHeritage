package com.spinner.worldheritage.presentation.screen.heritage_sites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.spinner.worldheritage.domain.common.CommonMockResponseFactory
import com.spinner.worldheritage.domain.model.HeritageSite
import com.spinner.worldheritage.presentation.ui.UIModePreviews

@Composable
fun HeritageSiteItemView(
    modifier: Modifier = Modifier,
    site: HeritageSite,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Text(
            text = "${site.name} (${site.year})",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Region: ${site.regionLong}",
            color = Color.Yellow,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            modifier = Modifier.size(24.dp),
            model = site.image,
            error = painterResource(id = android.R.drawable.stat_notify_error),
            contentDescription = null,
        )
    }
}

@UIModePreviews
@Composable
private fun HeritageSiteItemPreview() {
    val item = CommonMockResponseFactory.createHeritageList().first()
    HeritageSiteItemView(modifier = Modifier.background(Color.Black), site = item)
}
