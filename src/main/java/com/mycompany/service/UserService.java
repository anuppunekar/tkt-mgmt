/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.User;
import java.util.List;

/**
 *
 * @author 
 */
public interface UserService {
    public List<User> getAllUsers();
    public User getUser(Integer id);
}
