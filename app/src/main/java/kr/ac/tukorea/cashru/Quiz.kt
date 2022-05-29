package kr.ac.tukorea.cashru

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class Quiz : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_main))
        title = "Quiz"

        val event_quiz = arrayOf("퀴즈 1", "퀴즈 2", "퀴즈 3")

        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, event_quiz)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent: Intent? = when (position){
                0-> Intent(this, Quiz1::class.java)
                1-> Intent(this, Quiz2::class.java)
                2-> Intent(this, Quiz3::class.java)
                else -> {null}
            }
            startActivity(intent)
        }
    }
}



