
package utils;

//using constant can minimize typing mistakes
public class Constant {
    private Constant(){}
    
    public  static class Db{
        private Db() {
        }
        public static final String DB_URL = "jdbc:mysql://";
        public static final String PATH = "localhost:3306/";
        public static final String DATABASE_NAME = "ksp_op";
        
        public static final String DB_USERNAME = "root";
        public static final String DB_PASSWORD = "";
        
        
        public static final String FULL_URL = DB_URL + PATH+ DATABASE_NAME ;
    }
    
    public static class Message{
        private Message(){}
        public static final String OPEN_CONNECTION = "open connection";
        public static final String CLOSE_CONNECTION = "close_connection";
    }
    
    public static class ExceptionMessage{}
}
