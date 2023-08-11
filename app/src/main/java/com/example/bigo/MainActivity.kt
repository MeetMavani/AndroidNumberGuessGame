package com.example.bigo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random

//Declaration of class / basically saying here is our main screen of our application
class MainActivity : AppCompatActivity() {

    private lateinit var button:Button
    private lateinit var button2:Button
    private lateinit var background:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //onCreate is an event which will be triggered for you by the android system and so the code which you write here will automatically run
        setContentView(R.layout.activity_main) //this line is saying here is the content / pointing to some xml file that will define the ui

        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        background = findViewById(R.id.background)

        assignNumbersToButtons()

        button.setOnClickListener {
            //code here will run everytime left button is clicked
            //1.Compare the numbers in the boxes
            checkAnswer(isleftButtonSelected = true)
            //2. Pick new random numbers
            assignNumbersToButtons()
        }

        button2.setOnClickListener {
            //code here will run everytime right button is clicked
            //1.Compare the numbers in the boxes
            checkAnswer(isleftButtonSelected = false)
            //2. Pick new random numbers
            assignNumbersToButtons()
        }
    }

    private fun checkAnswer(isleftButtonSelected: Boolean) {
        val leftNum:Int = button.text.toString().toInt()
        val rightNum:Int = button2.text.toString().toInt()
        val isAnsCorrect: Boolean = if(isleftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnsCorrect) {
            //Correct answer!!
            //change background color
            background.setBackgroundColor(Color.GREEN)
            //Show Toast
            Toast.makeText(applicationContext,"Correct!", Toast.LENGTH_SHORT).show()
        } else {
            //Wrong answer!!
            //change background color
            background.setBackgroundColor(Color.RED)
            //show Toast
            Toast.makeText(applicationContext, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum: Int = r.nextInt(10)
        var rightNum: Int = leftNum
        while(rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        button.text = "$leftNum"
        button2.text = "$rightNum"
    }
}