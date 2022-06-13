package kr.ac.tukorea.cashru

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.ac.tukorea.cashru.databinding.LogInBinding
import kotlin.math.log

class loginActivity:AppCompatActivity() {
    var email : String = ""
    var passwd : String? = null
    var getData : String? = null
    var split_arr : Array<String?> = arrayOfNulls<String>(4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore

        binding.loginButton.setOnClickListener {
            email = binding.editTextTextEmail.text.toString()
            db.collection("user").document(email)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        getData = document.data.toString().replace(" ","")
                        getData = getData!!.replace("{","")
                        getData = getData!!.replace("}","")
                        split_arr = getData!!.split(",").toTypedArray()
                        for(i in split_arr!!){
                            if(i.toString().contains("passwd")){
                                passwd= i!!.substring(7)
                            }
                        }
                        Log.d(signUpActivity.TAG, "비밀번호 ${passwd}")
                        if(binding.editTextTextPassword.text.toString().equals(passwd)){
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this,"해당 아이디가 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        binding.signUp.setOnClickListener{
            val intent = Intent(this,signUpActivity::class.java)
            startActivity(intent)
        }
    }
}