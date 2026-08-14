package com.akshit.TaskMaster.taskMaster

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshit.TaskMaster.taskMaster.screens.AddTaskScreen
import com.akshit.TaskMaster.taskMaster.screens.HomeScreen
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskViewModelFactory

@Composable
fun AppNavigation(myFactory: TaskViewModelFactory) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                myFactory = myFactory,
                onAddTaskClick = {
                    navController.navigate("addTask")
                }
            )
        }
        composable("addTask") {
            AddTaskScreen(myFactory,
                onTaskAdded = {
                    navController.popBackStack()
                })
        }
    }
}