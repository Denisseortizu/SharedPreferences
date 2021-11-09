package com.example.sharedpreferences

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleFromPrefs = resources.getString(R.string.title_text)
        val st1 = resources.getBoolean(R.bool.boolean_key1)
        val st2 = resources.getBoolean(R.bool.boolean_key2)
        val st3 = resources.getBoolean(R.bool.boolean_key3)
        val st4 = resources.getBoolean(R.bool.boolean_key4)


        var tv =  findViewById<TextView>(R.id.text)
        var sw1 =  findViewById<Switch>(R.id.sw1)
        var sw2 =  findViewById<Switch>(R.id.sw2)
        var sw3 =  findViewById<Switch>(R.id.sw3)
        var sw4 =  findViewById<Switch>(R.id.sw4)

        tv.text = titleFromPrefs
        sw1.isChecked = st1
        sw2.isChecked = st2
        sw3.isChecked = st3
        sw4.isChecked = st4

    }
}