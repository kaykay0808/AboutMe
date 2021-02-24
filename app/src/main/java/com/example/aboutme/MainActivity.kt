package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //function 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
        // Call setOnClickListener on the nickname_text text view. Pass in a reference to the click-listener function, which is updateNickname().
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    //function 2
    private fun addNickname(view: View) {
        //hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        //put in a findviewbyid

        // nickname_edit = What is your nickname box? (edit text)
        //nickname_text = Kay Header (textview)
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //Set the text in the nicknameTextView text view to the text that the user entered in the editText, getting it from the text property.
        nicknameTextView.text = editText.text
        //Hide the nickname EditText view by setting the visibility property of editText to View.GONE.
        editText.visibility = View.GONE
        //Hide the DONE button by setting the visibility property to View.GONE
        view.visibility = View.GONE


    }
    //function3
    private fun updateNickname (view: View) {
        //Get a reference to the nickname_edit edit text, and get a reference to the DONE button. To do this, use the findViewById() method.
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        // Add code to show the edit text, show the DONE button, and hide the text view.
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

    }
}