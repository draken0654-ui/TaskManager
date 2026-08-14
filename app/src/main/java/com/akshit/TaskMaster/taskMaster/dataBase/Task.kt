package com.akshit.TaskMaster.taskMaster.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // no longer need to pass id

    val title: String,
    val isCompleted: Boolean,
    val priority: TaskPriority
)

enum class TaskPriority{
    LOW,
    MEDIUM,
    HIGH
}