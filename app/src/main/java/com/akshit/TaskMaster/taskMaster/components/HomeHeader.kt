package com.akshit.TaskMaster.taskMaster.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun HomeHeader(){
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greetings = when(currentHour) {
        in 3 until 12 -> "Good morning!"   // Includes 3, ends at 11:59:59
        in 12 until 17 -> "Good afternoon!"  // Includes 12, ends at 17:59
        else -> "Good evening!"
    }

    Column() {
        Text(text = "My To-Do's",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Text(text = greetings,
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp)
        Text(text = "Let's get things done!")
    }
}