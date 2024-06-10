package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)
        val day = intent.getStringArrayListExtra("day") ?: arrayListOf()
        val min = intent.getIntegerArrayListExtra("min") ?: arrayListOf()
        val max = intent.getIntegerArrayListExtra("max") ?: arrayListOf()
        val activityNotes = intent.getStringArrayListExtra("activityNotes") ?: arrayListOf()

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val averageTextView = findViewById<TextView>(R.id.averageTextView)
        val backButton = findViewById<Button>(R.id.addButton)

        var totalScreenTime = 0
        var displayText = ""
        for (i in day.indices) {
            val dailyScreenTime = min[i] + max[i]
            totalScreenTime += dailyScreenTime
            displayText += "Day: ${day[i]}, Min: ${min[i]} min, Max: ${max[i]} min, Notes: ${activityNotes[i]}\n\n"
        }
        val averageScreenTime = if (day.isNotEmpty()) totalScreenTime / day.size else 0

        detailsTextView.text = displayText
        averageTextView.text = "Average temperature for the week: $averageScreenTime minutes/day"

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}




