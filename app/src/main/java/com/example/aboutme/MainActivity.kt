package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameEdit.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText = binding.nicknameEdit // The invisible text view
        val nicknameTextView = binding.nicknameText // the textfield input

        nicknameTextView.text = editText.text

        // hide the buttons and editText
        editText.visibility = View.GONE
        view.visibility = View.GONE

        // make it visible
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        val editText = binding.nicknameEdit
        val doneButton = binding.doneButton

        // hide the buttons and editText
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE

        // make it visible
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
