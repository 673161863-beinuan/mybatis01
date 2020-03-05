package com.atguigu.test;

import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {

    @org.junit.Test
    public void test01() throws IOException {

        String resource = "sqlMaperConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = mapper.getEmployeeById(1);
        System.out.println(employee);

    }
}
