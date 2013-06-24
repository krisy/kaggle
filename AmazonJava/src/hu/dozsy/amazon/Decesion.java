/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

import java.util.HashMap;

/**
 *
 * @author György
 */
public class Decesion implements Algo {
  
    public static class DecesionModel implements Model {
        HashMap<Integer, Float>[] rates;

        public DecesionModel(HashMap<Integer, Float>[] rates) {
            this.rates = rates;
        }        
    }
    
    public Model train(Points points) {        
        Point[] ps = points.getPs();
        //int s = points.numXSelected();
        int s = points.getPs()[0].x.length;
        float t = Stat.yStat(1, ps);        
        float f = Stat.yStat(0, ps);
        HashMap<Integer, Float>[] allRates = new HashMap[s];
        //TODO: handle null ps                
        for (int i = 0; i < s; i++) {
            if (!points.getxSelected()[i]) { continue; }
            HashMap<Integer, Integer> oneHist = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> zeroHist = new HashMap<Integer, Integer>();
            HashMap<Integer, Float> rates = new HashMap<Integer, Float>();
            for (Point p : ps) {
                if (p.isTest == false) {
                    Integer z = zeroHist.get(p.x[i]);
                    Integer o = oneHist.get(p.x[i]);
                    int zp = (z == null) ? 0 : z;
                    int op = (o == null) ? 0 : o;
                    if (p.y == 0) { zeroHist.put(p.x[i], zp + 1); } 
                    if (p.y == 1) { oneHist.put(p.x[i], op + 1); }                    
                    z = zeroHist.get(p.x[i]);
                    o = oneHist.get(p.x[i]);
                    zp = (z == null) ? 0 : z;
                    op = (o == null) ? 0 : o;
                    rates.put(p.x[i], (op/t)/((op/t) + (zp/f)));
                }
            }                        
            allRates[i] = rates;
        }
        return new DecesionModel(allRates);
    }
    
    public Points test(Points points, Model m) {
        Point[] ps = points.getPs();
        DecesionModel dm = (DecesionModel)m;
        int s = points.getPs()[0].x.length;
        for (Point p : ps) {
            if (p.isTest == true) {
                float sum = 0;
                for (int i = 0; i < s; i++) {
                    if (!points.getxSelected()[i]) { continue; }
                    Float v = dm.rates[i].get(p.x[i]);
                    float vp = (v == null) ? 0 : v;
                    sum += vp;
                }                
                p.estY = sum /(float)points.numXSelected();
                //p.estY = (int)Math.round(p.estY);
            }
        }
        return points;
    }
            
}
