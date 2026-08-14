package com.akshit.TaskMaster.taskMaster.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskFilter

@Composable
fun TaskSectionHeader(currentFilter: TaskFilter, totalCount: Int, activeTasks: Int, completedTasks: Int) {

    Row() {
        when (currentFilter) {
            TaskFilter.ALL -> {
                Text(text = "All Tasks")
                Text(text = "  $totalCount")
            }
            TaskFilter.ACTIVE ->{
                Text(text = "Active Tasks")
                Text(text = "  $activeTasks")
            }

            TaskFilter.COMPLETED -> {
                Text(text = "Completed Tasks")
                Text(text = "  $completedTasks")
            }
        }
    }
}