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
public class BankAccountIncome {
    private BigDecimal bankAccountId;
    private int incomeId;
    private Date date;
    private String receipt;
    private int payerPersonId;

    public BankAccountIncome() {
    }

    public BankAccountIncome(BigDecimal bankAccountId, int incomeId, Date date, String receipt, int payerPersonId) {
        this.bankAccountId = bankAccountId;
        this.incomeId = incomeId;
        this.date = date;
        this.receipt = receipt;
        this.payerPersonId = payerPersonId;
    }

    public BigDecimal getBankAccountId() {
        return bankAccountId;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public Date getDate() {
        return date;
    }

    public String getReceipt() {
        return receipt;
    }

    public int getPayerPersonId() {
        return payerPersonId;
    }

    public void setBankAccountId(BigDecimal bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public void setPayerPersonId(int payerPersonId) {
        this.payerPersonId = payerPersonId;
    }
    
    public Object getByName(String field){
        switch(field)
        {
            
            case "BankAccountId": return bankAccountId;
            case "IncomeId": return incomeId;
            case "Date": return date;
            case "Receipt": return receipt;
            case "PayerPersonId": return payerPersonId;
            default: return null;
        }
    }
    
    @Override
    public String toString(){
        return bankAccountId +", " + incomeId + ", " + date + ", " + receipt+ ", "+ payerPersonId ;
    }
}
