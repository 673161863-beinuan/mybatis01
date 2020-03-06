package com.atguigu.dao;

import com.atguigu.bean.Employee;

public interface EmployeeDao {

    //根据id查出对应的员工
    public Employee getEmployeeById(Integer id);

    //根据id 查出对应的员工还要查出这个员工所在的部门
    public Employee getEmpleeAndDeptById(Integer id);


}
