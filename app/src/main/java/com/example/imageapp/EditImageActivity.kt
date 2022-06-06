package com.example.imageapp

import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class EditImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_image)
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageBitmap(Image.image)
        val bRotate = findViewById<Button>(R.id.button)
        val bUndo = findViewById<Button>(R.id.bUndo)

        bRotate.setOnClickListener {
            val matrix = Matrix()
            matrix.postRotate(90F)

            val rotated = Bitmap.createBitmap(
                Image.image!!, 0, 0, Image.image!!.getWidth(), Image.image!!.getHeight(),
                matrix, true
            )
            Image.images.push(rotated)
            Image.image = rotated
            imageView.setImageBitmap(rotated)
        }

        bUndo.setOnClickListener {
            val currImage = Image.images.peek()
            Image.images.pop()
            if(Image.images.isEmpty()){
                Toast.makeText(this, "Cannot do Undo", Toast.LENGTH_SHORT).show()
                Image.images.push(currImage)
            }else{
                imageView.setImageBitmap(Image.images.peek())
            }
        }
    }
}