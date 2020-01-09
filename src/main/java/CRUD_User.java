import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CRUD_User {
/* CREATE Operation*/
        public void insert_values(String name,String email,String phone_number,String password)
        {
            Db_connection obj_DB_Connection=new Db_connection();
            Connection connection=obj_DB_Connection.get_connection();
            PreparedStatement ps=null;
            try {
                String query = new String("insert into User(name, email, phone_number, password) values(?,?,?,?)");
                ps=connection.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone_number);
                ps.setString(4, password);
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
/*READ Operation*/

    public List get_User_values(){
        Db_connection obj_DB_Connection=new Db_connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List list=new ArrayList();
        try {
            String querry =  new String("select * from User");
            ps=connection.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()){
                User obj_User = new User();
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("phone_number"));
                System.out.println(rs.getString("password"));
                obj_User.setName(rs.getString("name"));
                obj_User.setEmail(rs.getString("email"));
                obj_User.setPhone_number(rs.getString("phone_number"));
                obj_User.setPassword(rs.getString("password"));
                list.add(obj_User);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
/* EDIT Operation */
    public User get_value_of_user(String phone_number){
        Db_connection obj_DB_Connection=new Db_connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        User obj_User_Bean=new User();
        try {
            String querry=new String("select * from User where phone_number=?");
            ps=connection.prepareStatement(querry);
            ps.setString(1, phone_number);;
            rs=ps.executeQuery();
            while(rs.next()){
                obj_User_Bean.setPhone_number(rs.getString("phone_number"));
                obj_User_Bean.setEmail(rs.getString("email"));
                obj_User_Bean.setName(rs.getString("name"));
                obj_User_Bean.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj_User_Bean;
    }
    public void edit_user(User obj_User, String old_phone_number){
        Db_connection obj_DB_Connection=new Db_connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String querry=new String("update User set name=?,email=?,phone_number=?, password=? where phone_number=?");
            ps=connection.prepareStatement(querry);
            ps.setString(1, obj_User.getName());
            ps.setString(2, obj_User.getEmail());
            ps.setString(3, obj_User.getPhone_number());
            ps.setString(4, obj_User.getPassword());
            ps.setString(5,old_phone_number);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
/*DELETE Operation */
public void delete_value(String phone_number){
    Db_connection obj_DB_Connection=new Db_connection();
    Connection connection=obj_DB_Connection.get_connection();
    PreparedStatement ps=null;
    try {
        String querry= new String("delete from User where phone_number=?");
        ps=connection.prepareStatement(querry);
        ps.setString(1, phone_number);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
}

}


