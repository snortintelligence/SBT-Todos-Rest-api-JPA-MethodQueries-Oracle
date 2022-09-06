package com.snort.intelli.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.snort.intelli.app.repository.TodosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.snort.intelli.app.entites.Todos;

@RestController
@RequestMapping("/todos")
public class TodosController {

	private Logger log = LoggerFactory.getLogger(TodosController.class);

	//JPA repository
	@Autowired
	private TodosRepository todosRepository;

	@PostMapping("/create")
	public Todos createTask(@RequestBody Todos todos) {
		log.info("TodosController : createTask executed!");
		todos.setAssignedDate(new Date());
		return todosRepository.save(todos);
	}

	@GetMapping("/")
	public List<Todos> findAll() {
		log.info("TodosController : findAll executed!");
		return (List<Todos>) todosRepository.findAll();
	}

	@GetMapping("/bytitle")
	public List<Todos> findByTitle(@RequestParam("title") String title) {
		log.info("TodosController : findByTitle executed!");
		return (List<Todos>) todosRepository.findByTitle(title);
	}

	@GetMapping("/byassigned")
	public List<Todos> findByAssignedBy(@RequestParam("assignedBy") String assignedBy) {
		log.info("TodosController : findByAssignedBy executed!");
		return (List<Todos>) todosRepository.findByAssignedBy(assignedBy);
	}

	@GetMapping("/by/level/completed")
	public List<Todos> findByDifficultyLevelAndCompleted(@RequestParam("difficultyLevel") Integer difficultyLevel,
														 @RequestParam("completed") String completed) {
		log.info("TodosController : findByAssignedBy executed!");
		return (List<Todos>) todosRepository.findByDifficultyLevelAndCompleted(difficultyLevel, completed);
	}
	
	@GetMapping("/{id}")
	public Todos findOneTodo(@PathVariable Long id) {
		log.info("TodosController : findOneTodo executed!");
		Optional<Todos> todos = todosRepository.findById(id);
		//return todos.get();
		//return todos.orElse(new Todos());

//		return todos.orElseThrow(() -> {
//			return new RuntimeException("No Todos found for given id : "+id);
//		});
		return todos.orElseGet(() -> {
			return new Todos();
		});
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOneTodo(@PathVariable Long id) {
		log.info("TodosController : deleteOneTodo executed!");
		try {
			todosRepository.deleteById(id);
			return "Todos with id->"+id+" successfully delete!";
		}catch (Exception e){
			return "Todos with id->"+id+" failed to delete!";
		}
	}
	
	@PutMapping("/update/{id}")
	public Todos updateOneTodo(@PathVariable Long id, @RequestBody Todos newTodo) {
		newTodo.setTaskId(id);
		newTodo.setUpdatedDate(new Date());
		if(todosRepository.existsById(id)){
			return todosRepository.save(newTodo);
		}
		return new Todos();
	}

	@PatchMapping("/update/{id}")
	public Todos updateTodo(@PathVariable Long id, @RequestBody Todos newTodo) {
		newTodo.setTaskId(id);
		newTodo.setUpdatedDate(new Date());
		if(todosRepository.existsById(id)){
			return todosRepository.save(newTodo);
		}
		return new Todos();
	}
	
}
