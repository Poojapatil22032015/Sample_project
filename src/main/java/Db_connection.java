import java.sql.Connection;
import java.sql.DriverManager;

public class Db_connection {
    public Connection get_connection(){
        //Creating the connection
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/SampleDB1";
        String dbUsername = "root";
        String dbPassword = "Pooja123!";
        Connection con=null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL,dbUsername, dbPassword);

            System.out.println("Connected!!:"+con);
        }catch(Exception e){
            e.printStackTrace();

        }
        return con;
    }
}
