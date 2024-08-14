/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.User;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
/**
 *
 * @author 
 * 14-Aug-2024: added emailid
 */
@Service
public class UserServiceImpl implements UserService {

    public static List<User> users;
    
    @Override
    public List<User> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        return this.users;
    }
    
    public UserServiceImpl() {
        users = new LinkedList<>();
        //users.add(new User(100, "D"));
        //users.add(new User(101, "P"));
        //users.add(new User(102, "J"));
        users.add(new User(100, "D", "D@mycompany.com"));
        users.add(new User(101, "P", "P@mycompany.com"));
        users.add(new User(102, "J", "J@mycompany.com"));
    }

    @Override
    public User getUser(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.users.get(id);
    }
}
