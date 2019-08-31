package com.liqiang.domain;


import com.liqiang.base.domain.BaseDomain;

public class Employee extends BaseDomain {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }
}
