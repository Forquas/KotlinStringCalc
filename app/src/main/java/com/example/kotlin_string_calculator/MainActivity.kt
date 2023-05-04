package com.example.kotlin_string_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button
    lateinit var button7 : Button
    lateinit var button8 : Button
    lateinit var button9 : Button
    lateinit var button0 : Button

    lateinit var buttonPlus : Button
    lateinit var buttonDiv : Button
    lateinit var buttonMulti : Button
    lateinit var buttonMinus : Button
    lateinit var buttonDot : Button
    lateinit var buttonEquals : Button
    lateinit var buttonClear : Button
    lateinit var buttonProc : Button
    lateinit var buttonParenth : Button
    lateinit var buttonDel : Button

    lateinit var myTextView: TextView
    lateinit var calculator: Calculator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView = findViewById(R.id.textView)
        calculator = Calculator()

        startUpButton()
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonEquals.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonMulti.setOnClickListener(this)
        buttonDiv.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        buttonProc.setOnClickListener(this)
        buttonParenth.setOnClickListener(this)
        buttonDel.setOnClickListener(this)

    }
    fun startUpButton(){
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonEquals = findViewById(R.id.buttonEquals)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMulti = findViewById(R.id.buttonMulti)
        buttonDot = findViewById(R.id.buttonDot)
        buttonDiv = findViewById(R.id.buttonDiv)
        buttonClear = findViewById(R.id.buttonClear)
        buttonProc = findViewById(R.id.buttonProc)
        buttonParenth = findViewById(R.id.buttonParenth)
        buttonDel = findViewById(R.id.buttonDel)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button0 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "0")
            R.id.button1 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "1")
            R.id.button2 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "2")
            R.id.button3 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "3")
            R.id.button4 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "4")
            R.id.button5 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "5")
            R.id.button6 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "6")
            R.id.button7 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "7")
            R.id.button8 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "8")
            R.id.button9 ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "9")
            R.id.buttonMulti ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "X")
            R.id.buttonDiv ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "/")
            R.id.buttonMinus ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "-")
            R.id.buttonPlus ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "+")
            R.id.buttonDot ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, ".")
            R.id.buttonEquals ->{
                myTextView.text = calculator.equalsCalc(myTextView.text as String)
            }
            R.id.buttonClear ->
                myTextView.text = calculator.clearCalc()
            R.id.buttonProc ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, ".")
            R.id.buttonParenth ->
                myTextView.text = calculator.updateCalc(myTextView.text as String, "(-3)")
            R.id.buttonDel ->
                myTextView.text = calculator.delCalc(myTextView.text as String)


        }
    }
}


