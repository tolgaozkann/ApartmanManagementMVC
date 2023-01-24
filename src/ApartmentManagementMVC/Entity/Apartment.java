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
    private int managerId;

    public Apartment(){

    }
    public Apartment(String address,  int managerId){
        this.address= address;
        this.managerId=managerId;
    }

    public Apartment(int apartmentNo, String address,  int managerId ){
        this.apartmentNo= apartmentNo;
        this.address= address;
        this.managerId= managerId;

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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Object getByName(String field) {
		switch (field) {
		case "ApartmentNo": return apartmentNo;
		case "Address": return address;
		case "ManagerId": return managerId;
		default: return null;
		}
	}

    @Override
    public String toString() {
        return apartmentNo +", "+address+", "+managerId;
    }


}