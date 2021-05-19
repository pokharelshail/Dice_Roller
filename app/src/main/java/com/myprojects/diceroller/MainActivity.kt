package com.myprojects.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows user to roll dice and view the result on a screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up rollButton that will be clicked to roll dice
        val rollButton: Button= findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        //Create a new object with 6 sides  and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Determine the correct drawable ID resource per cdice
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update Image view with correct drawable ID
        diceImage.setImageResource(drawableResource)
        //Update content Description
        diceImage.contentDescription = diceRoll.toString()



    }
}

/**
 * This class makes a dice with given number of sides
 * @param numSides the number of sides you want on your dice. (The end of the range)
 */
class Dice(private val numSides : Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}
