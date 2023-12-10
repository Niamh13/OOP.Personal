/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package belowwaterappp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *  Fish
 *  @author niamh
 *  26/10/23
 */
public class Fish extends Log{
    
    Connection myConn;
    private int waste;
    private int total;
    
    public Fish() {
        caught = 0;
        sold = 0;
        species = "";
        getConnection();
    }

    public Fish(String date, int caught, int sold, String species) {
        super(date, caught, sold, species);
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

    public void compute() {
        total = caught;
        waste = (caught-sold);
        
        try{
            Statement myStatement = myConn.createStatement();
            myStatement.executeUpdate("INSERT INTO data_table(Species, Pwaste, totals)" + " VALUES('"+ species + "','" + waste + "','" + total + "')");
            
        }
        catch (SQLException e) {
            System.out.println("Error: " +e);
        }
    }
}
