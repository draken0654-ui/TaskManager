package com.akshit.TaskMaster.taskMaster.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.akshit.TaskMaster.taskMaster.taskViewModel.TaskFilter

@Composable
fun TaskFilterHeader(currentFilter: TaskFilter,onFilterSelected: (TaskFilter) -> Unit  ) { //onFilterSelected is a self fun
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        FilterButton(
            "ALL",
            TaskFilter.ALL,
            currentFilter,
            { onFilterSelected(TaskFilter.ALL) })

        FilterButton(
            "Active", //arguments -> fun call
            buttonFilter = TaskFilter.ACTIVE, //never changes
            selectedFilter = currentFilter, //this changes as user click on the button
            onClick = { onFilterSelected(TaskFilter.ACTIVE)})

        FilterButton(
            "COMPLETED",
            TaskFilter.COMPLETED,
            currentFilter,
            { onFilterSelected(TaskFilter.COMPLETED) })
    }
}