package com.github.ephelsa.yapecodechallenge.shared.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.R
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    onBackButtonClick: VoidCallback,
    title: String,
) {
    BoxWithConstraints(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .height(62.dp)
            .padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = stringResource(
                    id = R.string.cd_navigate_back
                ),
                modifier = Modifier
                    .weight(1f, fill = false)
                    .padding(8.dp)
                    .size(24.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onBackButtonClick),
                tint = MaterialTheme.colorScheme.onPrimary,
            )

            Text(
                text = title,
                modifier = Modifier
                    .weight(3f),
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimary),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    }
}