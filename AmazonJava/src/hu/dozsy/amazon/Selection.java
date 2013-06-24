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
public class Selection {
    Algo algo;     
    Eval eval;

    public Selection(Algo algo, Eval eval) {
        this.algo = algo;
        this.eval = eval;
    }  
    
    public Points select(Points points) {
        Point[] ps = points.getPs();
        int s = ps[0].x.length;
        boolean[] xSel = points.getxSelected();        
        for (int i = 0; i < s; i++) {
//            Arrays.fill(xSel, true);
            Arrays.fill(xSel, false);
//            xSel[1] = true;
//            xSel[4] = true;
//            xSel[6] = true;
//            xSel[8] = true;
            xSel[0] = true;
            xSel[8] = true;
//            xSel[i] = false;
            System.out.println(Arrays.toString(points.getxSelected()));
            System.out.println(eval.evaluate(algo.test(points,  algo.train(points))));
        }
        return points;
    }
    
}
