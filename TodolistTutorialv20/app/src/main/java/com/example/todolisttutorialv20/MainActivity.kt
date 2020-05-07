package com.example.todolisttutorialv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the first page to the list view activity
        setContentView(R.layout.activity_calendar_view)
    }
}
