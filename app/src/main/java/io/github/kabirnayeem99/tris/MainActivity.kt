package io.github.kabirnayeem99.tris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val buttonSelected = view as Button

//        Toast.makeText(this, "${buttonSelected.id} selected", Toast.LENGTH_SHORT).show()

        var cellId = 0
        when (buttonSelected.id) {
            R.id.btnFirstCFirstR -> cellId = 1
            R.id.btnSecondCFirstR -> cellId = 2
            R.id.btnThirdCFirstR -> cellId = 3
            R.id.btnFirstCSecondR -> cellId = 4
            R.id.btnSecondCSecondR -> cellId = 5
            R.id.btnThirdCSecondR -> cellId = 6
            R.id.btnFirstCThirdR -> cellId = 7
            R.id.btnSecondCThirdR -> cellId = 8
            R.id.btnThirdCThirdR -> cellId = 9
        }

        Toast.makeText(this, "cellID: $cellId", Toast.LENGTH_SHORT).show()
    }
}