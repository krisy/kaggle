/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

import java.util.Arrays;

/**
 *
 * @author György
 */
public class Points {
    boolean[] xSelected;
    Point[] ps;

    public Points(Point[] ps) {
        this.ps = ps;
        //TODO: handle of ps empty or no x
        xSelected = new boolean[ps[0].x.length];
        Arrays.fill(xSelected, true);
    }
    
    public Points(Point[] ps, boolean[] xSelected) {
        this.ps = ps;
        this.xSelected = xSelected;
     
    }       

    public Point[] getPs() {
        return ps;
    }

    public boolean[] getxSelected() {
        return xSelected;
    }
    
    
    public int numXSelected() {
        int sel = 0;
        for (boolean xSel : xSelected) {
            if (xSel == true) { sel++; }
        }
        return sel;
    }
        
}
