package com.example.electronicstudent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.electronicstudent.ui.theme.ElectronicStudentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ElectronicStudentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenEnter(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenEnter(modifier: Modifier = Modifier) {
    Box(modifier = Modifier, contentAlignment = Alignment.Center)
    {
    Image(
        painter = ColorPainter(colorResource(R.color.background)),
        contentDescription = "background"
    )
    Image(
        painter = ColorPainter(colorResource(R.color.background2)),
        contentDescription = "background",
        modifier = Modifier.padding(20.dp, 40.dp).clip(RoundedCornerShape(30.dp))
    )
        Column(verticalArrangement = Arrangement.Center)
        {
            Text(
                stringResource(R.string.text_welcome),
                Modifier.background(colorResource(R.color.textBackground)).clip(RoundedCornerShape(20.dp)),
                fontSize = 5.em
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenEnterPreview() {
    ElectronicStudentTheme {
        ScreenEnter(Modifier.fillMaxSize())
    }
}