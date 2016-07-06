package com.wporoad.app.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBInit {
	private final static SqlSessionFactory sqlSessionFactory;
	static{
			//1.获取配置文件输入流
			String resource = "resource/mybatis-config.xml";
			InputStream is = null;
			try {
			     is = Resources.getResourceAsStream(resource);
		    } catch (IOException e) {
			     System.out.println(e.getMessage());
		    }
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	   }
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
}
