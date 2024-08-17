/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Todo;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 
 * 17-Aug-2024  Added ToDoService 
 */
public class TodoServiceImpl implements TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int iCounttodo = 3;
    
    static {
        todos.add(new Todo(1, "D", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(2, "P", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "J", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for(Todo todo : todos) {
            if(todo.getUser().equalsIgnoreCase(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }
    
    public Todo addTodo(String name, String desc, Date targetDate, boolean isDone) {
        Todo todo = new Todo(++iCounttodo, name, desc, targetDate, isDone); 
        todos.add(todo);
        return todo;
    }
    
    public Todo retrieveTodo(int id) {
        for(Todo todo : todos) {
            if(todo.getId() == id) 
                return todo;
        }
        return null;
    }
    
}
