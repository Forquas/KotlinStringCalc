package com.example.kotlin_string_calculator

import android.util.Log

class Calculator() {

    fun updateCalc(initString: String,value: String): String = initString + value

    fun equalsCalc(passedString: String): String{
        mathCalc(equalsListNumFun(passedString),equalsListOpeFun(passedString))
        return ""
    }
    private fun equalsListNumFun(passedString: String): List<String> {
        val plusSplitter = "+"
        val minusSplitter = "-"
        val divSplitter = "/"
        val multiSplitter = "X"
        return passedString.split(plusSplitter,minusSplitter,divSplitter,multiSplitter)
    }
    private fun equalsListOpeFun(passedString: String): List<String> {
        val splittedArrayOperatorsBegin = passedString.split(
            "1","2","3","4","5","6","7","8","9","0").map { it.trim()}
        return splittedArrayOperatorsBegin.filter { it.isNotEmpty() }
    }
    private fun mathCalc(numArray: List<String>,opeArray: List<String>){
        numArray.forEach{
            Log.i("lol", "mathCalc(NUMARRAY): $it")
        }
        opeArray.forEach {
            Log.i("lol", "mathCalc(OPEARRAY): $it")
        }
    }
}