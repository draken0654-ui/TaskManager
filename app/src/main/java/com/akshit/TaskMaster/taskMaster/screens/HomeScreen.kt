package com.akshit.TaskMaster.taskMaster.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akshit.TaskMaster.taskMaster.components.HomeHeader
import com.akshit.TaskMaster.taskMaster.TaskItem
import com.akshit.TaskMaster.taskMaster.components.ProgressCard
import com.akshit.TaskMaster.taskMaster.components.TaskFilterHeader
import com.akshit.TaskMaster.taskMaster.components.TaskSectionHeader
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskViewModel
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskViewModelFactory

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(myFactory: TaskViewModelFactory, onAddTaskClick: () -> Unit) {

    val viewModel: TaskViewModel = viewModel(factory = myFactory)
    val tasks by viewModel.filteredTasks.collectAsState()
    val currentFilter by viewModel.taskFilter.collectAsState()
    val allTasks by viewModel.tasks.collectAsState()
    val activeTasks = allTasks.count { !it.isCompleted }
    val completedTasks = allTasks.count { it.isCompleted }

    val progress = if (allTasks.isEmpty()) {
        0f
    } else {
        completedTasks.toFloat() / allTasks.size
    }
    Scaffold( floatingActionButton = {
        FloatingActionButton(
            onClick = { onAddTaskClick() },
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Task"
            )
        }
    },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            item {
                HomeHeader()
            }
            item {
                ProgressCard(progress = progress, completedCount = completedTasks, totalCount = allTasks.size)
            }

            item {
                TaskSectionHeader(currentFilter = currentFilter, totalCount = tasks.size,activeTasks = activeTasks, completedTasks = completedTasks)
            }
            item {
                TaskFilterHeader(currentFilter = currentFilter, onFilterSelected = {filter -> viewModel.updateTaskFilter(filter)})
            }


            if (tasks.isEmpty()) {
                item {
                    Text(text = "No task yet")
                }
            }

            if (tasks.isNotEmpty()) {
                items(tasks) { task -> // one object from the list, it is a lambda function
                    TaskItem(
                        task = task,
                        onCheckedChange = { isChecked -> //callback
                            viewModel.updateTask(
                                task.copy(isCompleted = isChecked)
                            )
                        },
                        onDelete = {
                            viewModel.deleteTask(task)
                        }
                    )
                }
            }
        }
    }
}

