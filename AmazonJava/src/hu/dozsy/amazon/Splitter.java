/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

import java.util.Random;

/**
 *
 * @author György
 */
public class Splitter {
    float testPercentage = 0.33f;

    public Splitter(float testPercentage) {
        this.testPercentage = testPercentage;
    }       
            
    public Points handle(Points points) {
        Point[] ps = points.getPs();
        Random r = new Random();
        for (Point p : ps) {
           if (r.nextFloat() < testPercentage) {
               p.isTest = true;
           } else {
               p.isTest = false;
           }
        }
        return points;
    }
     
}
