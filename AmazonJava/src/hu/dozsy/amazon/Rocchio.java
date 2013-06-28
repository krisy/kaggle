/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 *
 * @author György
 */
public class Rocchio implements Algo {
  
    public static class RocchioModel implements Model {
        int[] one;
        int[] zero;

        public RocchioModel(int[] zero, int[] one) {
            this.zero = zero;
            this.one = one;
        }        
        
        @Override
        public String toString() {
            return "zero=" + Arrays.toString(zero) + "\n" + "one=" + Arrays.toString(one);
        }
    }
    
    public Model train(Points points) {        
        Point[] ps = points.getPs();
        int s = ps[0].x.length;
        int[] zero = new int[s];
        int[] one = new int[s];
        //TODO: handle null ps        
        for (int i = 0; i < s; i++) {
            HashMap<Integer, Integer> oneHist = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> zeroHist = new HashMap<Integer, Integer>();
            for (Point p : ps) {
                if (p.isTest == false) {
                    if (p.y == 0 && zeroHist.get(p.x[i]) == null) { zeroHist.put(p.x[i], 1); }
                    if (p.y == 1 && oneHist.get(p.x[i]) == null) { oneHist.put(p.x[i], 1); }
                    if (p.y == 0) { zeroHist.put(p.x[i], zeroHist.get(p.x[i]) + 1); } 
                    if (p.y == 1) { oneHist.put(p.x[i], oneHist.get(p.x[i]) + 1); }                    
                }
            }                        
            zero[i] = getMax(zeroHist);
            one[i] = getMax(oneHist);
            System.out.println("i=" + i);
            System.out.println("zeroHist=" + zeroHist);
            System.out.println("oneHist=" + oneHist);
            if (i == 2) {System.out.println(oneHist.get(117961));}
        }
        return new RocchioModel(zero, one);
    }
    
    public Points test(Points points, Model m) {
        Point[] ps = points.getPs();
        RocchioModel rm = (RocchioModel)m;
        System.out.println(rm.toString());
        for (Point p : ps) {
            if (p.isTest == true) {
                int simone = sim(p.x, rm.one);
                int simzero = sim(p.x, rm.zero);
                p.estY = simone / (float)(simone + simzero);
//                p.estY = 1;
//                if (p.x[2] == 117961) { p.estY = 0; }
                //if (p.estY == 0.5) { p.estY = 1; }
                //System.out.println("estY=" + p.estY + " y=" + p.y + " simone=" + simone + " simzero=" + simzero);
            }
        }
        return points;
    }
            
    public int sim(int[] a, int[] b) {
        int n = 0;
        //TODO: must be in the same length
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) { n++; }
        }
        return n;
    }
    
    private int getMax(HashMap<Integer, Integer> hist) {
        int maxValue = 0;
        int maxPos = 0;        
        for (Entry<Integer, Integer> e : hist.entrySet()) {
            if (e.getValue() > maxValue) {
                maxValue = e.getValue();
                maxPos = e.getKey();
            }
        }
        return maxPos;
    }
}
