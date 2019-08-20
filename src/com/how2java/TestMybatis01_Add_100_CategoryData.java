package com.how2java;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
  
public class TestMybatis01_Add_100_CategoryData {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        List<Category> cs = session.selectList("listCategory");
        for (Category category : cs) {
			session.delete("deleteCategory",category);
		}
        
        for (int i = 0; i < 100; i++) {
			Category c = new Category();
			c.setName("category name" + i);
			session.insert("addCategory",c);
		}
        
        List<Category> cs2 = session.selectList("listCategory");
        for (Category category : cs2) {
			System.out.println(category.getName());
		}
        
        session.commit();
        session.close();
    }
}