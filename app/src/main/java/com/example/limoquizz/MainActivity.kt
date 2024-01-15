package com.example.limoquizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.limoquizz.ui.mode.ChoiceModeActivity

class MainActivity : AppCompatActivity() {

    lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        start=findViewById(R.id.start)
        start.setOnClickListener {
            var intent= Intent(this, ChoiceModeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}