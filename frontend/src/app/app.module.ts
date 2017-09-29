import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {TodoComponent} from './todo/todo.component';
import {TodoService} from './todo.service';
import { CompletionfilterPipe } from './completionfilter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    CompletionfilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [TodoService],
  bootstrap: [AppComponent]
})
export class AppModule {}
