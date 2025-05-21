package com.example.quoteyapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
        val settingButton: ImageButton = findViewById(R.id.settingButton)

        settingButton.setOnClickListener {
            // an intent to switch to setting activity
            val intent = Intent (this,SettingPage::class.java)
            startActivity(intent) // launches the activity
            overridePendingTransition(R.anim.fading, R.anim.fading)
        }
    }
}