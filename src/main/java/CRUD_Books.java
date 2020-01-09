import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CRUD_Books {
    public void insert_books(String Book_name,String Author_name,String Sub_name)
    {
        Db_connection obj_DB_Connection=new Db_connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String querrry = new String("insert into Books(Book_name, Author_name, Sub_name) values(?,?,?)");
            ps=connection.prepareStatement(querrry);
            ps.setString(1, Book_name);
            ps.setString(2, Author_name);
            ps.setString(3, Sub_name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
/*READ Operation */
public List get_books(){
    Db_connection obj_DB_Connection=new Db_connection();
    Connection connection=obj_DB_Connection.get_connection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    List list=new ArrayList();
    try {
        String querrry=new String("select * from Books");
        ps=connection.prepareStatement(querrry);
        rs=ps.executeQuery();
        while(rs.next()){
            Books obj_Book=new Books();
            System.out.println(rs.getString("Book_name"));
            System.out.println(rs.getString("Author_name"));
            System.out.println(rs.getString("Sub_name"));
            obj_Book.setBook_name(rs.getString("Book_name"));
            obj_Book.setAuthor_name(rs.getString("Author_name"));
            obj_Book.setSub_name(rs.getString("Sub_name"));
            list.add(obj_Book);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return list;
}
/* UPDATE Operation */
public Books get_value_of_book(String Book_name){
    Db_connection obj_DB_Connection=new Db_connection();
    Connection connection=obj_DB_Connection.get_connection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    Books obj_book=new Books();
    try {
        String querry=new String("select * from Books where Book_name=?");
        ps=connection.prepareStatement(querry);
        ps.setString(1, Book_name);
        rs=ps.executeQuery();
        while(rs.next()){
            obj_book.setBook_name(rs.getString("Book_name"));
            obj_book.setAuthor_name(rs.getString("Author_name"));
            obj_book.setSub_name(rs.getString("Sub_name"));
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return obj_book;
}
/*DELETE Operations*/
public void delete_book(String Book_name) {
    Db_connection obj_DB_Connection = new Db_connection();
    Connection connection = obj_DB_Connection.get_connection();
    PreparedStatement ps = null;
    try {
        String querrry = new String("delete from Books where Book_name=?");
        ps = connection.prepareStatement(querrry);
        ps.setString(1, Book_name);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
}
}
