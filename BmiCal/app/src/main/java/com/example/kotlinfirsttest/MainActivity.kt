package com.example.kotlinfirsttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.edt1)
        //첫 번째 EditText 변수를 먼저 선언하여 xml의 EditText와 연결

        val weightEditText= findViewById<EditText>(R.id.edt2)
        //findViewById 함수가 EditText 성질을 반환하면서 xml의 EditText2와 연결

        val resultButton = findViewById<Button>(R.id.btn1)
        //xml의 확인하기 버튼과 연결

        resultButton.setOnClickListener { //확인하기 버튼을 눌렀을 때의 작용 구현
            Log.d("Mainactivity", "확인하기 버튼이 클릭됨")
            //버튼 클릭 시 로그캣 창에 msg가 나타남.

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                // 신장 또는 체중 값이 입력되지 않았다면
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                //빈 값이 있습니다. 라는 토스트 메시지를 짧은 순간 팝업
                return@setOnClickListener
                //반환 값 지정
            }
            //여기서부터는 절대 빈 값이 올 수 없다.

            val height:Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()
            //String 값을 Int형 값으로 받아들이기 위해 형변환

            val intent = Intent(this, ResultActicity::class.java)
            //Intent(현재 페이지, 넘어갈 페이지) 화면 전환 함수.
            //넘어갈 화면은 AndroidManifest.xml 소스에 반드시 넣어줘야 한다.

            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            //화면 이동과 동시에 이전 화면에서 이동하는 화면으로 특정 값을 넘긴다.

            startActivity(intent)


        }
    }
}