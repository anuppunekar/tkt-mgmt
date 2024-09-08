/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restapp;

import com.mycompany.model.Todo;
import com.mycompany.service.TodoService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author 
 * 17-Aug-2024  Added TodoController 
 */
@RestController
public class TodoController {
    
    @Autowired
    private TodoService todoSer;
    
    /**
     * Retrieve Todos 
     */
    @ResponseBody
    @RequestMapping("/user/{name}/gettodos")
    public List<Todo> retrieveTodos(@PathVariable String name) {
        return todoSer.retrieveTodos(name);
    }

    /**
     * Retrieve details for a specific Todo 
     */
    @ResponseBody
    @RequestMapping(path = "/user/{name}/gettodos/{id}")
    public Todo retrieveTodo(@PathVariable String name, @PathVariable int id) {
         Todo todo = todoSer.retrieveTodo(id);
         if (todo == null) {
             throw new TodoNotFoundException("Todo Not Found");
         }
         return todo;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/{name}/todos")
    public ResponseEntity<?> addTodo(@PathVariable String name, @RequestBody Todo todo) {
        Todo createdTodo = todoSer.addTodo(name, todo.getDesc(), todo.getTargetDate(), true);
        if (createdTodo == null) {
            //return that the creation of the resource failed
            return ResponseEntity.noContent().build();
        }
        //URI for the created resource that can be returned in the response.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        //Returns a status of 201(CREATED) with a link to the resource created
        return ResponseEntity.created(location).build();
        
    }
}
