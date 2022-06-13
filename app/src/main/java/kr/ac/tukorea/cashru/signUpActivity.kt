package kr.ac.tukorea.cashru

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.ac.tukorea.cashru.databinding.SignupBinding
import java.util.*


class signUpActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = Firebase.firestore
        var getData : String? = null
        var split_arr : Array<String?> = arrayOfNulls<String>(4)
        var getPoint : Int = 0


        binding.signUpOkButton.setOnClickListener {
            val email = binding.signUpId.text.toString().trim()
            val password = binding.signUpPassWd.text.toString().trim()
            val nickrec = binding.signUpRecNick.text.toString().trim()
            val user= User(email,password,nickrec)

            val okDB = db.collection("user").document(email)

            okDB.get()
                .addOnSuccessListener { document ->
                    //id가 존재하는지 검사
                    if (document.exists()) {
                        Log.d(TAG, "No such document")
                        Toast.makeText(this,"이미 아이디가 존재합니다",Toast.LENGTH_SHORT).show()

                    } else {
                        //아이디를 DB에 저장
                        db.collection("user").document(email)
                            .set(user)
                            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

                        val okUser = db.collection("user").document(nickrec)
                        okUser.get()
                            .addOnSuccessListener { document ->
                                //id가 존재하는지 검사
                                if (document.exists()) {
                                    //해당 추천인으로부터 포인트를 가져옴
                                    val getDbPoint = db.collection("user").document(nickrec)
                                    getDbPoint.get().addOnSuccessListener { document->
                                        if (document != null) {
                                            getData = document.data.toString().replace(" ","")
                                            getData = getData!!.replace("{","")
                                            getData = getData!!.replace("}","")
                                            split_arr = getData!!.split(",").toTypedArray()
                                            Log.d(TAG, "start point")
                                            for(i in split_arr!!){
                                                if(i.toString().contains("point")){
                                                    getPoint= i!!.substring(6).toInt()
                                                    getPoint += 500
                                                    Log.d(TAG, "값 ${getPoint}")
                                                    //해당 추천인의 포인트를 바꾸어줌
                                                    db.collection("user").document(nickrec)
                                                        .update("point",getPoint)
                                                        .addOnSuccessListener { Log.d(TAG, "수정 성공") }
                                                        .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
                                                    Toast.makeText(this,"회원가입 완료",Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                        } else {
                                            Log.d(TAG, "No such document")
                                        }
                                    }

                                    val intent = Intent(this,loginActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    Log.d(TAG, "No such document")
                                    Toast.makeText(this,"해당 추천인이 없습니다.",Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "get failed with ", exception)
                }
        }
    }
        companion object {
            const val TAG = "MyLog"
        }
    }