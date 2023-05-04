
package DTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.logging.Logger;

public class Employee_DTO {
    private int id;
    private String username, password, name, phoneNumber;
    private String permission;
    private Timestamp startDate;
    private int salary;

    public Employee_DTO() {
    }
    
    public Employee_DTO(int id, String username, String password, String name, String phoneNumber, String permission, int salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.permission = permission;        
        this.salary = salary;
    }
    
    public Employee_DTO(int id, String username, String password, String name, String phoneNumber, String permission, Timestamp startDate, int salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.permission = permission;
        this.startDate = startDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee_DTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber + ", permission=" + permission + ", startDate=" + startDate + ", salary=" + salary + '}';
    }
     
}
