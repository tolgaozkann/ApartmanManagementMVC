/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ozkan
 */
public class Income {
    private int id;
    private BigDecimal amount;
    private String description;
    private int flatId;
    private Date date;

    public Income() {
    }

    public Income(BigDecimal amount, String description, int flatId, Date date) {
        this.amount = amount;
        this.description = description;
        this.flatId = flatId;
        this.date = date;
    }

    public Income(int id, BigDecimal amount, String description, int flatId, Date date) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.flatId = flatId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     public Object getByName(String field){
        switch(field)
        {
            case "Id": return id;
            case "Amount":return amount;
            case "Description": return description;
            case "FlatId": return flatId;
            case "Date": return date;
            default: return null;
        }
    }
     
     public String toString(){
         return id+", "+ amount+", "+ description+", "+flatId+", "+ date;
     }
}
