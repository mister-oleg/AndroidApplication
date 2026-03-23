package com.example.electronicstudent.viewModel

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoadAvatarViewModel : ViewModel() {
    var uri by mutableStateOf<Uri?>(null)



    init {

    }
}