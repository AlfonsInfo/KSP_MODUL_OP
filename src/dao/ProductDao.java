package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import utils.Helper;

public class ProductDao {

    private static final String CREATE_QUERY = "INSERT INTO product  ( name, type, price, stock) values (  ? , ? , ? , ? )";
    private static final String READ_AND_SEARCH_QUERY = "SELECT * FROM product "
            + "WHERE product_id LIKE ? OR name LIKE ? OR type LIKE ? OR price LIKE ? OR stock LIKE ?"; //* show all & search
    private static final String UPDATE_QUERY = "UPDATE  product SET name =  ? ,type = ? , price = ? , stock = ? WHERE product_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM product WHERE product_id  = ? ";
        
    private static final String FIND_BY_ID = "SELECT * FROM product where product_id = ?"; //* Search hanya menggunakan id

    private static final String PRODUCT_ID = "product_id";
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_TYPE = "type";
    private static final String PRODUCT_PRICE = "price";
    private static final String PRODUCT_STOCK = "stock";

    public void create(Product product) {
        DbConnection.makeConnection();
        try (PreparedStatement statement = DbConnection.connection.prepareStatement(CREATE_QUERY)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setBigDecimal(3, product.getPrice());
            statement.setInt(4, product.getStock());
            int result = statement.executeUpdate();
            Helper.log("result : " + result, Helper.getCurrentMethodName());
        } catch (SQLException e) {
            Helper.log(e.getMessage(), Helper.getCurrentMethodName());
            //throw new CustomException(Constant.ExceptionMessage.SERVER_ERROR);
        } finally {
            DbConnection.closeConnection();
        }
    }

    public List<Product> read(String searchKey) {
        String methodName = Helper.getCurrentMethodName();
        List<Product> products = new ArrayList<>();
        try {
            DbConnection.makeConnection();
            try (PreparedStatement statement = DbConnection.connection.prepareStatement(READ_AND_SEARCH_QUERY)) {
                statement.setString(1, "%" + searchKey + "%");
                statement.setString(2, "%" + searchKey + "%");
                statement.setString(3, "%" + searchKey + "%");
                statement.setString(4, "%" + searchKey + "%");
                statement.setString(5, "%" + searchKey + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setId(resultSet.getInt(PRODUCT_ID));
                        product.setName(resultSet.getString(PRODUCT_NAME));
                        product.setType(resultSet.getString(PRODUCT_TYPE));
                        product.setPrice(resultSet.getBigDecimal(PRODUCT_PRICE));
                        product.setStock(resultSet.getInt(PRODUCT_STOCK));
                        products.add(product);
                    }
                }
                Helper.log("success", methodName);
            }
        } catch (SQLException e) {
            Helper.log(e.getMessage(), methodName);
//            throw new CustomException(Constant.ExceptionMessage.SERVER_ERROR);
        } finally {
            DbConnection.closeConnection();
        }
        return products;
    }
    
    public void update(Integer id, Product product){
             DbConnection.makeConnection();
         try(PreparedStatement statement = DbConnection.connection.prepareStatement(UPDATE_QUERY)){
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setBigDecimal(3, product.getPrice());
            statement.setInt(4, product.getStock());
            statement.setInt(5, id);
            int result = statement.executeUpdate();
            Helper.log("update success, result " + result, Helper.getCurrentMethodName());
        }catch(SQLException e){
            Helper.log(e.getMessage(), Helper.getCurrentMethodName());
//            throw new CustomException(Constant.ExceptionMessage.SERVER_ERROR);// rethrow exception jika ingin di handle juga oleh view layers
        }finally{
            DbConnection.closeConnection();
        }
                  
    }
         
        public void delete(String id){
            DbConnection.makeConnection();
            try(PreparedStatement statement = DbConnection.connection.prepareStatement(DELETE_QUERY)){
                statement.setString(1, id);
                statement.executeUpdate();
            }catch(SQLException e){
                Helper.log(e.getMessage(), Helper.getCurrentMethodName());
            }finally{
                DbConnection.closeConnection();
            }
        }
        
        
        
    public void batchUpdate(Connection connection , List<Product> products) throws SQLException{
        PreparedStatement  statement = null;
        try{
            statement = connection.prepareStatement(UPDATE_QUERY);
            for(Product product : products){    
                statement.setString(1, product.getName());
                statement.setString(2, product.getType());
                statement.setBigDecimal(3, product.getPrice());
                statement.setInt(4, product.getStock());
                statement.setInt(5, product.getId());
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
