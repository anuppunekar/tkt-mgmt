/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restapp;

import com.mycompany.model.User;
import com.mycompany.service.UserService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 
 * 14-Aug-2024: added emailid
 */

@RestController
@RequestMapping("/user")
public class UserController {
    
    //R
    @Autowired
    UserService userSer;
    @ResponseBody
    @RequestMapping("/getallusers")
    public List<User> getAllUsers() {
        return userSer.getAllUsers();
    }
    
    @ResponseBody
    @RequestMapping("")
    public Map<String, Object> getUsers() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Get All Users Implementation");
        return map;
    }   

    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable("id") Integer id) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Get User Implementation");
        map.put("userid", userService.getUser(id).getUserid());
        map.put("username", userService.getUser(id).getUsername());
        map.put("emailid", userService.getUser(id).getEmailid());
        return map;
    }

    //C
    @ResponseBody
    @RequestMapping(value="", method=RequestMethod.POST)
    public Map<String, Object> createUser() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Create User Implementation");
        return map;
    }

    //U
    @ResponseBody
    @RequestMapping(value="", method=RequestMethod.PUT)
    public Map<String, Object> updateUser() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Update User Implementation");
        return map;
    }

    //D
    @ResponseBody
    @RequestMapping(value="", method=RequestMethod.DELETE)
    public Map<String, Object> deleteUser() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Delete User Implementation");
        return map;
    }
}
