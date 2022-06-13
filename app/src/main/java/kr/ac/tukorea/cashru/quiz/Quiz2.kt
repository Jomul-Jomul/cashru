package kr.ac.tukorea.cashru.quiz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.quiz2.*
import kr.ac.tukorea.cashru.R

class Quiz2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.quiz2))

        title = "Quiz2"

        btn_Quiz2.setOnClickListener {
            val answer = edt_Quiz2.text.toString()
            if(answer == "천문관")
            {
                Toast.makeText(this, "정답", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()
            }
        }
    }
}