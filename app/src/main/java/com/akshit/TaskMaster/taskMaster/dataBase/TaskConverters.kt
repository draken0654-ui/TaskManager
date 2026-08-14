package com.akshit.TaskMaster.taskMaster.dataBase

import androidx.room.TypeConverter

class TaskConverters {
    @TypeConverter
    fun fromTaskPriority(priority: TaskPriority): String{ //takes enum and converts to string
        return priority.name
    }
    @TypeConverter
    fun toTaskPriority(value: String): TaskPriority { //takes string and converts to enum
        return TaskPriority.valueOf(value)
    }
}