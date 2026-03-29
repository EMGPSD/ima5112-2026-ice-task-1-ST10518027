package com.example.mysocialapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inputbtn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //
        val input = findViewById<EditText>(R.id. input)
        val output = findViewById<TextView>(R.id.output)
        val btnCheck = findViewById<Button>(R.id.Checkbtn)
        val btnClear = findViewById<Button>(R.id.Clearbtn)
        val btnExit = findViewById<Button>(R.id.exitbtn)

        //
        btnCheck.setOnClickListener {

            val userInput = input.text.toString().lowercase().trim()
            val outcome: String

            if (userInput == "morning") {outcome = "Send a ' morning' text to a relative in the family."
            } else if (userInput == "half-morning") {outcome = "call a colleague or a friend and tell them that you appreciate them."
            } else if (userInput == "afternoon") {outcome = "reply with a funny tiktok or a funny meme."
            } else if (userInput == "snack") {outcome = "send a message of you are in my mind to a friend."
            } else if (userInput == "dinner") {outcome = "call a colleague for a 10 minute catch up."
            } else if (userInput == "night") {outcome = "leave behind a kind message to a friend."
            } else { outcome = "Invalid input. Try: morning, afternoon, dinner, night."
            }

            output.text = outcome
        }

        //
        btnClear.setOnClickListener {
            input.text.clear()
            output.text = "Your social spark will appear here"
        }

        //
        btnExit.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }
}
