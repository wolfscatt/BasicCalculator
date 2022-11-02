package com.tufar.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operator = ""
    var lastValue = ""
    var newOperator = true
    var numberList = ArrayList<Int>()
    var arrayList = ArrayList<String>()

    var btnEqualsIsClicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.textView)

        textView.setText("0")
    }

    fun btn_click(view:View){

        if (newOperator){
            textView.setText(" ")
        }
        newOperator = false
        btnEqualsIsClicked = false
        var btn = view as Button
        var btnValue: String = textView.text.toString()

        // hangi butona basıldığını buluyoruz
        when(btn.id){
            one.id->{
                btnValue += "1"
                numberList.add(1)
            }
            two.id->{
                btnValue += "2"
                numberList.add(2)
            }
            three.id->{
                btnValue += "3"
                numberList.add(3)
            }
            four.id->{
                btnValue += "4"
                numberList.add(4)
            }
            five.id->{
                btnValue += "5"
                numberList.add(5)
            }
            six.id->{
                btnValue += "6"
                numberList.add(6)
            }
            seven.id->{
                btnValue += "7"
                numberList.add(7)
            }
            eight.id->{
                btnValue += "8"
                numberList.add(8)
            }
            nine.id->{
                btnValue += "9"
                numberList.add(9)
            }
            zero.id->{
                btnValue += "0"
                numberList.add(0)
            }
        }
        textView.setText(btnValue)
    }

    fun btn_operator(view:View){
        val btn = view as Button
        when(btn.id){
            plus.id ->{
                operator = "+"
            }
            minuse.id ->{
                operator = "-"
            }
            divide.id ->{
                operator = "/"
            }
            multiply.id ->{
                operator = "x"
            }
        }
        lastValue = textView.text.toString()
        arrayList.add(lastValue)
        println(arrayList)
        newOperator = true
        btnEqualsIsClicked = false
    }

    fun btn_equals(view: View){
        var newValue = textView.text.toString()
        var result :Double ?= null
/*
        val array = ArrayList<Int>()
        var sum:Int ?= null
        for (i in arrayList){
            var num = i.toInt()
            array.add(num)
        }

 */
        when(operator){
            "+"->{
                result = lastValue.toDouble() + newValue.toDouble()
            }
            "-"->{
                result = lastValue.toDouble() - newValue.toDouble()
            }
            "/"->{
                result = lastValue.toDouble() / newValue.toDouble()
            }
            "x"->{
                result = lastValue.toDouble() * newValue.toDouble()
            }
        }
        textView.setText( result.toString())
        newOperator = true
        btnEqualsIsClicked = true
        var clear = findViewById<Button>(R.id.clear)
        if(btnEqualsIsClicked){
            clear.setVisibility(View.INVISIBLE)
        }

    }

    fun btn_clear(view: View){

        var lastNumbers = ""
        var number = numberList.lastOrNull()
        numberList.remove(number)

        for (i in numberList){
            lastNumbers += i
        }
        //println(numberList)
        textView.setText(lastNumbers)

        newOperator = false
    }

    fun btn_clearAll(view:View){
        arrayList.clear()
        numberList.clear()
        textView.setText("0")
        newOperator = true
        var clear = findViewById<Button>(R.id.clear)
        clear.setVisibility(View.VISIBLE)

    }
    fun btn_comma(view:View){
        Toast.makeText(applicationContext,"Burayı henüz kodlamadım kurcalama!!!",Toast.LENGTH_LONG).show()
    }
}