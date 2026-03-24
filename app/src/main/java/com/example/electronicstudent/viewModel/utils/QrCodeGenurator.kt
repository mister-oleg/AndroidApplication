package com.example.electronicstudent.viewModel.utils

import android.graphics.Bitmap
import android.graphics.Color
import androidx.core.graphics.createBitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

class QrCodeGenurator {
    fun generateQrBitmap(text: String) : Bitmap{
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0..width){
            for (y in 0..height){
                bitmap [x,y] = if (bitMatrix.set(x, y)) Color.BLACK else Color.WHITE
            }
        }
    }
}