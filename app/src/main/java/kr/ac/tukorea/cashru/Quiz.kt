package kr.ac.tukorea.cashru

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Quiz : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_main))
        title = "Quiz"

        var event_quiz = arrayOf("퀴즈 1", "퀴즈 2", "퀴즈 3", "퀴즈 4", "퀴즈 5")

        var list = findViewById<View>(R.id.listView) as ListView
        var adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, event_quiz)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            val intent: Intent?
            intent = when (position){
                0-> Intent(this, Quiz1::class.java)
                1-> Intent(this, QRCode::class.java)
                2-> Intent(this, Com::class.java)
                else -> {null}
            }
            startActivity(intent)
        }
    }
}



