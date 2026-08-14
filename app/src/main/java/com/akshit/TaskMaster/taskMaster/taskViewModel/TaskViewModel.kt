package com.akshit.TaskMaster.taskMaster.taskViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshit.TaskMaster.taskMaster.dataBase.Task
import com.akshit.TaskMaster.taskMaster.dataBase.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

//viewmodel own everything the screen needs to display
class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _taskFilter = MutableStateFlow(TaskFilter.ALL)
    val taskFilter: StateFlow<TaskFilter> = _taskFilter


    val tasks = repository.getAllTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000), //=5 sec
            initialValue = emptyList()
        )

    fun addTask(task: Task) {
        viewModelScope.launch { // launch a coroutine in view model scope, it helps not to stop working
            repository.insertTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    val filteredTasks = combine(
        tasks,
        taskFilter,

    ) { taskList, filter  ->

        when (filter){
            TaskFilter.ALL ->  taskList
            TaskFilter.ACTIVE -> taskList.filter { !it.isCompleted }
            TaskFilter.COMPLETED ->   taskList.filter { it.isCompleted }
        }

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

//updateTAsk are updating the state not logic

    fun updateTaskFilter(filter: TaskFilter) {
        _taskFilter.value = filter
    }


}

//An enum is a custom type with a fixed set of valid values.
//An enum class represents a fixed set of predefined constants.
//It provides type safety, prevents invalid values, and makes the code easier to read and maintain.


enum class TaskFilter {
    ALL,
    ACTIVE,
    COMPLETED
}
