package kr.ac.tukorea.cashru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class TransferMain : AppCompatActivity() {
    lateinit var remainCash : TextView
    lateinit var cashNum : String
    var result : Int? = 3270

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_main)

        remainCash = findViewById(R.id.RemainCash)

        var btnChange = findViewById<Button>(R.id.btnChange)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav_view)

        remainCash.text = result.toString() + " 원"

        btnChange.setOnClickListener {
            var intent = Intent(this, TransferPointSend::class.java)
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