package kr.ac.tukorea.cashru

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Quiz1 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.quiz1))

        title = "Quiz1"

        var btn1 = findViewById<Button>(R.id.btn_Quiz1_1)
        var btn2 = findViewById<Button>(R.id.btn_Quiz1_2)
        var btn3 = findViewById<Button>(R.id.btn_Quiz1_3)
        var btn4 = findViewById<Button>(R.id.btn_Quiz1_4)

        btn1.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
        btn3.setOnClickListener {
            Toast.makeText(this, "정답", Toast.LENGTH_SHORT).show()
        }
        btn4.setOnClickListener {
            Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
        }
    }
}