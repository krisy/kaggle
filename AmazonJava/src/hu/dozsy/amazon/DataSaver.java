/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author György
 */
public class DataSaver {
    String fileName;
    
    public DataSaver(String fileName) {
        this.fileName = fileName;
    }
    
    public void save(Points ps) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
        String s = Point.toTestString(ps.getPs());
        w.write(s);
        w.flush();
    }
}
