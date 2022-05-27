package kr.ac.tukorea.cashru

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kr.ac.tukorea.cashru.R

class couponActivity:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coupon)

        var editcoupon : EditText
        var btncoupon : Button

        var numcoupon : String = "sdas"

        editcoupon = findViewById<EditText>(R.id.editcoupon)
        btncoupon = findViewById<Button>(R.id.btncoupon)

        btncoupon.setOnClickListener {
            if(numcoupon == editcoupon.text.toString())
                // 적립
            else
                Toast.makeText(applicationContext,"쿠폰 번호가 틀렸습니다.",Toast.LENGTH_SHORT).show()
        }
    }
}