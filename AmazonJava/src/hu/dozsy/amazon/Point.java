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
public class Point implements Comparable<Point> {
    int id;
    int y;
    float estY = (float) Math.random();
    boolean isTest;
    int[] x;
            
    public float getEstY () {
        return estY;
    }

    @Override
    public int compareTo(Point o) {
        if (o.estY < this.estY) {
            return -1;
        }
        else if (o.estY == this.estY) {
            return 0;
        }
        return 1;
    }
    
    @Override
    public String toString() {
        return "isTest=" + isTest + " estY=" + estY + " y=" + y + " x=" + Arrays.toString(x);
    }

    public String toTestString() {
        StringBuilder b = new StringBuilder();
        return b.append(id).append(",").append(estY).toString();
    }

    public static String toTestString(Point[] ps) {
        StringBuilder b = new StringBuilder();
        b.append("id,ACTION\n");
        for (Point p : ps) {
            b.append(p.toTestString()).append("\n");
        }
        return b.toString();
    }
}
