package com.kotlinproject.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



/**
 * This activity allows the user to roll a dice and view the result of the
 * on the screen
 */
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            /* val toast = makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
            toast.show()
            Toast.makeText(this,"Dice Rolled" , Toast.LENGTH_SHORT).show()
            */
           

            rollDice()
        }
    }
/*
Roll the Dice and Update the Screen with the result.
 */
    private fun rollDice() {
    //Create new Dice Object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
    //Update the screen  with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
    val diceImage2: ImageView = findViewById(R.id.imageView2)

    val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    diceImage.setImageResource(drawableResource)
    diceImage2.setImageResource(drawableResource)

    diceImage.contentDescription = diceRoll.toString()
    diceImage2.contentDescription = diceRoll.toString()
    val resultTextView: TextView = findViewById(R.id.textView)
    resultTextView.text = getString(R.string.dice_rolled,diceRoll)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()

    }

}

