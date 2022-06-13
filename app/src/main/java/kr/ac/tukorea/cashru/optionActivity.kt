package kr.ac.tukorea.cashru

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class optionActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.option)
        title="옵션 메뉴"
        var optionimage : ImageButton
        var optionname : TextView
        var optionpoint : TextView
        var optionswitch : Switch
        var btnalarm : Button
        var btncoupon : Button
        var btnnotice : Button
        var btninstruction : Button
        var btnservice : Button
        var btnlogout : Button
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav_view)

        optionimage = findViewById<ImageButton>(R.id.optionimage)
        optionname = findViewById<TextView>(R.id.optionname)
        optionpoint = findViewById<TextView>(R.id.optionpoint)
        optionswitch = findViewById<Switch>(R.id.optionswitch)
        btncoupon = findViewById<Button>(R.id.btncoupon)
        btninstruction = findViewById<Button>(R.id.btninstruction)
        btnlogout = findViewById<Button>(R.id.btnlogout)

        optionswitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                // 첫화면 스위치 ON 일때
            }
            else {
                // 첫화면 스위치 off 일때
            }
        }


        btncoupon.setOnClickListener {
            var couponintent = Intent(applicationContext,couponActivity::class.java)
            startActivity(couponintent)
        } // 쿠폰 화면으로 전환

        btninstruction.setOnClickListener {
            var instructionintent = Intent(applicationContext, manualActivity::class.java)
            startActivity(instructionintent)
        } // 캐시이용설명서 화면으로 전환

        btnlogout.setOnClickListener {
            var intent = Intent(applicationContext, loginActivity::class.java)
            startActivity(intent)
        }
        bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_event -> {
                    val intent = Intent(this,EventPage::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_transfer -> {
                    val intent = Intent(this,TransferMain::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_settings -> {
                    val intent = Intent(this,optionActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }
}