import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Todo} from './todo/todo';
import {Observable} from 'rxjs';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class TodoService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private url = 'http://localhost:8080/todos';
  constructor(private http: Http) {}

  public save(todo: Todo): Promise<Todo> {
    return this.http.post(this.url, JSON.stringify(todo), {headers: this.headers}).toPromise().then(r => r.json() as Todo).catch(this.handleError);
  }

  public delete(id: number): Promise<void> {
    const url = `${this.url}/${id}`;
    return this.http.delete(url, {headers: this.headers}).toPromise().then(() => null).catch(this.handleError);
  }

  public findAll(): Promise<Todo[]> {
    return this.http.get(this.url).toPromise().then(r => r.json() as Todo[]).catch(this.handleError);
  }

  public findByComplete(complete: boolean): Promise<Todo[]> {
    const url = `${this.url}?complete=${complete}`;
    return this.http.get(url).toPromise().then(r => r.json() as Todo[]).catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
