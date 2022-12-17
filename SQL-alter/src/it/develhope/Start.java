package it.develhope;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start{


    public static void main(String[] args){

        Connection connection = null;

        try{
            // db parameters
            String url      = "jdbc:mysql://localhost:3306/newdb";
            String user     = "root";
            String password = "password";

            // create a connection to the database
            connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();

            String query  = "ALTER TABLE students ADD country VARCHAR(30);";
            String query1 = "UPDATE `students` SET `country`='Italy' WHERE  `id`=1;";
            String query2 = "UPDATE `students` SET `country`='Italy' WHERE  `id`=2;";
            String query3 = "UPDATE `students` SET `country`='Germany' WHERE  `id`=3;";
            String query4 = "UPDATE `students` SET `country`='Germany' WHERE  `id`=4;";

            //statement.executeUpdate(query);
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            statement.executeUpdate(query4);

            System.out.println("queries executed");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

}