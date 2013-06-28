/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author György
 */
public class DataLoader {
    String fileName;
    boolean isTest;
    
    public DataLoader(String fileName, boolean isTest) {
        this.fileName = fileName;
        this.isTest = isTest;
    }
    
    public Points handle() throws FileNotFoundException, IOException {
        ArrayList<Point> points = new ArrayList<Point>();
        BufferedReader buf = new BufferedReader(new FileReader(fileName));
        //skip header
        buf.readLine();
        String line;
        while ((line = buf.readLine()) != null) {
            String[] dataLine = line.split(",");
            Point p = new Point();
            if (isTest) {
                p.id = new Integer(dataLine[0]);
            } else {
                p.y = new Integer(dataLine[0]);
            }            
            p.x = new int[dataLine.length - 1];
            for (int i = 1; i < dataLine.length; i++) {
                p.x[i - 1] = new Integer(dataLine[i]);
            }
            points.add(p);
        }
        return new Points(points.toArray(new Point[0]));
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataLoader dl = new DataLoader("d:/Egyéb/kaggle/amazon/data/train.csv", false);
        DataLoader dlte = new DataLoader("d:/Egyéb/kaggle/amazon/data/test.csv", true);
        DataSaver ds = new DataSaver("d:/Egyéb/kaggle/amazon/data/1stsub.csv");
        Splitter s = new Splitter(0.66f);
        Splitter ste = new Splitter(1f);
        //Rocchio rh = new Rocchio();
        Decesion rh = new Decesion();
        Roc r = new Roc();
        Selection sel = new Selection(rh, r);
        Points ps = s.handle(dl.handle());
        sel.select(ps);
        Points pste = ste.handle(dlte.handle());
        int i = 0;
        Model rhm = rh.train(ps);
        System.out.println(r.evaluate(rh.test(ps,  rhm)));        
//        pste = rh.test(pste,  rhm);
//        ds.save(pste);
        //System.out.println(Stat.results(ps));
//        System.out.println(i);       
        //System.out.println(r.evaluate(ps));
        //System.out.println(Arrays.toString(p));               
    }
}
