package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dateEditText = findViewById<EditText>(R.id.dayEditText)

        val minEditText = findViewById<EditText>(R.id.MinEditText)
        val maxEditText = findViewById<EditText>(R.id.maxEditText)
        val activityNotesEditText = findViewById<EditText>(R.id.activitynotesEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val viewDetailsButton = findViewById<Button>(R.id.viewdetailsButton)

        addButton.setOnClickListener {
            val day = dateEditText.text.toString()
            val min = minEditText.text.toString().toIntOrNull()
            val max = maxEditText.text.toString().toIntOrNull()
            val activityNotes = activityNotesEditText.text.toString()

            if (day.isNotEmpty() && min != null && max != null && activityNotes.isNotEmpty()) {
                day.add(day)
                min.add(min)
                max.add(max)
                activityNotes.add(activityNotes)
                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
                clearFields(dateEditText, minEditText, maxEditText, activityNotesEditText)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
//The code that is commented out below will clear all data saved in the arraylists!
        clearButton.setOnClickListener {
            //day.clear()
            // min.clear()
            //max.clear()
            // activityNotes.clear()
            // Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
            clearFields(dateEditText, minEditText, maxEditText, activityNotesEditText)

        }

        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            val day = null
            intent.putStringArrayListExtra("days", day)
            val min = null
            intent.putIntegerArrayListExtra("min", min)
            val max = null
            intent.putIntegerArrayListExtra("max", max)
            val activityNotes = null
            intent.putStringArrayListExtra("activityNotes", activityNotes )
            startActivity(intent)
        }
    }

    private fun clearFields(vararg fields: EditText) {
        for (field in fields) {
            field.text.clear()
        }
    }
}

private fun Int.add(min: Int) {

}

private fun String.add(day: String) {

}


