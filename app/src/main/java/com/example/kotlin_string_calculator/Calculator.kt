package com.example.kotlin_string_calculator

import android.text.BoringLayout
import android.util.Log
import kotlin.math.log

class Calculator() {

    fun updateCalc(initString: String,value: String): String = initString + value

    fun equalsCalc(passedString: String,parenthCount: Int): String{

        val parenthCheck = checkFirstMinus(passedString)
        Log.i("lol", "equalsCalc: $parenthCheck")
        var numbers = equalsListNumFunFirst(passedString,parenthCheck)
        var ops = equalsListOpeFunFirst(passedString,parenthCheck)

        Log.i("lol", "equalsCalc: numbers count ${numbers.count()}")
        Log.i("lol", "equalsCalc: numbers are $numbers")
        Log.i("lol", "equalsCalc: ops count ${ops.count()}")
        Log.i("lol", "equalsCalc: ops : $ops")
        val ats = untilPlus(numbers,ops)
        return ats.toString()
    }

    fun delCalc(initString: String): String {
        var ans = ""
        if(initString.isNotEmpty())
            ans = initString.substring(0,initString.length-1)
        return ans
    }
    fun clearCalc(): String = ""


    private fun checkFirstMinus(passedString: String): Boolean = (passedString[0] == '-')

    private fun untilPlus(numArray: List<String>,opeArray: List<String>): Int{

        val numbers = numArray
        val ops = opeArray
        var newNumbers: MutableList<String>
        var newOps: MutableList<String>
        newNumbers = numbers as MutableList<String>
        newOps = ops as MutableList<String>

        while(newOps.contains("X") || newOps.contains("/")){
            newNumbers = mathCalcDivAndMultiNum(newNumbers,newOps) as MutableList<String>
            Log.i("lol", "in the loop: $newNumbers")
            newOps = mathCalcDivAndMultiNumOps(newNumbers,newOps) as MutableList<String>
            Log.i("lol", "in the loop: $newOps")
        }
        Log.i("lol", "untilPlus: $newNumbers and $newOps")
       return afterPlus(newNumbers,newOps)
    }
    private fun afterPlus(numArray: List<String>,opeArray: List<String>): Int{
        val numbers = numArray
        val ops = opeArray
        var newNumbers: MutableList<Int> = mutableListOf()
        newNumbers.add(numbers[0].toInt())
        Log.i("lol", "afterPlus: 0 index number $newNumbers")
        ops.forEachIndexed { index, _ ->
            val indexPlus = index + 1
            Log.i("lol", "afterPlus: we came to the loop")
            if(ops.get(index)== "-"){
                newNumbers.add(numbers[indexPlus].toInt()*(-1))
                Log.i("lol", "we  got minus $newNumbers ")
            }
            else{
                newNumbers.add(numbers[indexPlus].toInt())
            }
        }
        var suma = 0
        newNumbers.forEach {
            suma += it
        }
        Log.i("lol", "suma be like $suma")
        return suma
    }

    private fun mathCalcDivAndMultiNum(numArray: List<String>,opeArray: List<String>):
            List<String>{

        val numbers = numArray
        val ops = opeArray
        var newNumbers = mutableListOf<String>()
        var oneTimeMeter = false

        numbers.zip(ops).forEachIndexed{index, pair ->
            val nextNumIndex = index + 1
            if(pair.second == "/" && !oneTimeMeter) {
                newNumbers.add(
                    numbers[index].toInt().div(numbers[nextNumIndex].toInt()).toString())
                oneTimeMeter = true
            }
            else if(pair.second == "X" && !oneTimeMeter){
                newNumbers.add(
                    numbers[index].toInt().times(numbers[nextNumIndex].toInt()).toString())
                oneTimeMeter = true
            }
            else if(oneTimeMeter) {
                newNumbers.add(numbers[nextNumIndex])
                //
            }
            else{
                newNumbers.add(pair.first.toInt().toString())
            }
        }

        Log.i("lol", "mathCalcDivAndMultiNum: ops size ${ops.size}")
        Log.i("lol", "mathCalcDivAndMultiNum: $newNumbers")
        return newNumbers
    }
    private fun mathCalcDivAndMultiNumOps(numArray: List<String>,opeArray: List<String>):
            List<String>{

        val numbers = numArray
        val ops = opeArray
        var newOps = mutableListOf<String>()
        var oneTimeMeter = false

        numbers.zip(ops).forEachIndexed{index, pair ->
            val nextNumIndex = index + 1

            if(pair.second == "/" && !oneTimeMeter) {
                oneTimeMeter = true
            }
            else if(pair.second == "X" && !oneTimeMeter){
                oneTimeMeter = true
            }
            else if(oneTimeMeter) {
                newOps.add(pair.second)
            }
            else {
                newOps.add(pair.second)
            }
        }
        Log.i("lol", "mathCalcDivAndMultiNumOps: ops list $newOps")
        return newOps
    }





    private fun equalsListNumFunFirst(passedString: String,parenthCheck: Boolean): List<String> {
        val plusSplitter = "+"
        val minusSplitter = "-"
        val divSplitter = "/"
        val multiSplitter = "X"
        val equalSpliiter = "="
        var tempList: MutableList<String> =
            passedString.trim().split(plusSplitter,minusSplitter,divSplitter,
                multiSplitter,equalSpliiter) as MutableList<String>
        tempList = tempList.filter { it.isNotEmpty() } as MutableList<String>
        Log.i("lol", "equalsListNumFunFirst:temp list 1 $tempList")
        if(parenthCheck)tempList[0] = tempList[0].toInt().times(-1).toString()
        Log.i("lol", "equalsListNumFunFirst:temp list 2 $tempList")
        val returnableList: List<String> = tempList
        Log.i("lol", "equalsListNumFunFirst: returnable $returnableList")
        return returnableList
    }
    private fun equalsListOpeFunFirst(passedString: String,parenthCheck:Boolean): List<String> {
        val splittedArrayOperatorsBegin = passedString.split(
            "1","2","3","4","5","6","7","8","9","0").map { it.trim()}
        Log.i("lol", "equalsListOpeFunFirst:temp list 1 $splittedArrayOperatorsBegin")
        val tempList: MutableList<String> =
            splittedArrayOperatorsBegin.filter { it.isNotEmpty() } as MutableList<String>
        Log.i("lol", "equalsListOpeFunFirst:temp list 2 $tempList")
        if(parenthCheck) tempList.removeAt(0)
        Log.i("lol", "equalsListOpeFunFirst:temp list 3 after removal $tempList")
        val returnableList: List<String> = tempList
        Log.i("lol", "equalsListOpeFunFirst: returnable $returnableList")
        return returnableList
    }
}

