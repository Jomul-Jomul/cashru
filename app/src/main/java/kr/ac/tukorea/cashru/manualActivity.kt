package com.example.cashru

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import kr.ac.tukorea.cashru.R

class manualActivity:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manual)

        var btnmanual : Button
        btnmanual = findViewById<Button>(R.id.btnmanual)

        btnmanual.setOnClickListener {
            var manualintent = Intent(applicationContext,optionActivity::class.java)
            startActivity(manualintent)
        }
    }
}