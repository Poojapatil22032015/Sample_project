import java.sql.Connection;
import java.sql.DriverManager;

class Test
{
    public static void main(String a[]) {
        CRUD_User user = new CRUD_User();
        CRUD_Books book= new CRUD_Books();
        CRUD_shelf shelf =new CRUD_shelf();
        user.get_User_values();
        //user.delete_value("9844353778");
        //shelf.insert_subjects("English");
        shelf.insert_subjects("Science");
        shelf.get_subjects();
        //book.insert_books("Wuthering Heights" , "Emily Bronte" ,"English");
        book.insert_books("Concepts of Physics" , "H.C.Verma" ,"Science");
        book.get_books();
        book.get_value_of_book("Ramayana");
    }
}