package com.akshit.TaskMaster.taskMaster.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao //it tells interface contains functions for talking to the database
interface TaskDao{
    @Insert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("SELECT * FROM   tasks")
    fun getAllTasks(): Flow<List<Task>>
}