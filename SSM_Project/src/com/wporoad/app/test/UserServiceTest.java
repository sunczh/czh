package com.wporoad.app.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wporoad.app.entity.User;
import com.wporoad.app.service.UserService;

public class UserServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resource/applicationContext.xml");
        UserService userService = (UserService)context.getBean("userService");
       List<User> list =userService.detailUser(1);
       for (User user : list) {
    	   System.out.println("用户ID:"+user.getId()+"\t用户姓名:"+user.getUserName()
    			   +"\t用户密码:"+user.getPassword()+"\t用户邮箱:"+user.getEmail());
	}
        
	}

}
