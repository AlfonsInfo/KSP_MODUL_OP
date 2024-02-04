package model;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Transaction {
    private String transactionId;
    private Timestamp transactionDate;
    private BigDecimal total;
    private String cashier;
    private String buyer;

    public Transaction() {
    }

    
    public Transaction(String transactionId, Timestamp transactionDate, BigDecimal total) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.total = total;
        this.cashier = "cashier-dummy";
        this.buyer = "buyer-dummy";
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
    
    
    
    


    
    
}
