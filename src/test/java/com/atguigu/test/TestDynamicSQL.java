package com.atguigu.test;

import com.atguigu.bean.Dept;
import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeMapperDynamicSQL;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.sun.xml.internal.ws.developer.ServerSideException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDynamicSQL {


    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "sqlMaperConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        return sqlSessionFactory;
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(null, "张", null, null, null);
        List<Employee> empls = mapper.getEmpls(employee);
        for (Employee empl : empls) {
            System.out.println(empl);
        }
        session.close();

        //如果第一个参数没有被带上，那么sql语句就会发生错误！ select * from tb where and last_name like '';
        //解决方法
        //1.在where 后面加上一个 1=1
        //2.mybatis推荐使用方式 <where></where>标签但是 如果and不能写在字段后面。
        //如果and写在字段的后面拼接sql语句时的最后一个没有使用，就会多出一个and 例如：select * from tb where and last_name like '' and
        //那么我们就需要使用trim这个标签
    }

    @Test
    public void test02Trim() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(null, "张", null, null, null);
        List<Employee> empls = mapper.getEmplsOfTrim(employee);
        for (Employee empl : empls) {
            System.out.println(empl);
        }
        session.close();
        //如果and写在字段的后面拼接sql语句时的最后一个没有使用，就会多出一个and 例如：select * from tb where and last_name like '' and
        //那么我们就需要使用trim这个标签
    }

    @Test
    public void test03Choose() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(null, null, null, null, null);
        List<Employee> empls = mapper.getEmplsOfChoose(employee);
        for (Employee empl : empls) {
            System.out.println(empl);
        }
        session.close();

    }
    @Test
    public void test04Set() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(1, "张三", null, null, null);
        mapper.updateEmployee(employee);
        //一定要commit提交
        session.commit();
        session.close();

    }
    @Test
    public void test05Forea() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> empls = mapper.getEmplsOfForea(Arrays.asList(1, 2, 3,4));
        for (Employee empl : empls) {
            System.out.println(empl);
        }
        session.close();

    }
    @Test
    public void test06BatchSave() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> empls = new ArrayList<>();
        empls.add(new Employee(null,"jack","jack@aliyun.com",'男',new Dept(1)));
        empls.add(new Employee(null,"rose","rose@aliyun.com",'女',new Dept(1)));
        mapper.addEmpls(empls);
        //一定要commit提交
        session.commit();
        session.close();

    }
}
