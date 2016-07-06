package com.wporoad.app.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wporoad.app.entity.User;

public class Test extends DBInit {
	private static SqlSession sqlSession = null;
	static SqlSessionFactory sqlSessionFactory;
	static {
		sqlSessionFactory = DBInit.getSqlSessionFactory();
	}
	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		sqlSession=sqlSessionFactory.openSession();
		//4.调用mapper映射文件插入数据(需要将mapper文件添加进config文件中)
		User u = new User();
		u.setId(2);
		u.setUsername("霸王");
		u.setPassword("qq985213");
		u.setEmail("3780042@qq.com");
		//调用插入方法，参数1：命名空间+sql的ID；参数2：SQL执行的输入参数
		sqlSession.insert("com.wporoad.app.dao.UserMapper.addUser", u);
		sqlSession.commit();//不要忘记提交
		sqlSession.close();//不要忘记关闭session
		System.out.println("添加数据结束，请到数据库查看！");
	}
}
