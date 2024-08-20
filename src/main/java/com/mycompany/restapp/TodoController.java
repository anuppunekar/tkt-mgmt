/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restapp;

import com.mycompany.model.Todo;
import com.mycompany.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/user/{name}/todos")
    public List<Todo> retrieveTodos(@PathVariable String name) {
        return todoSer.retrieveTodos(name);
    }

    /**
     * Retrieve details for a specific Todo 
     */
    @ResponseBody
    @RequestMapping(path = "/user/{name}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String name, @PathVariable int id) {
        return todoSer.retrieveTodo(id);
    }
}
