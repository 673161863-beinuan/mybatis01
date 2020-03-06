package com.atguigu.test;

import com.atguigu.bean.Dept;
import com.atguigu.bean.Employee;
import com.atguigu.dao.DeptDao;
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

    //测试查询根据id查询部门内的所有员工
    @org.junit.Test
    public void test02() throws IOException {

        String resource = "sqlMaperConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept deptAndEmplsById = mapper.getDeptAndEmplsById(1);
        System.out.println(deptAndEmplsById);
        System.out.println(deptAndEmplsById.getEmpls());

    }
    @org.junit.Test
    public void test03() throws IOException {

        String resource = "sqlMaperConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee empleeAndDeptById = mapper.getEmpleeAndDeptById(1);
        System.out.println(empleeAndDeptById);
        System.out.println(empleeAndDeptById.getDept().getDeptName());

    }
    @org.junit.Test
    public void test04() throws IOException {

        String resource = "sqlMaperConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee empleeAndDeptById = mapper.getEmpleeAndDeptById(1);
        System.out.println(empleeAndDeptById.getLastName());

    }
}
