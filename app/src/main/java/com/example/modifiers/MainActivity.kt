package com.example.modifiers

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ModifiedText() {
    Text(
        text = "Hello, Compose!",
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Blue)
            .fillMaxWidth()
    )
}

@Composable
fun FormField() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun AlignedContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Centered Text",
            Modifier.align(Alignment.TopStart)
        )
    }
}

@Composable
fun SizedButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .widthIn(min = 10.dp, max = 200.dp)
            .padding(40.dp)

    ) {
        Text("Click Me")
    }
}

@Composable
fun ClickableCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }
            .border(
                1.dp,
                Color.Gray,
                RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            "Clickable Card",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ResponsiveText() {
    BoxWithConstraints {
        val textSize = if (maxWidth < 600.dp) 16.sp else 24.sp
        Text(
            "Responsive Text",
            fontSize = textSize,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun OrientationAwareLayout() {
    val configuration = LocalConfiguration.current

    if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Row(modifier = Modifier.fillMaxSize()) {  }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {  }
    }
}

@Composable
fun WeightedLayout() {
    Row(modifier = Modifier.fillMaxWidth()){
        Text("Left", modifier = Modifier.weight(1f))
        Text("Right", modifier = Modifier.weight(1f))
    }
}

@Composable
fun AccessibleButton() {
    Button(
        onClick = {},
        modifier = Modifier.semantics{
            contentDescription = "Submit Form"
        }
    ) {
        Text("Submit", fontSize = 16.sp)
    }
}


// Previews
@Composable
@Preview(showBackground = true)
fun ModifiedTextPreview() {
    ModifiedText()
}

@Composable
@Preview(showBackground = true)
fun FormFieldPreview() {
    FormField()
}

@Composable
@Preview(showBackground = true)
fun AlignedContentPreview() {
    AlignedContent()
}

@Composable
@Preview(showBackground = true)
fun SizedButtonPreview() {
    SizedButton()
}

@Composable
@Preview(showBackground = true)
fun ClickableCardPreview() {
    ClickableCard()
}

@Composable
@Preview(showBackground = true)
fun ResponsiveTextPreview() {
    ResponsiveText()
}

//@Composable
//@Preview(showBackground = true)
//fun OrientationAwareLayoutPreview() {
//    OrientationAwareLayout()
//}

@Composable
@Preview(showBackground = true)
fun WeightedLayoutPreview() {
    WeightedLayout()
}

@Composable
@Preview(showBackground = true)
fun AccessibleButtonPreview() {
    AccessibleButton()
}