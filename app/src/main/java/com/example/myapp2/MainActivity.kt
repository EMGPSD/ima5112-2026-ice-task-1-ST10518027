package com.example.myapp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var randomNumber : Int = 0
    private var userinput : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var checkbtn= findViewById<Button>(R.id.Checkbtn)
        var clearbtn= findViewById<Button>(R.id.clearbtn)
        var restext= findViewById<TextView>(R.id.display)
        var exitbtn= findViewById<Button>(R.id.exitbtn)
        userinput = findViewById(R.id.inputbtn)
        randomNumber=generateRandomNumber()

        exitbtn.setOnClickListener {
            moveTaskToBack(true)
            finish()
        }


        clearbtn.setOnClickListener {
            userinput?.text=null
            restext.text =""

        }// working clear button
        checkbtn.setOnClickListener {
            compare(restext)
        }

    }
    fun generateRandomNumber(): Int {
        return (0..50).random()
    }
    private  fun compare(restext: TextView){
        val guess = userinput?.text.toString().toIntOrNull()

        if (guess == null) {
            restext.text = "Please enter a number!"
        } else if (guess == randomNumber) {
            restext.text = " Correct! The number was $randomNumber"
            randomNumber = generateRandomNumber()
        } else if (guess < randomNumber) {
            restext.text = " Too low! Try again"
        } else {
            restext.text = " Too high! Try again"
        }
    }
}