/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

/**
 *
 * @author ozkan
 */
public class Role {
    private int id;
    private String roleName;

    public Role() {
    }

    public Role(String name) {
        this.roleName = name;
    }

    public Role(int id, String name) {
        this.id = id;
        this.roleName = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return roleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.roleName = name;
    }
    
    public Object getByName(String field){
        switch(field)
        {
            case "Id": return id;
            case "Name": return roleName;
            default: return null;
        }
    }
    
    @Override
    public String toString(){
        return id + ", " + roleName;
    }
}
