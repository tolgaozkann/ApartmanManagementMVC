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
public class PersonRole {
    private int personId;
    private int roleId;
    private Date startingDate;
    private Date endingDate;

    public PersonRole() {
    }

    public PersonRole(int personId, int roleId, Date startingDate, Date EndingDate) {
        this.personId = personId;
        this.roleId = roleId;
        this.startingDate = startingDate;
        this.endingDate = EndingDate;
    }

    public int getPersonId() {
        return personId;
    }

    public int getRoleId() {
        return roleId;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(Date EndingDate) {
        this.endingDate = EndingDate;
    }
    
    public Object getByName(String field){
        switch(field){
            case "PersonId": return personId;
            case "RoleId": return roleId;
            case "StartingDate": return startingDate;
            case "EndingDate": return endingDate;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return  personId + ", " + roleId + ", " + startingDate + ", " + endingDate;
    }
    
}
