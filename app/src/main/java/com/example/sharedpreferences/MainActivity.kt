package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
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

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        if (sharedPref != null){
            val success = sharedPref.edit().putInt(getString(R.integer.saved_high_score), 60).commit()
            if (success){
                val newHighScore = sharedPref.getInt(getString(R.integer.saved_high_score), 5)
                Log.d("SAVEDVALUES", "Initial commited $newHighScore")
            }
            sharedPref.edit().putString(getString(R.string.title_text), "Sobreescrito").commit()
            Log.d("SAVEDVALUES","Un nuevo titulo para $titleFromPrefs")
            val newTitleText = sharedPref.getString(getString(R.string.title_text),"Un nuevo titulo")
        }

        //val  sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        //with (sharedPref.edit()){
        //       putInt(getString(R.integer.save_high_score), 60)
        //       apply()
        // }

        sharedPref.edit().putString("algun_string_asi_nomas", "a ver si se guarda").commit()
        Log.d("SAVEDVALUES","Guardamos el valor : ${sharedPref.getString(getString(R.string.title_text), "")}")

    }
}