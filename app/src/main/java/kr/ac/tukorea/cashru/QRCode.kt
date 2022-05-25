package kr.ac.tukorea.cashru
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONException
import org.json.JSONObject


class QRCode : AppCompatActivity() {
    //view Objects
    private var buttonScan: Button? = null

    //qr code scanner object
    private var qrScan: IntentIntegrator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qrcode)
        title = "QRCode 이벤트"

        //View Objects
        buttonScan = findViewById<View>(R.id.btn_QRCode) as Button


        //intializing scan object
        qrScan = IntentIntegrator(this)

        //button onClick
        buttonScan!!.setOnClickListener { //scan option
            qrScan!!.setPrompt("Scanning...")
            //qrScan.setOrientationLocked(false);
            qrScan!!.initiateScan()
        }
    }

    //Getting the scan results
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            //qrcode 가 없으면
            if (result.contents == null) {
                Toast.makeText(this, "취소!", Toast.LENGTH_SHORT).show()
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(this, "스캔완료!", Toast.LENGTH_SHORT).show()
                try {
                    //data를 json으로 변환
                    val obj = JSONObject(result.contents)
                } catch (e: JSONException) {
                    e.printStackTrace()
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();

                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}