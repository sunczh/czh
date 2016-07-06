package com.wporoad.app.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wporoad.app.entity.User;
import com.wporoad.app.service.UserService;
import com.wporoad.app.util.PageModel;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UserAction.class);

	public UserService userService;
	private int id;
	private String userName;
	private String password;
	private String email;
	private PageModel<?> pageModel;

	/**
	 * 添加用户信息
	 * 
	 * @return
	 */
	public String addUser() {
		User user = new User();
		try {
			user.setId(id);
			user.setUsername(userName);
			user.setPassword(password);
			user.setEmail(email);
			userService.addUser(user);
		} catch (Exception e) {
			logger.error("exception in add user", e);
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 从数据库中获得所有的用户信息
	 * 
	 * @return
	 */
	public String queryUsers() {
		try {
			List<User> userList = userService.queryUsers();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", userList);
			return "list";
		} catch (Exception e) {
			logger.error("Exception in queryUsers", e);
			return ERROR;
		}
	}

	/**
	 * 分页获取所有用户的信息
	 */
	/*public String findAllInfo() {
		// pageNo标记为当前从哪条记录开始
		int pageNo;
		String p = ServletActionContext.getRequest().getParameter("pageNo");
		if (p == null)
			pageNo = 0;
		else
			pageNo = Integer.parseInt(p);
		// 下面方法传入当前记录，及每页将要显示的记录条数，此例为每页显示5条
		// 返回一个PageModel<T>类型，包括一个集合及其它属性，具体在Model查看
		PageModel<User> pageModel = new PageModel<User>();
		List list =  userService.findAllInfo(pageModel);
		PageModel<User> totalRecords = userService.getTotalCount();
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(3);
		
		
		// setAttribute，在jsp页面用来取到集合的值
		ServletActionContext.getRequest().setAttribute("pagemodel",
				pageModel.getList());

		return SUCCESS;
	}*/

	/**
	 * 删除用户信息
	 * 
	 * @return
	 */
	public String delUser() {
		try {
			userService.delUser(id);
			List<User> userList = userService.queryUsers();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", userList);
		} catch (Exception e) {
			logger.error("Exception in delUser", e);
			return ERROR;
		}
		return "list";
	}

	public String detailUser() {
		try {
			List<User> userList = userService.detailUser(id);
			User user = userList.get(0);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("user", user);
			return "detail";
		} catch (Exception e) {
			logger.error(e);
			return ERROR;
		}
	}

	public String update() {
		List<User> userList = userService.detailUser(id);
		User user = userList.get(0);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		return "update";
	}

	public String updateUser() {
		try {
			User user = new User();
			user.setId(id);
			user.setUsername(userName);
			user.setPassword(password);
			user.setEmail(email);
			userService.updateUser(user);
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e);
			return ERROR;
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PageModel<?> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<?> pageModel) {
		this.pageModel = pageModel;
	}

}