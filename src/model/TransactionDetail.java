package model;

import java.math.BigDecimal;

public class TransactionDetail {
    private String transactionDetailId;
    private String transactionId;
    private Integer productId;
    private Integer quantityPurchased;
    private BigDecimal subTotal;

    public TransactionDetail() {
    }

    public TransactionDetail(String transactionDetailId, String transactionId, Integer productId, Integer quantityPurchased, BigDecimal subTotal) {
        this.transactionDetailId = transactionDetailId;
        this.transactionId = transactionId;
        this.productId = productId;
        this.quantityPurchased = quantityPurchased;
        this.subTotal = subTotal;
    }

    public String getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(String transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
    
    
}
