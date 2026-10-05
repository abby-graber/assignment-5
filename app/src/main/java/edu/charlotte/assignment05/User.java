package edu.charlotte.assignment05;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String email;
    private String role;
    private String income;
    private String status;

    public User(String name, String email, String role, String income, String status) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.income = income;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getIncome() {
        return income;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}