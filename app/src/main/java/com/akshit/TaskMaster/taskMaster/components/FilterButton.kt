package com.akshit.TaskMaster.taskMaster.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskFilter


//reusable UI component
@Composable
fun FilterButton(
    text: String, //parameter -> fun definition
    buttonFilter: TaskFilter,
    selectedFilter: TaskFilter,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (buttonFilter == selectedFilter) {
                Color.Blue
            } else {
                Color.Gray
            }
        )
    ) {
        Text(text)
    }
}
