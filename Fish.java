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
public class Fish {
    
    Connection myConn;
    public int caught, sold;
    private double waste, pWaste, wWaste, cWaste, mWaste;
    private int total, pTotal, wTotal, cTotal, mTotal;
    public String species;
    
    public Fish() {
        caught = 0;
        sold = 0;
        species = "";
        getConnection();
    }

    public Fish(int caught, int sold, String species) {
        this.caught = caught;
        this.sold = sold;
        this.species = species;
    }
    
    
    public void setSpecies(String species) {
        this.species = species;
    }

    public void setCaught(int caught) {
        this.caught = caught;
    }

    public void setSold(int sold) {
        this.sold = sold;
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
        waste = ((sold/caught));
        total = caught;
        
        try{
            Statement myStatement = myConn.createStatement();
            myStatement.executeUpdate("INSERT INTO data_table(Species, Pwaste, totals)" + " VALUES('"+ species + "','" + waste + "','" + total + "')");
            
        }
        catch (SQLException e) {
            System.out.println("Error: " +e);
        }
    }
}
