package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;

/**
 * 注解的方式进行分页
 * @author Administrator
 *
 */
public class TestMybatis03_Paging_AnnotationWay {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		annotationWay(session);
		
		session.commit();
		session.close();	
	}

	private static void annotationWay(SqlSession session) {
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		List<Category> cs = mapper.listByPage(0, 10);
		for (Category category : cs) {
			System.out.println(category);
		}
	}
}
