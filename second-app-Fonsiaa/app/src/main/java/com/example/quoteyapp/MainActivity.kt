package com.example.quoteyapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val quoteText: TextView = findViewById(R.id.quoteText)
        //putting a padding on the textview of the quote
        quoteText.setPadding(8, 8, 8, 8) // Left, Top, Right, Bottom (in pixels)
        val generateButton: ImageButton = findViewById(R.id.generateButton)

        val quotes = arrayOf(
            "“One step takes a way.”",
            "“Never compare yourself from other people.”",
            "“Success is not the key to happiness. Happiness is the key to success.”",
            "“Your passion is waiting for your courage to catch up.” - Isabelle Lafleche",
            "“Doubt kills more dreams than failure ever will.” – Suzy Kassem",
            "“The happiness of your life depends on the quality of your thoughts.”",
            "“You don’t have to see the whole staircase, just take the first step.” - Martin Luther King Jr."
        )

        generateButton.setOnClickListener {
            //randomly generating the quotes from the array
            val randomIndex = (quotes.indices).random()
            //showing the selected quote on the textview
            quoteText.text = quotes[randomIndex]
        }

        val sharedPreference : SharedPreferences = getSharedPreferences("My Preference", Context.MODE_PRIVATE)
        //retrieving the input from the setting page
        val saveText = sharedPreference.getString ("Text", "")
        val userName : TextView = findViewById(R.id.userName)
        userName.text = saveText

        //variable for the button
        val calendarButton: ImageButton = findViewById(R.id.calendarButton)
        calendarButton.setOnClickListener {
            // an intent to switch to calendar activity
            val intent = Intent (this,Calendar::class.java)
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