package com.example.cashru

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import kr.ac.tukorea.cashru.R
import kr.ac.tukorea.cashru.couponActivity

class optionActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.option)
        title="옵션 메뉴"
        var optionimage : ImageButton
        var optionname : EditText
        var optionname2 : EditText
        var optionpoint : EditText
        var optionswitch : Switch
        var btnalarm : Button
        var btncoupon : Button
        var btnnotice : Button
        var btninstruction : Button
        var btnservice : Button
        var btnlogout : Button

        optionimage = findViewById<ImageButton>(R.id.optionimage)
        optionname = findViewById<EditText>(R.id.optionname)
        optionname2 = findViewById<EditText>(R.id.optionname2)
        optionpoint = findViewById<EditText>(R.id.optionpoint)
        optionswitch = findViewById<Switch>(R.id.optionswitch)
        btnalarm = findViewById<Button>(R.id.btnalarm)
        btncoupon = findViewById<Button>(R.id.btncoupon)
        btnnotice = findViewById<Button>(R.id.btnnotice)
        btninstruction = findViewById<Button>(R.id.btninstruction)
        btnservice = findViewById<Button>(R.id.btnservice)
        btnlogout = findViewById<Button>(R.id.btnlogout)

        optionswitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                // 첫화면 스위치 ON 일때
            }
            else {
                // 첫화면 스위치 off 일때
            }
        }

        btnalarm.setOnClickListener {
            var alarmintent = Intent(applicationContext,alarmActivity::class.java )
            startActivity(alarmintent)
        }

        btncoupon.setOnClickListener {
            var couponintent = Intent(applicationContext,couponActivity::class.java)
            startActivity(couponintent)
        }
        btninstruction.setOnClickListener {
            var instructionintent = Intent(applicationContext,manualActivity::class.java)
            startActivity(instructionintent)
        }
    }
}