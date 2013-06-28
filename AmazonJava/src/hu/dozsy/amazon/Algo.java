/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dozsy.amazon;

/**
 *
 * @author György
 */
public interface Algo {
    public Model train(Points ps);
    
    public Points test(Points ps, Model rm);
    
}
