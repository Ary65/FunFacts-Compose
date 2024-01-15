package com.example.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.funfacts.ui.screens.FunFactsNavigationGraph
import com.example.funfacts.ui.screens.Routes
import com.example.funfacts.ui.screens.UserInputScreen
import com.example.funfacts.ui.screens.WelcomeScreen
import com.example.funfacts.ui.theme.FunFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactsTheme {
                FunFactsApp()

            }
        }
    }
}

@Composable
fun FunFactsApp() {
    FunFactsNavigationGraph()
}



