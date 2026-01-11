import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/students";

        String username = "root";
        String password = "Shubham@16$2000";
        String query = "";
        // Establish the connection
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to the database.");
            Statement statement = connection.createStatement(); // create instance to execute the sql queries

            /* How to delete data */
                query = "DELETE FROM EMPLOYEES;";
                int rowsAffected = statement.executeUpdate(query); // to delete the data use executeUpdate
                if(rowsAffected > 0){
                    System.out.println("Deletion sucessfull!!!  " + rowsAffected + " rows affected.");
                } else {
                    System.out.println("Deletion failed!!!");
                }

            /* How to insert data */
                query = "INSERT INTO employees(id, name, job_title, salary) VALUES (3, 'Shubham', 'Full Stack Developer', 13.36);";
                rowsAffected = statement.executeUpdate(query); // to insert the data use executeUpdate
                if(rowsAffected > 0){
                    System.out.println("Insert sucessfull!!!  " + rowsAffected + " rows affected.");
                } else {
                    System.out.println("Insertion failed!!!");
                }

            /* How to update the record */
                query = "UPDATE employees SET job_title = 'Full stack java + angular developer', salary = 100.00 WHERE ID = 3;";
                rowsAffected = statement.executeUpdate(query); // to insert the data use executeUpdate
                if(rowsAffected > 0){
                    System.out.println("Update sucessfull!!!  " + rowsAffected + " rows affected.");
                } else {
                    System.out.println("Update failed!!!");
                }
            /* How to read data from the database*/
                query = "SELECT * FROM EMPLOYEES;";
                ResultSet resultSetReadData = statement.executeQuery(query);
                while(resultSetReadData.next()){
                    int id = resultSetReadData.getInt("id");
                    String name = resultSetReadData.getString("name");
                    String job_title = resultSetReadData.getString("job_title");
                    double salary = resultSetReadData.getDouble("salary");
                    System.out.println("=================================================================");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("job_title: " + job_title);
                    System.out.println("salary: " + salary);
                }
                resultSetReadData.close();
                statement.close();
                connection.close();
                System.out.println("Connection closed successfully!!!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}