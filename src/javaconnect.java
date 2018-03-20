import java.sql.*;
import javax.swing.*;


public class javaconnect{
Connection conn=null;
public static Connection connDB(){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ajsoft","root","");
//JOptionPane.showMessageDialog(null,"connection established");
return conn;
}
catch(Exception e){
JOptionPane.showMessageDialog(null,e);
return null;



}


}
}
