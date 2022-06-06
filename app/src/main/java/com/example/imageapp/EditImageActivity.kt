package com.example.imageapp

import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class EditImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_image)
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageBitmap(Image.image)
        val bRotate = findViewById<Button>(R.id.button)
        bRotate.setOnClickListener {
            val matrix = Matrix()
            matrix.postRotate(90F)

            val rotated = Bitmap.createBitmap(
                Image.image!!, 0, 0, Image.image!!.getWidth(), Image.image!!.getHeight(),
                matrix, true
            )
            Image.image = rotated

            imageView.setImageBitmap(rotated)
        }
    }
}