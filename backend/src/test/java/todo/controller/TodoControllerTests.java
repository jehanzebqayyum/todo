package todo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import todo.model.Todo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void saveShouldWork() throws Exception {
		Todo todo = new Todo("test1", false);
		this.mockMvc
				.perform(post("/todos").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(todo)))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)));

	}

	@Test
	public void deleteShouldWork() throws Exception {
		Todo todo = new Todo("test1", false);
		MvcResult result = this.mockMvc
				.perform(post("/todos").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(todo)))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		Todo savedTodo = mapper.readValue(result.getResponse().getContentAsString(), Todo.class);

		this.mockMvc.perform(delete("/todos").param("id", savedTodo.getId().toString())).andDo(print())
				.andExpect(status().isOk());

	}

	/*
	 * @Test public void saveShouldWork() throws Exception { Todo[] todos = new
	 * Todo[] { new Todo("test1", false), new Todo("test2", false) };
	 * 
	 * MvcResult result = this.mockMvc
	 * .perform(post("/todos").contentType(MediaType.APPLICATION_JSON).accept(
	 * MediaType.APPLICATION_JSON) .content(mapper.writeValueAsString(todos)))
	 * .andDo(print()).andExpect(status().isOk()).andReturn();
	 * 
	 * }
	 * 
	 * @Test public void deleteShouldWork() throws Exception { Todo[] todos =
	 * new Todo[] { new Todo("test1", false), new Todo("test2", false) };
	 * 
	 * MvcResult result = this.mockMvc
	 * .perform(post("/todos").contentType(MediaType.APPLICATION_JSON).accept(
	 * MediaType.APPLICATION_JSON) .content(mapper.writeValueAsString(todos)))
	 * .andDo(print()).andExpect(status().isOk()).andReturn();
	 * 
	 * Todo[] savedTodos =
	 * mapper.readValue(result.getResponse().getContentAsString(),
	 * Todo[].class);
	 * 
	 * this.mockMvc.perform(
	 * delete("/todos").contentType(MediaType.APPLICATION_JSON).content(mapper.
	 * writeValueAsString(savedTodos)))
	 * .andDo(print()).andExpect(status().isOk()); }
	 */
}
