package com.atguigu.dao;

import com.atguigu.bean.Dept;

public interface DeptDao {


    public Dept getDeptAndEmplsById(Integer id);

    //根据id查询部门表
    public Dept getDeptById(Integer id);
}