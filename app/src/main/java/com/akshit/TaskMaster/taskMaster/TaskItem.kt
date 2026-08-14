package com.akshit.TaskMaster.taskMaster

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.akshit.TaskMaster.taskMaster.dataBase.Task


@Composable
fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit, onDelete: () -> Unit) {

    Card(modifier = Modifier.padding(8.dp)) {
        Row() {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { isChecked ->
                    onCheckedChange(isChecked)

                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = task.title,
                    textDecoration = if (task.isCompleted) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    },
                )
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    if (task.isCompleted) {
                        Text(text = "Completed")
                    } else {
                        Text(text = "Active")
                    }
                    Text(text = task.priority.name)
                }
            }
            IconButton(onClick = {
                onDelete()
            }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}