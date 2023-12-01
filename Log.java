package belowwaterappp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Log 
 * @author niamh
 */
public class Log extends Fish{
    
    Connection myConn;
    private String date;

    public Log(){
        date = "";
        getConnection();
    }

    public Log(String date, int caught, int sold, String species) {
        super(caught, sold, species);
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    private void getConnection(){
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fishdb", "root", "Endless13");
        } catch (SQLException ex) {
            System.out.println("Error Connecting:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void compute(){
        try{
            Statement myStatement = myConn.createStatement();
            myStatement.executeUpdate("INSERT INTO log_table(date, species, caught, sold)" + " VALUES('"+ date + "','" + species + "','" + caught + "','" + sold + "')");
            
        }
        catch (SQLException e) {
            System.out.println("Error: " +e);
        }
    }
    
}

