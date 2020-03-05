package com.atguigu.bean;

public class Dept {
    private Integer id;
    private String deptName;
    private Employee empls;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getEmpls() {
        return empls;
    }

    public void setEmpls(Employee empls) {
        this.empls = empls;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", empls=" + empls +
                '}';
    }
}
