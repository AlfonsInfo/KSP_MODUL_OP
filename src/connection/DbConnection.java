package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Constant;
import utils.Helper;

public class DbConnection {
    private DbConnection(){}    
    public static Connection connection;
    public static void makeConnection(){
        String methodName = Helper.getCurrentMethodName();
         Helper.log(Constant.Message.OPEN_CONNECTION,methodName);
        try{
            connection = DriverManager.getConnection(Constant.Db.FULL_URL, Constant.Db.DB_USERNAME, Constant.Db.DB_PASSWORD);
            Helper.log("success", methodName);
        }catch(SQLException e){
            Helper.log(e.getMessage(), methodName);
        }
    }

    public static void closeConnection(){
        String methodName = Helper.getCurrentMethodName();
        Helper.log(Constant.Message.CLOSE_CONNECTION, methodName);
        try{
            connection.setAutoCommit(true);
            connection.close();
            Helper.log("success", methodName);
        }catch (SQLException e){
            Helper.log(e.getMessage(),methodName);
        }
    }    
}
