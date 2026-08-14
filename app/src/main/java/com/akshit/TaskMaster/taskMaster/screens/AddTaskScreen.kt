package com.akshit.TaskMaster.taskMaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akshit.TaskMaster.taskMaster.dataBase.Task
import com.akshit.TaskMaster.taskMaster.dataBase.TaskPriority
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskViewModel
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskViewModelFactory

@Composable
fun AddTaskScreen(
    myFactory: TaskViewModelFactory,
    onTaskAdded: () -> Unit
) { //create viewModel with required dependencies

    val viewModel: TaskViewModel = viewModel(factory = myFactory)
    var text by remember { mutableStateOf("") }
    var selectedPriority by remember { mutableStateOf<TaskPriority?>(null) }


    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 16.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter a Task") }
            )

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
                PriorityButton(
                    "LOW",
                    selectedPriority = selectedPriority,
                    buttonPriority = TaskPriority.LOW,
                    onClick = { selectedPriority = TaskPriority.LOW }
                )
                PriorityButton(
                    text = "MEDIUM",
                    selectedPriority = selectedPriority,
                    buttonPriority = TaskPriority.MEDIUM,
                    onClick = { selectedPriority = TaskPriority.MEDIUM }
                )
                PriorityButton(
                    text = "HIGH",
                    selectedPriority = selectedPriority,
                    buttonPriority = TaskPriority.HIGH,
                    onClick = { selectedPriority = TaskPriority.HIGH }
                )
            }


            Button(
                onClick = {
                    if (text.isNotBlank() && selectedPriority != null) {
                        viewModel.addTask(
                            Task(
                                title = text,
                                isCompleted = false,
                                priority = selectedPriority!!
                            )
                        )
                        text = ""
                        onTaskAdded()
                    }
                }
            ) {
                Text(text = "Add Task")
            }
        }
    }
}

@Composable
fun PriorityButton(
    text: String,
    onClick: () -> Unit,
    selectedPriority: TaskPriority?, //give this value
    buttonPriority: TaskPriority
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (buttonPriority == selectedPriority) {
                Color.Blue
            } else
            Color.Gray
        )
    ) {
        Text(text)
    }
}