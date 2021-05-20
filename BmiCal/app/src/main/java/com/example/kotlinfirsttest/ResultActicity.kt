package com.example.kotlinfirsttest

import android.app.AppComponentFactory
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActicity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight",0)
        //Extra를 통해 이전 화면의 데이터 값을 당겨온다.

        Log.d("ResultActivity","height: $height, weight: $weight")

        val bmi = weight / (height / 100.0).pow(2.0)
        //pow는 제곱을 구해주는 함수이다. double형으로 사용

        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        } // 경우에 따른 결과 값 생성 (자바의 case문과 유사하다.)

        val resultValueTextView = findViewById<TextView>(R.id.bmiResult)
        val resultStringTextView = findViewById<TextView>(R.id.AllResult)

        resultValueTextView.text = bmi.toString()
        //bmi 값 자체가 원래 double형으로 선언되어서 String으로 형 변환
        resultStringTextView.text = resultText
    }
}