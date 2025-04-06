
import { Component } from '@angular/core';
import { TaskService } from './models/service/taskService';
import { Task } from './models/task/model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  tasks: Task[] = [];
  newTaskTitle: string = '';
  newTaskDescription: string = '';

  constructor(private taskService: TaskService) {
    this.taskService.getTasks().subscribe(tasks => {
      this.tasks = tasks;
    });
  }

  addTask() {
    if (this.newTaskTitle && this.newTaskDescription) {
      const newTask: Task = {
        id: this.tasks.length + 1,
        title: this.newTaskTitle,
        description: this.newTaskDescription,
        isCompleted: false
      };
      this.taskService.addTask(newTask);
      this.newTaskTitle = '';
      this.newTaskDescription = '';
    }
  }
}
