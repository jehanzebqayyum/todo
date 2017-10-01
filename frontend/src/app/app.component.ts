import {Component, OnInit} from '@angular/core';
import {TodoComponent} from './todo/todo.component';
import {Todo} from './todo/todo';
import {TodoService} from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [TodoService]
})
export class AppComponent {
  title = 'todo app';
  todos: Todo[] = new Array();
  complete: boolean = null;
  newTodo = new Todo("");

  constructor(private todoService: TodoService) {
  }

  ngOnInit(): void {
    this.todoService.findAll().then(found => {console.log(found); this.todos = found;});
  }

  deleteTodo(todel: Todo): void {
    this.todoService.delete(todel.id).then(() => {this.todos = this.todos.filter(t => t != todel);});
  }

  filter(filterType: string): void {
    console.log(filterType);
    if ("complete" === filterType) {
      this.complete = true;
    }
    else if ("pending" === filterType) {
      this.complete = false;
    }
    else {
      this.complete = null;
    }
  }
  
  addTodo(): void {
    this.todoService.save(this.newTodo).then(todo => {this.todos.push(todo);});
    this.newTodo = new Todo(" ");
  }


}
