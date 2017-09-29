package todo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import todo.model.Todo;
import todo.repository.TodoRepository;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoRepository todoRepo;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Todo save(@RequestBody Todo todo) {
		return todoRepo.save(todo);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathParam("id") Long id) {
		todoRepo.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Todo> findAll() {
		return (List<Todo>) todoRepo.findAll();
	}

	@RequestMapping(params = "complete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Todo> findByComplete(@RequestParam("complete") boolean complete) {
		return (List<Todo>) todoRepo.findByComplete(complete);
	}

	/*
	 * @RequestMapping(value = "/todos", method = RequestMethod.POST, consumes =
	 * MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public @ResponseBody List<Todo>
	 * saveTodos(@RequestBody List<Todo> todos) { return (List<Todo>)
	 * todoRepo.save(todos); }
	 * 
	 * @RequestMapping(value = "/todos", method = RequestMethod.DELETE, consumes
	 * = MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public void deleteTodos(@RequestBody
	 * List<Todo> todos) { todoRepo.save(todos); }
	 */
}
