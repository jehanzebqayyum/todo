import {Pipe, PipeTransform} from '@angular/core';
import {Todo} from './todo/todo';

@Pipe({
  name: 'completionfilter',
  pure: false
})
export class CompletionfilterPipe implements PipeTransform {

  transform(todos: Todo[], complete?: boolean): any {
    if (complete === null) return todos;
    return todos.filter(t => t.complete == complete);
  }

}
