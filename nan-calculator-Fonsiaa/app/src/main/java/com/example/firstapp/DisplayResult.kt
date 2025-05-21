package com.example.firstapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val showcaseImage: ImageView = findViewById(R.id.showCaseImage)
        //finding the button that will go back to the main activity
        val againButton: ImageButton = findViewById(R.id.againButton)

        //get the selected animals and clothes from the intent
        //retrieving the string or the key from the main activity
        val selectedAnimal = intent.getStringExtra("Selecting_Animal")
        val selectedClothes = intent.getStringExtra("Selecting_Clothes")

        //set the image based on the selected animal and clothing
        val selectedButton = showResult(selectedAnimal, selectedClothes)
        showcaseImage.setImageResource(selectedButton)

        //setting a set click listener for the style again button
        againButton.setOnClickListener {
            finish() // this will close the show case activity
        }
    }

    //accessing within the file
    //obtaining the value by which the player clicks on
    private fun showResult(selectingAnimal:String?, selectingClothes:String?):Int {
        return when (selectingAnimal) {
            //when the user clicks on the cat
            "cat" -> when (selectingClothes) {
                //then the player clicks on one of the clothes
                "casual" -> R.drawable.cat_casual // it will display the cat wearing casual
                "classic" -> R.drawable.cat_classic
                "costume" -> R.drawable.cat_costume

                else -> R.drawable.cat
            }

            //when the user clicks on the dog
            "dog" -> when (selectingClothes) {
                "casual" -> R.drawable.dog_casual
                "classic" -> R.drawable.dog_classic
                "costume" -> R.drawable.dog_costume

                else -> R.drawable.dog
            }

            //when the user clicks on the rabbit
            "rabbit" -> when (selectingClothes) {
                "casual" -> R.drawable.rabbit_casual
                "classic" -> R.drawable.rabbit_classic
                "costume" -> R.drawable.rabbit_costume

                else -> R.drawable.rabbit
            }

            //when the user clicks on the raccoon
            "raccoon" -> when (selectingClothes) {
                "casual" -> R.drawable.raccoon_casual
                "classic" -> R.drawable.raccoon_classic
                "costume" -> R.drawable.raccoon_costume

                else -> R.drawable.raccoon
            }

            //when the user clicks on the camel
            "camel" -> when (selectingClothes) {
                "casual" -> R.drawable.camel_casual
                "classic" -> R.drawable.camel_classic
                "costume" -> R.drawable.camel_costume

                else -> R.drawable.camel
            }

            //when the user clicks on the capybara
            "capybara" -> when (selectingClothes) {
                "casual" -> R.drawable.capybara_casual
                "classic" -> R.drawable.capybara_classic
                "costume" -> R.drawable.capybara_costume

                else -> R.drawable.capybara
            }

            else -> R.layout.activity_result
        }
    }
}