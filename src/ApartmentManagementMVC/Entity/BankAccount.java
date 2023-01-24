/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Entity;

import java.math.BigDecimal;

/**
 *
 * @author ozkan
 */
public class BankAccount {
    private BigDecimal accountNo;
    private BigDecimal balance;
    private int apartmentId;
    
    
    public BankAccount(){

    }
    
    public BankAccount(BigDecimal balance,int apartmentId){
        this.balance = balance;
        this.apartmentId = apartmentId;
    }
    
    public BankAccount(BigDecimal AccountNo,BigDecimal balance,int apartmentId){
        this.accountNo = AccountNo;
        this.balance = balance;
        this.apartmentId = apartmentId;
    }

    public BigDecimal getAccountNo() {
        return accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setAccountNo(BigDecimal AccountNo) {
        this.accountNo = AccountNo;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }
    
    public Object getByName(String field){
        switch(field)
        {
            case "AccountNo": return accountNo;
            case "Balance":return balance;
            case "ApartmentId": return apartmentId;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return accountNo +", " + balance + ", " + apartmentId;
    }
    
    
}
