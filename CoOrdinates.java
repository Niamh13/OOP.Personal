/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package belowwaterappp;

import java.util.Random;

/**
 * CoOrdinates
 * @author niamh
 */
public class CoOrdinates {
    
    private int over, down;
    private int cSold, cCaught, pSold, pCaught, wSold, wCaught, mSold, mCaught;
    private String fact;

    public CoOrdinates() {
        over = 0;
        down = 0;
        cSold = 0;
        cCaught = 0;
        wSold = 0;
        wCaught = 0;
        pSold = 0;
        pCaught = 0;
        mSold = 0;
        mCaught = 0;
        fact = "";
    }
    

    public void setOver(int over) {
        this.over = over;
    }

    public void setDown(int down) {
        this.down = down;
    }
    
    public void setCSold(int cSold){
        this.cSold = cSold;
    }
    
    public void setCCaught(int cCaught){
        this.cCaught = cCaught;
    }
    
    public void setWSold(int wSold){
        this.wSold = wSold;
    }
    
    public void setWCaught(int wCaught){
        this.wCaught = wCaught;
    }
    
    public void setPSold(int pSold){
        this.pSold = pSold;
    }
    
    public void setPCaught(int pCaught){
        this.pCaught = pCaught;
    }
    
    public void setMSold(int mSold){
        this.mSold = mSold;
    }
    
    public void setMCaught(int mCaught){
        this.mCaught = mCaught;
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
            
            if(over>0 && over<=5){
                if(down>0 && down<=6){
                    switch (i) {
                        case 1 -> {
                           fact = "You caught a MACKEREL!\nMackerel can live up to 20 years old and are a school fish, who tends to stay above 180 feet.\n" + mCaught + " mackerel have been logged as wasted, with \n" + mSold +" mackerel sold.";
                        }
                        case 2 -> {
                            
                            fact = "You caught a CODLING!\nThere a three different species of Codling and humans are their only natural predators.\n" + cCaught + " codling have been logged as wasted, with \n" + cSold +" codling sold.";
                        }
                        case 3 -> {
                            fact = "You caught a WHITING!\nHistorically, Whiting has been a cheap source of food for the poor, pet food, and even as a filler in flour. 'Whiting'can refer to certain other species of ray-finned fish.\n" + wCaught + " whiting have been logged as wasted, with \n" + wSold +" whiting sold.";
                        }
                        case 4 -> {
                            
                            fact = "You caught a POLLOCK!\nPollock can grow to 105cm with living for up to 22 years. Pollock is found in a array of everyday products like fish sticks and McDonald's fillet-O-fish sandwiches.\n" + pCaught + " pollock have been logged as wasted, with \n" + pSold +" pollock sold.";
                        }
                        case 5 -> {
                            fact = "CAREFUL, you almost got a shark. Lucky for you, they were on the hunt for some mackerel.";
                        }
                        case 6 -> {
                            fact = "You caught a... Oops, a Seagull stole your fish, guess they were hungry.";
                        }
                        case 7 -> {
                            fact = "CAREFUl, you got a Octupus.\nYou better throw it.";
                        }
                        case 8 -> {
                            fact = "Hard Luck, none of the fish were interested in your bait.";
                        }
                        default -> {
                            fact = "Hard Luck, none of the fish were interested in your bait.";
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
        catch (Exception e){
            System.out.println("Error: " +e);
        }
    }
    
}
