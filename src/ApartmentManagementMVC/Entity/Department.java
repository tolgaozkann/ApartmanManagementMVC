/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

import java.util.Date;

/**
 *
 * @author ozkan
 */
public class Department {
    private short departmentID;
	private String name;
	private String groupName;
	private Date modifiedDate;	
	
	public Department() {
		
	}
	
	public Department(String name, String groupName) {
		this.name = name;
		this.groupName = groupName;
	}

	public Department(short departmentID, String name, String groupName, Date modifiedDate) {
		this.departmentID = departmentID;
		this.name = name;
		this.groupName = groupName;
		this.modifiedDate = modifiedDate;
	}
	
	public short getDepartmentID() { return departmentID; }
	
	public void setDepartmentID(short departmentID) { this.departmentID = departmentID; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getGroupName() { return groupName; }
	
	public void setGroupName(String groupName) { this.groupName = groupName; }
	
	public Date getModifiedDate() { return modifiedDate; }	
	
	public void setModifiedDate(Date modifiedDate) { this.modifiedDate = modifiedDate; }
	
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "DepartmentID": return departmentID;
		case "Name": return name;
		case "GroupName": return groupName;
		case "ModifiedDate": return modifiedDate;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return departmentID + ", " + name + ", " + groupName + ", " + modifiedDate;
	}
}
