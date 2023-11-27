/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xpath.belowwaterapp;

import java.io.Serializable;

/**
 *
 * @author niamh
 */
public class CoOrdinates implements Serializable{
    private int over, down;
    private String fact;
    private String type;

    public CoOrdinates() {
        over = 0;
        down = 0;
        fact = "";
    }

    public CoOrdinates(int over, int down, String type) {
        this.over = over;
        this.down = down;
        this.type = type;
    }
    
    

    public void setOver(int over) {
        this.over = over;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public String getFact() {
        return fact;
    }
    
    public void compute(){
        
    }
    
}
