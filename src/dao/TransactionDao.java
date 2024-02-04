    package dao;


import java.sql.PreparedStatement;
import java.util.Objects;
import model.Transaction;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionDao {
    
        private static final String INSERT_TRANSACTION_ALL = "INSERT INTO transaction (id, date, total, cashier, buyer) values (? , ?,  ? ,  ? , ? )";

        private static final String SHOW_TRANSACTION = "";
    
    
    public void create(Connection connection , Transaction transaction) throws SQLException{
        PreparedStatement  statement = null;
        try{
            statement = connection.prepareStatement(INSERT_TRANSACTION_ALL);
            statement.setString(1, transaction.getTransactionId());
            statement.setTimestamp(2,transaction.getTransactionDate());
            statement.setBigDecimal(3,transaction.getTotal());
            statement.setString(4,transaction.getCashier());
            statement.setString(5,transaction.getBuyer());
            statement.executeUpdate();      
        }finally{
            if(statement != null){
                statement.close();
                //connection.close();                
            }
        }
        
        
    }
}
