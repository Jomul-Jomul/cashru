package kr.ac.tukorea.cashru.quiz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.quiz3.*
import kr.ac.tukorea.cashru.R

class Quiz3 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.quiz3))

        title = "Quiz3"
        btn_Quiz3_1.setOnClickListener {
            Toast.makeText(this, "정답", Toast.LENGTH_SHORT).show()
        }
        btn_Quiz3_2.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
        btn_Quiz3_3.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
        btn_Quiz3_4.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
    }
}