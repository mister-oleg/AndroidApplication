package com.example.electronicstudent

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
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
    var message by remember { mutableStateOf("Поле ввода\nкода") }

    Box(modifier = Modifier, contentAlignment = Alignment.Center)
    {
    Image(
        painter = ColorPainter(colorResource(R.color.background)),
        contentDescription = "background"
    )
    Box(modifier = Modifier.padding(20.dp, 40.dp)) {
    Image(
        painter = ColorPainter(colorResource(R.color.background2)),
        contentDescription = "background",
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
    )
        Column(verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        )
        {
            Text(
                stringResource(R.string.text_welcome),
                Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(colorResource(R.color.textBackground)),
                fontSize = 5.em,
                textAlign = TextAlign.Center
            )

            TextField(value = message, {newtext -> message = newtext},
                Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .size(150.dp, 70.dp),
                colors = TextFieldDefaults.colors(focusedContainerColor = colorResource(R.color.textBackground), unfocusedContainerColor = colorResource(R.color.textBackground)),
                textStyle = TextStyle(fontSize = 4.em, textAlign = TextAlign.Center)
            )
            /*Text(
                stringResource(R.string.text_field_enter),
                Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(colorResource(R.color.textBackground)),
                fontSize = 5.em,
                textAlign = TextAlign.Center
            )*/

            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button), contentColor = Color.Black))
            {
                Text(text = stringResource(R.string.text_enter),
                    fontSize = 5.em
                    )

            }
        }
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