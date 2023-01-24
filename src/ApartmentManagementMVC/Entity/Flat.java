/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

/**
 *
 * @author ozkan
 */
public class Flat {
    private int flatId;
    private int apartmentNo;
    private int flatNo;

    public Flat() {
    }

    public Flat(int apartmentNo, int flatNo) {
        this.apartmentNo = apartmentNo;
        this.flatNo = flatNo;
    }

    public Flat(int flatId, int apartmentNo, int flatNo) {
        this.flatId = flatId;
        this.apartmentNo = apartmentNo;
        this.flatNo = flatNo;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public int getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(int apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }
    
     public Object getByName(String field){
        switch(field)
        {
            case "FlatId": return flatId;
            case "ApartmentNo":return apartmentNo;
            case "FlatNo": return flatNo;
            default: return null;
        }
    }
     public String toString(){
         return flatId+", "+apartmentNo+", "+flatNo;
     }
}
