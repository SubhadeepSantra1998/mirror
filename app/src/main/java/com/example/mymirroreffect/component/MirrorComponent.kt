package com.example.mymirroreffect.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.mymirroreffect.utils.HalfSizeShape


@Composable
fun Mirror(content: @Composable () -> Unit) {
    Column {
        content()
        Box(modifier = Modifier
            .graphicsLayer {
                alpha = 0.89f
                rotationX = 180f
            }
            .drawWithContent {
                val colors = listOf(Color.Transparent, Color.White)
                drawContent()
                drawRect(
                    brush = Brush.verticalGradient(colors),
                    blendMode = BlendMode.DstIn
                )
            }
            .blur(radiusX = 1.dp, radiusY = 3.dp, BlurredEdgeTreatment.Unbounded)
            .clip(
                HalfSizeShape
            )
        ) {
            content()
        }
    }
}