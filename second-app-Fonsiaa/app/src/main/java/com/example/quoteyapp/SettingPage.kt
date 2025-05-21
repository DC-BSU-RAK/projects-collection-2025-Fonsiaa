package com.example.quoteyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Button small info about the app
        val popUpInstruct: ImageButton = findViewById(R.id.profileButton)
        popUpInstruct.setOnClickListener {
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
            showPopUp() // this will show the info once it is clicked
        }

        val input: EditText = findViewById(R.id.inputText)
        val saveButton : ImageButton = findViewById(R.id.saveButton)
        val sharedPreference : SharedPreferences = getSharedPreferences("My Preference", MODE_PRIVATE)

        saveButton.setOnClickListener {
            val theInput = input.text.toString() //getting the value of the input
            val editor = sharedPreference.edit() // opening shared preference
            editor.putString("Text", theInput) // write value using putString()
            editor.apply() // confirm the writing is done
        }

        //variable for the button
        val homeButton: ImageButton = findViewById(R.id.homeButton)

        homeButton.setOnClickListener {
            // an intent to switch to mainActivity
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent) // launches the activity
            overridePendingTransition(R.anim.fading, R.anim.fading)
        }

        //variable for the button
        val notesButton: ImageButton = findViewById(R.id.notesButton)

        notesButton.setOnClickListener {
            // an intent to switch to note activity
            val intent = Intent (this,Notes::class.java)
            startActivity(intent) // launches the activity
            overridePendingTransition(R.anim.fading, R.anim.fading)
        }

        //variable for the button
        val calendarButton: ImageButton = findViewById(R.id.calendarButton)
        calendarButton.setOnClickListener {
            // an intent to switch to calendar activity
            val intent = Intent (this,Calendar::class.java)
            startActivity(intent) // launches the activity
            overridePendingTransition(R.anim.fading, R.anim.fading)
        }
    }

    // Pop up for the information
    private fun showPopUp() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popUpView = inflater.inflate(R.layout.activity_popup, null)

        //size of the Pop Up
        val width = 800
        val height = 500

        val instruction = PopupWindow(popUpView, width, height, true)
        //Positioning the Pop Up on the screen
        instruction.showAtLocation(popUpView, Gravity.CENTER, 30, 50)
    }
}