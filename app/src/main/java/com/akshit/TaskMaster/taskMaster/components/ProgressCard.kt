package com.akshit.TaskMaster.taskMaster.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProgressCard(progress: Float, completedCount: Int, totalCount: Int) {

    val progressPercent = (progress * 100).toInt()

    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        Column() {
            Text(text = "$progressPercent%")
            Text(text = "Task Progress")
            LinearProgressIndicator(progress =   {progress} )
            Text(text = "$completedCount of $totalCount tasks completed")
        }
    }
}