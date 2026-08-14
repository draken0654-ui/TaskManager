package com.akshit.TaskMaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.akshit.TaskMaster.taskMaster.AppContainer
import com.akshit.TaskMaster.taskMaster.AppNavigation
import com.akshit.TaskMaster.ui.theme.UsingChatgptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val container = AppContainer(applicationContext)
        setContent {
            UsingChatgptTheme {
                AppNavigation(
                    myFactory = container.taskViewModelFactory)
            }
        }
    }
}