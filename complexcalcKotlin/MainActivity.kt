package com.googleworkshop.jakub.complexcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import ComplexNum

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun add(view: View) {
        val et1 = findViewById(R.id.editText) as EditText
        val et2 = findViewById(R.id.editText2) as EditText

        val c1 = ComplexNum(et1.text.toString())
        val c2 = ComplexNum(et2.text.toString())

        val tv = findViewById(R.id.textView5) as TextView
        tv.setText((c1 + c2).toString())
    }

    fun subtract(view: View) {
        val et1 = findViewById(R.id.editText) as EditText
        val et2 = findViewById(R.id.editText2) as EditText

        val c1 = ComplexNum(et1.text.toString())
        val c2 = ComplexNum(et2.text.toString())

        val tv = findViewById(R.id.textView5) as TextView
        tv.setText((c1 - c2).toString())
    }

    fun multiply(view: View) {
        val et1 = findViewById(R.id.editText) as EditText
        val et2 = findViewById(R.id.editText2) as EditText

        val c1 = ComplexNum(et1.text.toString())
        val c2 = ComplexNum(et2.text.toString())

        val tv = findViewById(R.id.textView5) as TextView
        tv.setText((c1 * c2).toString())
    }

    fun divide(view: View) {
        val et1 = findViewById(R.id.editText) as EditText
        val et2 = findViewById(R.id.editText2) as EditText

        val c1 = ComplexNum(et1.text.toString())
        val c2 = ComplexNum(et2.text.toString())

        val tv = findViewById(R.id.textView5) as TextView
        tv.setText((c1 / c2).toString())
    }

}
