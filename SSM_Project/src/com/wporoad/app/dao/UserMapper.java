package com.wporoad.app.dao;

import java.util.List;


import com.wporoad.app.entity.User;

public interface UserMapper {

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 列出所有用户
	 * 
	 * @return
	 */
	public List<User> queryUsers();

	/**
	 * 获取总记录数
	 */
	// public int getTotalCount();

	/**
	 * 分页列出所有用户
	 * @return
	 */
	// public List<User> findAllInfo(PageModel<User> pageModel);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void delUser(int id);

	/**
	 * 详细信息
	 * @param id
	 */
	public List<User> detailUser(int id);

	/**
	 * 修改信息
	 * 
	 * @param User
	 */
	public void updateUser(User User);
}