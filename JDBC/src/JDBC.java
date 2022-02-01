import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC{
public static void main(String[] args)throws SQLException{
String url="jdbc:mysql://localhost:3306/Football";
String user="root";
String password="mypassword1234@";
String query="select * from Players";

try{
Class.forName("com.mysql.cj.jdbc.Driver");
} catch(ClassNotFoundException e){
e.printStackTrace();
}
try{
Connection con=DriverManager.getConnection(url,user,password);
Statement statement=con.createStatement();
ResultSet result=statement.executeQuery(query);

while (result.next()){
String ClubsData="";
for (int i=1;i<=4;i++){
ClubsData += result.getString(i)+":";
}
System.out.println(ClubsData);
}



}
catch(SQLException e) {
	e.printStackTrace();
}
}
}
