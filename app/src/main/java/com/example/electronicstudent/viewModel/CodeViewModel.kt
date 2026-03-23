package com.example.electronicstudent.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.electronicstudent.R

class CodeViewModel : ViewModel() {
    var codeText by mutableStateOf("")

    fun setCode(text: String){
        codeText = text
    }

}