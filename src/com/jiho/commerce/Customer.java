package com.jiho.commerce;

//고객
public class Customer {
    private final String customerName; //고객 이름
    private final String email; //이메일
    private final String grade; //등급

    public Customer(String customerName, String email, String grade) {
        this.customerName = customerName;
        this.email = email;
        this.grade = grade;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }
}
