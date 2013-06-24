/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

/**
 *
 * @author György
 */
public class Stat {
      public static int yStat(int yval, Point[] ps) {
        int i = 0;
        for (Point p: ps) {
            if (p.y == yval) { i++; }
        }
        return i;
    }
      
    public static int yTestStat(int yval, boolean isTest, Point[] ps) {
        int i = 0;
        for (Point p: ps) {
            if (p.y == yval && p.isTest == isTest) { i++; }
        }
        return i;
    }

      
     public static String results(Point[] ps) {
        StringBuilder sb = new StringBuilder();
        for (Point p: ps) {
            sb.append("estY=").append(p.estY).append(" y=").append(p.y).append("\n");
        }
        return sb.toString();
     }
  
}
