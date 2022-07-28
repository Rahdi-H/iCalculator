package com.invansa.icalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnOnClick(view: View) {
        if (isNewOp){
            displaypanel.setText("")
        }
        isNewOp = false
        val btnSelected = view as Button
        var btnValue = displaypanel.text.toString()
        when (btnSelected.id) {
            btnZero.id -> btnValue += "0"
            btnOne.id -> btnValue += "1"
            btnTwo.id -> btnValue += "2"
            btnThree.id -> btnValue += "3"
            btnFour.id -> btnValue += "4"
            btnFive.id -> btnValue += "5"
            btnSix.id -> btnValue += "6"
            btnSeven.id -> btnValue += "7"
            btnEight.id -> btnValue += "8"
            btnNine.id -> btnValue += "9"
            btnDot.id -> btnValue += "."
            btnPlusMinus.id -> btnValue = "-$btnValue"
        }
        displaypanel.setText(btnValue)
    }
    var op = ""
    var firstNumber = ""
    var isNewOp = true
    fun mathOp(view: View) {
        val btnSeleted = view as Button
        when (btnSeleted.id) {
            btnPlus.id -> op = "+"
            btnMinus.id -> op = "-"
            btnMultiply.id -> op = "*"
            btnDivision.id -> op = "/"
        }
        firstNumber = displaypanel.text.toString()
        isNewOp = true
    }
    fun equalOp(view: View) {
        val secondNumber = displaypanel.text.toString()
        var final: Double? = null
        when(op) {
            "+" -> final =  firstNumber.toDouble() + secondNumber.toDouble()
            "-" -> final = firstNumber.toDouble() - secondNumber.toDouble()
            "*" -> final = firstNumber.toDouble() * secondNumber.toDouble()
            "/" -> final = firstNumber.toDouble() / secondNumber.toDouble()
        }
        displaypanel.setText(final.toString())
        isNewOp = true
    }
    fun cleanOp(view: View) {
        displaypanel.setText("0")
        isNewOp = true
    }
    fun  percentOp(view: View) {
        val number: Double = displaypanel.text.toString().toDouble()/100
        displaypanel.setText(number.toString())
    }
}