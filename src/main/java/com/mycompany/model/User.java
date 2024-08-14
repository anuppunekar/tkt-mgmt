/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

/**
 *
 * @author 
 * 14-Aug-2024: added emailid
 */
public class User {

    private Integer userid;
    private String username;
    private String emailid;

    public User(Integer userid, String username){
        this.userid = userid;
        this.username = username;
    }

    public User(Integer userid, String username, String emailid){
        this.userid = userid;
        this.username = username;
        this.emailid = emailid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
