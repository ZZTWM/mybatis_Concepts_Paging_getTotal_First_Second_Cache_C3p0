package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;

/**
 * ʹ��PageHelper��ȡ����
 * @author Administrator
 *
 */
public class TestMybatis05_getTotal_PageHelper {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		//��ҳ
		PageHelper.offsetPage(0, 5);
		
		List<Category> cs = session.selectList("listCategory");
		for (Category category : cs) {
			System.out.println(category.getName());
		}
		
		//��ȡ����
		PageInfo pageInfo = new PageInfo<>(cs);
		System.out.println("������" + pageInfo.getTotal());
		System.out.println(pageInfo);
		
		session.commit();
		session.close();
	}
}
