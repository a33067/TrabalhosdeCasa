/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.alerter;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 3bd156c5048ec5bf0cc0d8c27704138d5d771a04
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Alarm {
    /*
     * Cada evento é representado por um instante de tempo em Milisegundos
    */
    SortedSet<Long> events = new TreeSet<Long>();
    
    public void start() {

        Iterator<Long> iter = events.iterator();
        Long instant = iter.hasNext() ? iter.next() : null;
        while (instant != null) {
            if (System.currentTimeMillis() >= instant) {
                AlarmAux.alarmRigs();
                System.out.println("Triiiim");
                iter.remove();
                instant = iter.hasNext() ? iter.next() : null;
            }
        }
    }

}
