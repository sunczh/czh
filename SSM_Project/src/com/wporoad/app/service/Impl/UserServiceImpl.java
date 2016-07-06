package com.wporoad.app.service.Impl;

import java.util.List;

import com.wporoad.app.dao.UserMapper;
import com.wporoad.app.entity.User;
import com.wporoad.app.service.UserService;

public class UserServiceImpl implements UserService {
  private UserMapper userMapper;

  public UserMapper getUserMapper() {
    return userMapper;
  }

  public void setUserMapper(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  /**
   * 添加用户
   */
  public void addUser(User user) {
    userMapper.addUser(user);
  }

  /**
   * 列出所有用户
   */
   public List<User> queryUsers() {
    List<User> userList = userMapper.queryUsers();
    return userList;
  }
  /**
   * 获取总记录数
   */
 /* @Override
  public int getTotalCount() {
  	return userMapper.getTotalCount();
  }*/
  /**
   * 分页列出所有用户
   */
 /* public List<User> findAllInfo(PageModel<User> pageModel) {
	  List<User> userList = userMapper.findAllInfo(pageModel);
	  return userList;
  }*/

  /**
   * 删除用户
   */
  public void delUser(int id) {
    userMapper.delUser(id);
  }
  /**
   * 获取单个用户的所有信息
   */
  public List<User> detailUser(int id) {
    return userMapper.detailUser(id);
  }

  /**
   * 修改单个用户的信息
   */
  public void updateUser(User User) {
    userMapper.updateUser(User);
  }


}