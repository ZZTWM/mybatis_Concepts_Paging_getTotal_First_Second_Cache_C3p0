package com.how2java;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * xmlWay方式获取总数
 * @author Administrator
 *
 */
public class TestMybatis10_getTotal_xmlWay {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		getTotalxmlWay(session);
		
		session.commit();
		session.close();
	}

	private static void getTotalxmlWay(SqlSession session) {
		int total = session.selectOne("getCount");
		System.out.println(total);
	}
}
