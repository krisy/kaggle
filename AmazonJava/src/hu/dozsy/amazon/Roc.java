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
public class Roc implements Eval {
    
    
    @Override
    public float evaluate(Points points) {
        Point[] ps = points.getPs();
        float auc = 0;
        int tp = 0;
        float t = Stat.yTestStat(1, true, ps);
        int fp = 0;
        float f = Stat.yTestStat(0, true, ps);
        System.out.println("t=" + t + " f=" + f);
        Arrays.sort(ps);        
        for (Point p: ps) {
            if (p.isTest == false) { continue; }
            if (1 == p.y) {
                tp++;
            } else {
                fp++;
                auc += tp/(t*f);
            }
        }
        return auc;
    }
}
