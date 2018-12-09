package com.vaadin.pwademo

import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("", layout = MainLayout::class)
class TaskListView : VerticalLayout() {
    private lateinit var form: AddTaskForm
    private lateinit var grid: Grid<Task>

}
