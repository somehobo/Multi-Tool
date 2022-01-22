package com.njbrady.multi_tool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var TipCalcDir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TipCalcDir = findViewById(R.id.TipCalculatorDir)
        TipCalcDir.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(Intent(this@MainActivity, TipCalc::class.java))
            }
        })
    }

}