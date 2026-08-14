package com.akshit.TaskMaster.taskMaster

import android.content.Context
import com.akshit.TaskMaster.taskMaster.dataBase.TaskDatabase
import com.akshit.TaskMaster.taskMaster.dataBase.TaskRepository
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskViewModelFactory

//knows how to gather all the dependencies for the app(DB, DAO< repository etc.)

class AppContainer (context: Context) {

    val database = TaskDatabase.getDatabase(context) // get the database

    val taskDao = database.taskDao() //give DAO

    val repository = TaskRepository(taskDao) //can use DAO but it does not know about DB

    val taskViewModelFactory = TaskViewModelFactory(repository) //factory knows how to create
}