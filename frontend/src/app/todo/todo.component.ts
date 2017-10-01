import {Component, OnInit, Input} from '@angular/core';
import {Todo} from './todo';
import {TodoService} from '../todo.service';

@Component({
  selector: 'todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  @Input() todo: Todo;

  constructor(private todoService: TodoService) {

  }

  ngOnInit(): void {
  }

  updateCompleteFlag(): void {
    this.todoService.save(this.todo);
  }

}
