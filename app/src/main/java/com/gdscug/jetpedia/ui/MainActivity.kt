package com.gdscug.jetpedia.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdscug.jetpedia.ui.theme.JetPediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPediaTheme {
                // A surface container using the 'background' color from the theme
                JetPediaApp()
            }
        }
    }
}

