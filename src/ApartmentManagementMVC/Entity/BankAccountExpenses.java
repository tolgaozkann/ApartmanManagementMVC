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
public class BankAccountExpenses {
    private BigDecimal bankAccountId;
    private int expenseId;
    private Date date;
    private String bill;

    public BankAccountExpenses() {
    }

    public BankAccountExpenses(BigDecimal bankAccountId, int expenseId, Date date, String bill) {
        this.bankAccountId = bankAccountId;
        this.expenseId = expenseId;
        this.date = date;
        this.bill = bill;
    }

    public BigDecimal getBankAccountId() {
        return bankAccountId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public Date getDate() {
        return date;
    }

    public String getBill() {
        return bill;
    }

    public void setBankAccountId(BigDecimal bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
    
    public Object getByName(String field){
        switch(field)
        {
            case "BankAccountId": return bankAccountId;
            case "ExpenseId":return expenseId;
            case "Date": return date;
            case "Bill": return bill;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return bankAccountId +", " + expenseId + ", " + date + ", " + date+ ", "+ bill ;
    }
    
}
