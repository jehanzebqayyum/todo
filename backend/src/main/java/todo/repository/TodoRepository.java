package todo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import todo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
	public List<Todo> findByComplete(boolean complete);
}
