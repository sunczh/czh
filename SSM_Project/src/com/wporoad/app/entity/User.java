package com.wporoad.app.entity;

import java.io.Serializable;

public class User implements Serializable {

  /**
   * 用户信息实体类
   */
  private static final long serialVersionUID = 1L;

  private int id;
  private String userName;
  private String password;
  private String email;
  
  public User() {
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserName() {
    return userName;
  }

  public void setUsername(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}