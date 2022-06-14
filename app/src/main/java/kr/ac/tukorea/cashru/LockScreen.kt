package kr.ac.tukorea.cashru

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.ncorti.slidetoact.SlideToActView
import java.util.*


class LockScreen : AppCompatActivity() {
    fun toIntent(){
        val intent = Intent(this,loginActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)

        var count :Int = 0
        var sta = findViewById<SlideToActView>(R.id.example);
        var sta2 = findViewById<SlideToActView>(R.id.example2);
        var time =0
        var timerTask : Timer?= null
        var t_timer = Timer()
        t_timer.schedule(object : TimerTask(){
            override fun run(){

                //카운트 값 증가
                time ++
                count++
                //카운트 값이 5가되면 타이머 종료 실시
                if(time > 5){
                    t_timer.cancel()
                    toIntent()
                }
            }
        },1000, 1000) //1초뒤 실행, 1초 마다 반복



    }
}
