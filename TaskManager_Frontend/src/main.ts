import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskService } from './app/models/service/taskService';

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(FormsModule),
    TaskService
  ]
});
