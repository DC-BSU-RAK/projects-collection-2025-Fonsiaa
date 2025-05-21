package com.example.firstapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //holding a value that can be changed
    private var selectingAnimal: String? = null
    private var selectingClothes: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Button for the game instructions
        val popUpInstruct: ImageButton = findViewById(R.id.infoButton)
        popUpInstruct.setOnClickListener {
            showPopUp() // this will show the instruction once it is clicked
        }

        //activating the media player for the animal sound
        val catSound = MediaPlayer.create(this, R.raw.kitty)
        val dogSound = MediaPlayer.create(this, R.raw.puppy)
        val rabbitSound = MediaPlayer.create(this, R.raw.rabbit)
        val raccoonSound = MediaPlayer.create(this, R.raw.raccoon)
        val camelSound = MediaPlayer.create(this, R.raw.camel)
        val capybaraSound = MediaPlayer.create(this, R.raw.capybara)


        //button for the animals
        val camelButton: ImageButton = findViewById(R.id.camelButton)
        val catButton: ImageButton = findViewById(R.id.catButton)
        val dogButton: ImageButton = findViewById(R.id.dogButton)
        val rabbitButton: ImageButton = findViewById(R.id.rabbitButton)
        val raccoonButton: ImageButton = findViewById(R.id.raccoonButton)
        val capybaraButton: ImageButton = findViewById(R.id.capybaraButton)

        //using the click listener for the buttons
        camelButton.setOnClickListener {
            selectingAnimal = "camel"
            camelSound.start()
            //displaying a short message for the user to know which animal has been selected
            Toast.makeText(this, "The majestic Camel", Toast.LENGTH_SHORT).show()
        }

        catButton.setOnClickListener {
            selectingAnimal = "cat"
            catSound.start() //the cat sound effect played when clicked
            Toast.makeText(this, "The purry kitten", Toast.LENGTH_SHORT).show()
        }

        dogButton.setOnClickListener {
            selectingAnimal = "dog"
            dogSound.start()
            Toast.makeText(this, "The friendly dog", Toast.LENGTH_SHORT).show()
        }

        rabbitButton.setOnClickListener {
            selectingAnimal = "rabbit"
            rabbitSound.start()
            Toast.makeText(this, "The hoppy rabbit", Toast.LENGTH_SHORT).show()
        }

        raccoonButton.setOnClickListener {
            selectingAnimal = "raccoon"
            raccoonSound.start()
            Toast.makeText(this, "The scavenger raccoon", Toast.LENGTH_SHORT).show()
        }

        capybaraButton.setOnClickListener {
            selectingAnimal = "capybara"
            capybaraSound.start()
            Toast.makeText(this, "The chill rodent", Toast.LENGTH_SHORT).show()
        }

        //buttons for the clothings
        val casualButton: ImageButton = findViewById(R.id.casualButton)
        val classicButton: ImageButton = findViewById(R.id.classicButton)
        val costumeButton: ImageButton = findViewById(R.id.costumeButton)

        //on click listener for the clothings
        classicButton.setOnClickListener {
            selectingClothes = "classic"
            resultImage()
        }

        costumeButton.setOnClickListener {
            selectingClothes = "costume"
            resultImage()
        }

        casualButton.setOnClickListener {
            selectingClothes = "casual"
            resultImage()
        }

        //buttons for the toys
        val ballToy: ImageButton = findViewById(R.id.ballToy)

        //the ball animation
        ballToy.setOnClickListener {
            // the bounce animation
            val animation = AnimationUtils.loadAnimation(this,R.anim.bouncing)
            ballToy.startAnimation(animation) // the ball animated

            //the ball will stop bouncing after 3 second
            Handler(Looper.getMainLooper()).postDelayed({
                ballToy.clearAnimation()
            }, 3000)
        }
    }

    //this will show the result in another page activity
    private fun resultImage() {
        if (selectingAnimal != null && selectingClothes != null) {
            val intent = Intent(this, DisplayResult::class.java).apply {
                putExtra("Selecting_Animal", selectingAnimal)
                putExtra("Selecting_Clothes", selectingClothes)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please select an animal a clothing", Toast.LENGTH_LONG).show()
        }
    }

    // Pop up for the instruction
    private fun showPopUp() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popUpView = inflater.inflate(R.layout.activity_pop, null)

        //size of the Pop Up
        val width = 1700
        val height = 1000

        val instruction = PopupWindow(popUpView, width, height, true)
        //Positioning the Pop Up on the screen
        instruction.showAtLocation(popUpView, Gravity.TOP, 0, 100)

    }
}
