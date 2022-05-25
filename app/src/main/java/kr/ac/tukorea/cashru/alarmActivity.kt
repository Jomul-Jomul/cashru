package com.example.cashru

import android.app.Activity
import android.os.Bundle
import android.widget.Switch
import kr.ac.tukorea.cashru.R

class alarmActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm)

        var eventswitch : Switch
        var saveswitch : Switch
        var benefitswitch : Switch

        eventswitch = findViewById<Switch>(R.id.eventswitch)
        saveswitch = findViewById<Switch>(R.id.saveswitch)
        benefitswitch = findViewById<Switch>(R.id.benefitswitch)

        eventswitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                // 이벤트 스위치 ON 일때
            }
            else {
                // 이베트 스위치 off 일때
            }
        }

        saveswitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                // 적립 스위치 ON 일때
            }
            else {
                // 적립 스위치 off 일때
            }
        }

        benefitswitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                // 혜택 스위치 ON 일때
            }
            else {
                // 혜택 스위치 off 일때
            }
        }

    }
}