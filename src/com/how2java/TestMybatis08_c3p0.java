package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;
/**
 * 使用c3p0连接池
 * @author Administrator
 *
 */
public class TestMybatis08_c3p0 {
	public static void main(String[] args) throws IOException {
        String resource = "mybatis-config-c3p0.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<Category> cs =session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
 
        session.close();		
	}
}
