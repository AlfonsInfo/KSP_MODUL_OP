package service;

import connection.DbConnection;
import dao.ProductDao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.PurchaseItemDto;
import dao.TransactionDao;
import dao.TransactionDetailDao;
import model.Product;
import model.Transaction;
import model.TransactionDetail;

public class TransactionService {
    
   private final TransactionDao transactionDao = new TransactionDao();
   private final TransactionDetailDao transactionDetailDao = new TransactionDetailDao();
   private final ProductDao productDao = new ProductDao();
    
    public String productPurchase(List<PurchaseItemDto> purchasedItems){
        try {
            UUID transactionId = UUID.randomUUID();
            Timestamp transactionDatetime = new Timestamp(System.currentTimeMillis());
            DbConnection.makeConnection();
            DbConnection.connection.setAutoCommit(false);
            BigDecimal total = countTotalTransaction(purchasedItems);
            System.out.println(total);
            
            //* Create Transaction
            Transaction transaction = new Transaction();
            transaction.setTransactionId(transactionId.toString());
            transaction.setTransactionDate(transactionDatetime);
            transaction.setTotal(total);
            transaction.setBuyer("buyer-dummy");
            transaction.setCashier("cashier-dummy");
            transactionDao.create(DbConnection.connection, transaction);
            List<TransactionDetail> transactionDetails =  new ArrayList<>();
            List<Product> products =  new ArrayList<>();
            
            //Create Detail transaction
            purchasedItems.forEach(item -> {
                UUID transactionDetailId = UUID.randomUUID();
                  TransactionDetail transactionDetail = new TransactionDetail();
                  transactionDetail.setProductId(item.getProduct().getId());
                  transactionDetail.setQuantityPurchased(item.getQuantityPurchased());
                  transactionDetail.setSubTotal(countSubTotalTransaction(item));
                  transactionDetail.setTransactionId(transactionId.toString());
                  transactionDetail.setTransactionDetailId(transactionDetailId.toString());
                  transactionDetails.add(transactionDetail);
                  
                  Product product = item.getProduct();
                  product.setStock(product.getStock() - item.getQuantityPurchased());
                  products.add(product);
            });
              transactionDetailDao.batchCreate(DbConnection.connection, transactionDetails);
              productDao.batchUpdate(DbConnection.connection, products);

            DbConnection.connection.commit();
            DbConnection.connection.close();
            return String.valueOf(total);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Untuk debugging, tampilkan trace pengecualian
            try {
                if (DbConnection.connection != null) {
                    DbConnection.connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    public BigDecimal countTotalTransaction(List<PurchaseItemDto> purchasedItems){
        purchasedItems.forEach(System.out::println);
       return purchasedItems.stream()
                .map(this::countSubTotalTransaction)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public BigDecimal countSubTotalTransaction(PurchaseItemDto purchasedItem){
        BigDecimal price = purchasedItem.getProduct().getPrice();
        BigDecimal quantity = new  BigDecimal(purchasedItem.getQuantityPurchased());
        
        return price.multiply(quantity); 
    }
    
}
