package model;

/**
 *
 * @author A412DA
 */
public class PurchaseItemDto {
    private Product product;
    private Integer quantityPurchased;

    public PurchaseItemDto(Product product, Integer quantityPurchased) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    

    
}
