package com.example.electronicstudent.data

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.imageResource
import com.example.electronicstudent.R

class StudentRepository {
    fun getStudent(id: String) : StudentData {
        return if (id == "321")
            StudentData("321", "Iatmanov Oleg", "ISP23A", "PEK", ImageBitmap(10,10))
        else
            StudentData("-1", "", "", "", ImageBitmap(10,10))
    }
}