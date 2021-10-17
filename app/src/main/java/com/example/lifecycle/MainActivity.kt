package com.example.lifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {

    lateinit var text:TextView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    text=findViewById(R.id.textView)

    }

    override fun onStart() {
        super.onStart()

        text.text="${text.text} online\n"

    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStop() {
        super.onStop()

        val currentTime = LocalTime.now()
        var time= currentTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
        val currentDate = LocalDate.now()
         val date= currentDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        text.text="${text.text} Last Seen $date $time\n"




    }




}
