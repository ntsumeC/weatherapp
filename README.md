Lithemba Collin Ntsume( ST10460350) 

 

~Link to GitHub  

https://github.com/ntsumeC/weatherapp.git 

~Flowchart/Pseudocode 

 

// Splash Activity 

 // Function: Show splash screen. 

fun showSplashScreen() { 

    // Show splash screen UI 

} 

 // Option: Start button clicked. 

fun onStartButtonClicked() { 

    // Open Main Activity 

    openMainActivity() 

} 

 // Option: Exit button clicked. 

fun onExitButtonClicked() { 

    // Close app 

    closeApp() 

} 

 // Main Activity 

 // Data 

val dates = mutableListOf<String>() 

val morningScreenTimes = mutableListOf<Int>() 

val afternoonScreenTimes = mutableListOf<Int>() 

val activityNotes = mutableListOf<String>() 

  

// Function: Add data entry. 

fun addDataEntry(date: String, morningTime: Int, afternoonTime: Int, note: String) { 

    // Validate input (all fields filled) 

    if (date.isNotBlank() && note.isNotBlank()) { 

        // If valid, add data to each list 

        dates.add(date) 

        morningScreenTimes.add(morningTime) 

        afternoonScreenTimes.add(afternoonTime) 

        activityNotes.add(note) 

        // Show toast message "Data Added" 

        showToast("Data Added") 

        // Clear input fields 

        clearInputFields() 

    } else { 

        // If invalid, show toast message "Please fill in all fields" 

        showToast("Please fill in all fields") 

    } 

} 

  

// Function: Clear data (commented out). 

// fun clearData() { 

//     // Clear all data from lists 

//     dates.clear() 

//     morningScreenTimes.clear() 

//     afternoonScreenTimes.clear() 

//     activityNotes.clear() 

//     // Show toast message "Data Cleared" 

//     showToast("Data Cleared") 

//     // Clear input fields (optional) 

//     clearInputFields() 

// } 

  

// Function: View details. 

fun viewDetails() { 

    // Create intent for DetailedViewActivity 

    val intent = Intent(this, DetailedViewActivity::class.java) 

    // Put data lists as extras in the intent 

    intent.putStringArrayListExtra("dates", ArrayList(dates)) 

    intent.putIntegerArrayListExtra("morningTimes", ArrayList(morningScreenTimes)) 

    intent.putIntegerArrayListExtra("afternoonTimes", ArrayList(afternoonScreenTimes)) 

    intent.putStringArrayListExtra("notes", ArrayList(activityNotes)) 

    // Start DetailedViewActivity 

    startActivity(intent) 

} 

  

// Function: Clear input fields (helper function). 

fun clearInputFields() { 

    // Loop through all provided EditText fields 

    // Clear text for each field 

    // For example: 

    // editTextDate.text.clear() 

    // editTextMorningTime.text.clear() 

    // editTextAfternoonTime.text.clear() 

    // editTextNote.text.clear() 

} 

  

// Detailed View Activity 

  

// Function: Show detailed view. 

fun showDetailedView() { 

    // Get data lists from intent extras 

    val dates = intent.getStringArrayListExtra("dates") 

    val morningTimes = intent.getIntegerArrayListExtra("morningTimes") 

    val afternoonTimes = intent.getIntegerArrayListExtra("afternoonTimes") 

    val notes = intent.getStringArrayListExtra("notes") 

     

    // Initialize variables for total screen time and display text 

    var totalScreenTime = 0 

    var displayText = "" 

  

    // Loop through each data entry 

    for (i in dates.indices) { 

        // Calculate daily screen time (morning + afternoon) 

        val dailyScreenTime = morningTimes[i] + afternoonTimes[i] 

        // Update total screen time 

        totalScreenTime += dailyScreenTime 

        // Build display text with date, times, and note for each entry 

        displayText += "${dates[i]} - Morning: ${morningTimes[i]}, Afternoon: ${afternoonTimes[i]} - ${notes[i]}\n" 

    } 

     

    // Calculate average screen time (total / number of entries, or 0 if no entries) 

    val averageScreenTime = if (dates.isNotEmpty()) totalScreenTime / dates.size else 0 

     

    // Set text for detail text view with all entries 

    // For example: 

    // textViewDetails.text = displayText 

     

    // Set text for average screen time text view with calculated average 

    // For example: 

    // textViewAverageTime.text = "Average Screen Time: $averageScreenTime minutes" 

} 

  

// Button click listener (back button). 

fun onBackButtonClicked() { 

    // Create intent for MainActivity 

    val intent = Intent(this, MainActivity::class.java) 

    // Start MainActivity 

    startActivity(intent) 

} 

``` 

~Purpose and Explanation 

The purpose of the app is to help users/local organization plan their activities according to the forecast or radar upcoming conditions. This app will also alert the organization with climate change and or any severe weather. It also shows climate data and informs the users about any natural change. 

 

The name of my app is “The app.” It has 3 text views which is the name of the app, my names, and my student number. When you click the “Let’s Go” button the app will take you to the next page/screen which is the main activity. 

 

This is the main activity, which has 4 edit texts and the name of the app. When you click on the add button, you add your own information which is the day and then it will display the weather that day, and when you are done you can clear the data.  

 

This is the detailed view activity/ screen whereby all the data from the previous screen will be displayed then when you are done or want to fix something you click on the back button. 

 

NOTE: For a proper explanation check the power point presentation. 

 

 

 

 
