package com.example.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GradientCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .gradientBackground(
                colors = listOf(Color.Blue, Color.Cyan),
                direction = GradientDirection.TopToBottom
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Gradient Card", style = MaterialTheme.typography.headlineSmall)
            Text("Custom styling", style = MaterialTheme.typography.bodyMedium)
        }
    }
}


fun Modifier.gradientBackground(
    colors: List<Color>,
    direction: GradientDirection = GradientDirection.StartToEnd
) = this.then(
    Modifier
        .background(
            brush = Brush.linearGradient(
                colors = colors,
                start = when (direction) {
                    GradientDirection.StartToEnd -> Offset.Zero
                    GradientDirection.TopToBottom -> Offset(0f, Float.POSITIVE_INFINITY)
                },
                end = when (direction) {
                    GradientDirection.StartToEnd -> Offset(Float.POSITIVE_INFINITY, 0f)
                    GradientDirection.TopToBottom -> Offset(0f, 0f)
                }
            )
        )
        .shadow(4.dp, RoundedCornerShape(8.dp))
)

enum class GradientDirection {
    StartToEnd,
    TopToBottom,
}

@Preview(showBackground = true)
@Composable
fun GradientCardPreview() {
    MaterialTheme {
        GradientCard()
    }
}
