package kr.ac.tukorea.cashru

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.quiz1.*

class Quiz1 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.quiz1))

        title = "Quiz1"

        btn_Quiz1_1.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
        btn_Quiz1_2.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
        btn_Quiz1_3.setOnClickListener {
            Toast.makeText(this, "정답", Toast.LENGTH_SHORT).show()
        }
        btn_Quiz1_4.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
    }
}