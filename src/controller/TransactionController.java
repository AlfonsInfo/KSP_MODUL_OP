
package controller;

import java.util.List;
import model.PurchaseItemDto;
import service.TransactionService;

public class TransactionController {
    private final TransactionService transactionService = new TransactionService();
    
    public String doProductPurchaseTransaction(List<PurchaseItemDto> items){
        return transactionService.productPurchase(items);
    }
    
}
