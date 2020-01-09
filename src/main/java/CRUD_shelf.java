import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CRUD_shelf {
    public void insert_subjects(String Subject)
    {
        Db_connection obj_DB_Connection=new Db_connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String query = new String("insert into Shelf(Subject) values(?)");
            ps=connection.prepareStatement(query);
            ps.setString(1, Subject);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /*READ OPERATION*/
    public List get_subjects(){
        Db_connection obj_DB_Connection=new Db_connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List list=new ArrayList();
        try {
            String query=new String("select * from Shelf");
            ps=connection.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Shelf obj_shelf=new Shelf();
                System.out.println(rs.getString("Subject"));
                obj_shelf.setSubjects(rs.getString("Subject"));
                list.add(obj_shelf);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
/*UPDATE OPERATION */
public Shelf get_value_of_subject(String Subject){
    Db_connection obj_DB_Connection=new Db_connection();
    Connection connection=obj_DB_Connection.get_connection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    Shelf obj_subject=new Shelf();
    try {
        String query=new String("select * from Shelf where Subject=?");
        ps=connection.prepareStatement(query);
        ps.setString(1, Subject);
        rs=ps.executeQuery();
        while(rs.next()){
            obj_subject.setSubjects(rs.getString("Subject"));
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return obj_subject;
}
/*DELETE OPERATION*/
public void delete_subject(String Subject) {
    Db_connection obj_DB_Connection = new Db_connection();
    Connection connection = obj_DB_Connection.get_connection();
    PreparedStatement ps = null;
    try {
        String query = new String("delete from Shelf where Subject=?");
        ps = connection.prepareStatement(query);
        ps.setString(1, Subject);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
}
}
