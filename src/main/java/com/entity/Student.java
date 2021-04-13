
package com.entity;

public class Student {

    private int id;

    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", salary=" + salary +
            '}';
    }
}




