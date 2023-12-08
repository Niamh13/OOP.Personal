package belowwaterappp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author niamh
 */
public class CoOrdinates {
    
    Connection myConn;
    private int over, down, sold, caught;
    private String fact;

    public CoOrdinates() {
        over = 0;
        down = 0;
        fact = "";
        getConnection();
    }
    

    public void setOver(int over) {
        this.over = over;
    }

    public void setDown(int down) {
        this.down = down;
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

    public String getFact() {
        return fact;
    }
    
    public void compute(){
        try {
            int min = 1;
            int max = 8;
            Random rand = new Random();
            int i = rand.nextInt(max - min + 1) + min;
            JOptionPane.showMessageDialog(null, i);
            
            Statement myStatement = myConn.createStatement();
            if(over>0 && over<=5){
                if(down>0 && down<=6){
                    switch (i) {
                        case 1 -> {
                            ResultSet myRs = myStatement.executeQuery("SELECT SUM(caught) AS caught, SUM(sold) AS sold FROM log_table WHERE species = 'Makerel' GROUP BY species");
                            sold = myRs.getInt("sold");
                            caught = myRs.getInt("caught");
                            fact = "You caught a MACKEREL! \n Mackerel can live up to 20 years old and are a school fish, who tends to stay above 180 feet. \n" + caught + " mackerel have been logged as caught. \n" + sold +" mackerel was sold from this";
                        }
                        case 2 -> {
                            ResultSet myRs = myStatement.executeQuery("SELECT SUM(caught) AS caught, SUM(sold) AS sold FROM log_table WHERE species = 'Codling' GROUP BY species");
                            sold = myRs.getInt("sold");
                            caught = myRs.getInt("caught");
                            fact = "You caught a CODLING! \n There a three different species of Codling and humans are their only natural predators. \n" + caught + " codling have been logged as caught. \n" + sold +" codling was sold from this";
                        }
                        case 3 -> {
                            ResultSet myRs = myStatement.executeQuery("SELECT SUM(caught) AS caught, SUM(sold) AS sold FROM log_table WHERE species = 'Whiting' GROUP BY species");
                            sold = myRs.getInt("sold");
                            caught = myRs.getInt("caught");
                            fact = "You caught a WHITING! \n Historically, Whiting has been a cheap source of food for the poor, pet food, and even as a filler in flour. 'Whiting'can refer to certain other species of ray-finned fish \n" + caught + " whiting have been logged as caught. \n" + sold +" whiting was sold from this";
                        }
                        case 4 -> {
                            ResultSet myRs = myStatement.executeQuery("SELECT SUM(caught) AS caught, SUM(sold) AS sold FROM log_table WHERE species = 'Pollock' GROUP BY species");
                            sold = myRs.getInt("sold");
                            caught = myRs.getInt("caught");
                            fact = "You caught a POLLoCK! \n Pollack can grow to 105cm with living fo rup to 22 years. Pollock is found in a array of everyday products like fish sticks and McDonald's fillet-O-fish sandwiches. \n" + caught + " pollock have been logged as caught. \n" + sold +" pollock was sold from this";
                        }
                        case 5 -> {
                            fact = "CAREFUL, you almost got a shark. Lucky for you, they were on the hunt for some mackerel";
                        }
                        case 6 -> {
                            fact = "You caught a... Oops, a Seagull stole your fish, guess they were hungry";
                        }
                        case 7 -> {
                            fact = "CAREFUl, you got a Octupus. \n You better throw it.";
                        }
                        case 8 -> {
                            fact = "Hard Luck, none of the fish were interested in your bait";
                        }
                        default -> {
                            fact = "Hard Luck, none of the fish were interested in your bait";
                        }
                    }
                }
                else{
                    fact = "Entered an unusable down CoOrdinate";
                }
            }
            else {
                fact = "Entered an unusable over CoOrdinate";
            }
            
            
            
        }
        catch (SQLException e){
            System.out.println("Error: " +e);
        }
    }
    
}
