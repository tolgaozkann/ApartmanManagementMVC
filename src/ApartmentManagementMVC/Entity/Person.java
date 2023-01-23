/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

import java.math.BigDecimal;

/**
 *qs
 * @author ozkan
 * sa
 */
public class Person {

    private int id;
    private String name;
    private String surname;
    private int flatId;
    private BigDecimal ssn;
    private String email;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String surname, int flatId, BigDecimal ssn, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.flatId = flatId;
        this.ssn = ssn;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person(int id, String name, String surname, int flatId, BigDecimal ssn, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.flatId = flatId;
        this.ssn = ssn;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getFlatId() {
        return flatId;
    }

    public BigDecimal getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public void setSsn(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Object getByName(String field){
        switch(field)
        {
            case "Id": return id;
            case "Name":return name;
            case "Surname": return surname;
            case "FlatId": return flatId;
            case "SSN": return ssn;
            case "Email": return email;
            case "Phone Number": return phoneNumber;
            default: return null;
        }
    }
    
    @Override
    public String toString(){
        return id +", " + name + " " + surname + ", " + ssn+ ", "+ flatId + ", " + email + ", "  + phoneNumber;
    }

}
