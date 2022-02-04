package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var dotFlag = false
    var lastNumeric = false
    var operatorFlag = false
    var firstMinusFlag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: android.view.View) {
        findViewById<TextView>(R.id.tvInput).append((view as Button).text)
        lastNumeric = true
    }

    fun onPoint(view: android.view.View) {
        if(!dotFlag && lastNumeric){
            findViewById<TextView>(R.id.tvInput).append((view as Button).text)
            dotFlag = true
            lastNumeric = false
        }
    }
    fun onResult(view: android.view.View) {
        var tvInputString = (findViewById<TextView>(R.id.tvInput)).text.toString()
        var prefix : String
        if(tvInputString.startsWith("-")) {
            prefix = "-"
            tvInputString = tvInputString.substring(1)
        }
        else{
            prefix = "+"
        }
        if(tvInputString.contains("+")){
            var splitValue = tvInputString.split("+")
            var one = splitValue[0]
            var two = splitValue[1]
            if(prefix == "-"){
                one = prefix + one
            }
            (findViewById<TextView>(R.id.tvInput)).text = (one.toFloat() + two.toFloat()).toString()
        }
        else if(tvInputString.contains("-")){
                var splitValue = tvInputString.split("-")
                var one = splitValue[0]
                var two = splitValue[1]
                if(prefix == "-"){
                    one = prefix + one
                }
                (findViewById<TextView>(R.id.tvInput)).text = (one.toFloat() - two.toFloat()).toString()
            }
            else
            if(tvInputString.contains("*")){
                var splitValue = tvInputString.split("*")
                var one = splitValue[0]
                var two = splitValue[1]
                if(prefix == "-"){
                    one = prefix + one
                }
                (findViewById<TextView>(R.id.tvInput)).text = (one.toFloat() * two.toFloat()).toString()
            }
            else
                if(tvInputString.contains("/")){
                    var splitValue = tvInputString.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix == "-"){
                        one = prefix + one
                    }
                    (findViewById<TextView>(R.id.tvInput)).text = (one.toFloat() / two.toFloat()).toString()
                }
        dotFlag = false
        lastNumeric = true
        operatorFlag = false
        firstMinusFlag = false
    }
    fun onOperation(view: android.view.View) {
        if(!operatorFlag && lastNumeric) {
            findViewById<TextView>(R.id.tvInput).append((view as Button).text)
            operatorFlag = true
            dotFlag = false
        }
        if(!firstMinusFlag && !lastNumeric && ((view as Button).text == "-")){
            findViewById<TextView>(R.id.tvInput).append((view as Button).text)
            firstMinusFlag = true
        }
    }
    fun onClear(view: android.view.View) {
        findViewById<TextView>(R.id.tvInput).text=""
        dotFlag = false
        lastNumeric = false
        operatorFlag = false
        firstMinusFlag = false
    }
}