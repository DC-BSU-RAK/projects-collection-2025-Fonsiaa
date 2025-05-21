package com.example.quoteyapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Notes : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val stickyNote1: SharedPreferences = getSharedPreferences("stickyNote", Context.MODE_PRIVATE)
        val writeNote: EditText = findViewById(R.id.writeNote) // finding the ID from the layout
        //getting the text
        val savingText = stickyNote1.getString("Text", "")
        writeNote.setText(savingText)

        //setting up the onclick function
        writeNote.setOnEditorActionListener { a, actionId, event ->
            //ac
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                // saving the text to the shared preference

                val editor = stickyNote1.edit()
                editor.putString("Text", writeNote.text.toString())
                editor.apply()

                //a short toast message to show it has been saved
                Toast.makeText(this, "Note saved to sticky note!", Toast.LENGTH_SHORT).show()
                true //the action is handled
            } else {
                false // the action was not handled properly
            }
        }

        val stickyNote2: SharedPreferences = getSharedPreferences("flowerNote", Context.MODE_PRIVATE)
        val writeNote2: EditText = findViewById(R.id.writeNote2) // finding the ID from the layout
        //getting the text
        val savingText2 = stickyNote2.getString("flowerText", "")
        writeNote2.setText(savingText2)

        //setting up the onclick function
        writeNote2.setOnEditorActionListener { b, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                // saving the text to the shared preference

                val editor = stickyNote2.edit()
                editor.putString("flowerText", writeNote2.text.toString())
                editor.apply()

                //a short toast message to show it has been saved
                Toast.makeText(this, "flower note saved!", Toast.LENGTH_SHORT).show()
                true //the action is handled
            } else {
                false // the action was not handled properly
            }
        }

        val stickyNote3: SharedPreferences = getSharedPreferences("cloudNote", Context.MODE_PRIVATE)
        val writeNote3: EditText = findViewById(R.id.writeNote3) // finding the ID from the layout
        //getting the text
        val savingText3 = stickyNote3.getString("cloudText", "")
        writeNote3.setText(savingText3)

        //setting up the onclick function
        writeNote3.setOnEditorActionListener { c, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                // saving the text to the shared preference

                val editor = stickyNote3.edit()
                editor.putString("cloudText", writeNote3.text.toString())
                editor.apply()

                //a short toast message to show it has been saved
                Toast.makeText(this, "cloud note saved!", Toast.LENGTH_SHORT).show()
                true //the action is handled
            } else {
                false // the action was not handled properly
            }
        }

            //variable for the button
            val homeButton: ImageButton = findViewById(R.id.homeButton)

            homeButton.setOnClickListener {
                // an intent to switch to mainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent) // launches the activity
                overridePendingTransition(R.anim.fading, R.anim.fading)
            }

            //variable for the button
            val calendarButton: ImageButton = findViewById(R.id.calendarButton)

            calendarButton.setOnClickListener {
                // an intent to switch to note activity
                val intent = Intent(this, Calendar::class.java)
                startActivity(intent) // launches the activity
                overridePendingTransition(R.anim.fading, R.anim.fading)
            }

            //variable for the button
            val settingButton: ImageButton = findViewById(R.id.settingButton)

            settingButton.setOnClickListener {
                // an intent to switch to setting page
                val intent = Intent(this, SettingPage::class.java)
                startActivity(intent) // launches the activity
                overridePendingTransition(R.anim.fading, R.anim.fading)
            }
    }
}