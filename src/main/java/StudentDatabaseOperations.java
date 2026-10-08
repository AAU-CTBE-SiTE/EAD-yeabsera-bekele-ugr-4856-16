import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDatabaseOperations {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentsDB";
        String username = "root";
        String password = "yeab1997SERA@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Connected successfully!");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}