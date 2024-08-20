/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Todo;
import java.util.List;
import java.util.Date;

/**
 *
 * @author 
 * 17-Aug-2024  Added ToDoService 
 */
public interface TodoService {
    public List<Todo> retrieveTodos(String user);
    public Todo addTodo(String name, String desc, Date targetDate, boolean isDone);
    public Todo retrieveTodo(int id);
}
