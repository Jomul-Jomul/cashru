package kr.ac.tukorea.cashru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ac.tukorea.cashru.quiz.Quiz

class EventPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_page)
        title = "이벤트"

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav_view)

        var event_list = arrayOf("퀴즈", "QR code 이벤트", "추천인")

        var list = findViewById<View>(R.id.listView) as ListView
        var adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, event_list)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            Log.d("test", position.toString())
            val intent:Intent?
            intent = when (position){
                0-> Intent(this, Quiz::class.java)
                1-> Intent(this, QRCode::class.java)
                2-> Intent(this, Com::class.java)
                else -> {null}
            }

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