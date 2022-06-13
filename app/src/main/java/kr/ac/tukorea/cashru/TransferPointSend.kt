package kr.ac.tukorea.cashru

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TransferPointSend:Activity() {

    lateinit var remainCash : TextView
    lateinit var changeCash : EditText
    lateinit var remainNum : String
    lateinit var changeNum : String
    var rem : Int? = null
    var cha : Int? = null
    var result : Int? = 3270

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_point_send)

        remainCash = findViewById<TextView>(R.id.RemainCash2)
        changeCash = findViewById<EditText>(R.id.ChangeCash)
        remainNum = remainCash.toString()

        var btnChange = findViewById<Button>(R.id.btnChange)

        remainCash.text = "가용 포인트 :" + result.toString() + " 원"

        btnChange.setOnClickListener {
            changeNum = changeCash.text.toString()
            rem = changeNum.toIntOrNull()

            if(rem==null){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else if(rem!!>result!!){
                Toast.makeText(this, "가용 포인트 내에서 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "환전이 완료되었습니다", Toast.LENGTH_SHORT).show()
            }
        }

    }
}