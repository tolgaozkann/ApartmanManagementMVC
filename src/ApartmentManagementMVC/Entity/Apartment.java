/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

/**
 *
 * @author baransonmez
 */
public class Apartment {
    private int apartmentNo;
    private String address;

    public Apartment(){

    }
    public Apartment(String address){
        this.address= address;
    }

    public Apartment(int apartmentNo, String address ){
        this.apartmentNo= apartmentNo;
        this.address= address;

    }

    public int getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(int apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getByName(String field) {
		switch (field) {
		case "ApartmentNo": return apartmentNo;
		case "Address": return address;
		default: return null;
		}
	}

    @Override
    public String toString() {
        return apartmentNo +", "+address;
    }


}