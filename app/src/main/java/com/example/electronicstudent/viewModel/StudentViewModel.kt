package com.example.electronicstudent.viewModel

import android.content.ContentResolver
import android.content.Context
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.ViewModel
import com.example.electronicstudent.R
import com.example.electronicstudent.data.StudentData
import com.example.electronicstudent.data.StudentRepository

class StudentViewModel : ViewModel() {
    private val studentRepository = StudentRepository()
    var studentData by mutableStateOf(StudentData("", "", "", "", ImageBitmap(10,10)))

    fun getStudentData(id: String) : Boolean{
        studentData = studentRepository.getStudent(id)
        return studentData.code != "-1"
    }

    fun setAvatar(context: Context, uri: Uri?){
        if (uri == null)
            return

        if (Build.VERSION.SDK_INT >= 28) {
            val source = ImageDecoder.createSource(context.contentResolver, uri)
            val bitmap = ImageDecoder.decodeBitmap(source)
            studentData.avatar = bitmap.asImageBitmap()
            studentData.name = "dadadadadadadadada"
            Log.i("setAvatar", studentData.avatar.toString())
        }
    }
}