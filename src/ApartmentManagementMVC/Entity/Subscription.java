/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

import java.util.Date;

/**
 *
 * @author baransonmez
 */
public class Subscription {

    private int id;
    private String category;
    private Date dueDate;
    private int apartmentId;
    private String image;

    public Subscription() {

    }

    public Subscription(String category, Date dueDate, int apartmentId, String image) {
        this.category = category;
        this.dueDate = dueDate;
        this.apartmentId = apartmentId;
        this.image = image;

    }

    public Subscription(int id, String category, Date dueDate, int apartmentId, String image) {
        this.id = id;
        this.category = category;
        this.dueDate = dueDate;
        this.apartmentId = apartmentId;
        this.image = image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getByName(String field) {
        switch (field) {
            case "Id":
                return id;
            case "Category":
                return category;
            case "DueDate":
                return dueDate;
            case "ApartmentId":
                return apartmentId;
            case "Image":
                return image;
            default:
                return null;
        }
    }

    public String toString() {
        return id + ", " + category + ", " + dueDate + ", " + apartmentId + " ," + image;
    }

}
