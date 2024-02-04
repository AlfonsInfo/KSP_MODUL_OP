package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.TransactionDetail;

public class TransactionDetailDao {

    private static final String INSERT_TRANSACTION_DETAIL = "INSERT INTO transaction_detail (detail_id, transaction_id , product_id, quantity_purchased, sub_total) values (? , ?, ? , ?, ? )";
    
    public void batchCreate(Connection connection , List<TransactionDetail> transactionDetails) throws SQLException{
        PreparedStatement  statement = null;
        try{
            statement = connection.prepareStatement(INSERT_TRANSACTION_DETAIL);
            for(TransactionDetail transactionDetail : transactionDetails){    
                statement.setString(1, transactionDetail.getTransactionDetailId());
                statement.setString(2,transactionDetail.getTransactionId());
                statement.setInt(3,transactionDetail.getProductId());
                statement.setInt(4,  transactionDetail.getQuantityPurchased());
                statement.setBigDecimal(5,transactionDetail.getSubTotal());
                statement.addBatch();
            }
            statement.executeBatch();      
        }finally{
            if(statement != null){
                statement.close();     
            }
        }
        }
}
