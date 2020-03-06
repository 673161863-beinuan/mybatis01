package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    //动态sql 测试if判断,拼接sql语句
    public List<Employee> getEmpls(Employee employee);
    //动态sql 测试trim
    public List<Employee> getEmplsOfTrim(Employee employee);
    //动态sql 测试choose,只会进入到一个分支，一旦进入后面的无效。
    public List<Employee> getEmplsOfChoose(Employee employee);
    //动态sql 测试set 更新操作
    public void updateEmployee(Employee employee);
    //forea遍历集合的测试
    public List<Employee> getEmplsOfForea(@Param("ids") List<Integer> ids);
    //批量保存
    public void addEmpls(@Param("emps") List<Employee> emps);
}
