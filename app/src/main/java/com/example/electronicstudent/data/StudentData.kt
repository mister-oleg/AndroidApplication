package com.example.electronicstudent.data

import android.media.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter

data class StudentData(
    var code: String,
    var name: String,
    var group: String,
    var college: String,
    var avatar: ImageBitmap
)
