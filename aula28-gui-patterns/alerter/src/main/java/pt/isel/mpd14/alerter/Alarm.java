/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.alerter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Alarm {
    /**
     * crio um observable que cada vez que existir uma alteração a sua lista de 
     * dependentes vai avisar o 
     * 
     */
    ArrayList<IAlarm> alarmList = new ArrayList<IAlarm>();

    public void addEvent(long time) {
        events.add(time);
    }
    
    public void addAlarm(IAlarm alarm){
        alarmList.add(alarm);
    }
    public void removeAlarm(IAlarm alarm){
        alarmList.remove(alarm);
    }
    /**
     * cada vez que o metodo alarmRings for chamado vai executar os alarmes que 
     * existirem no array list.
     * no ArrayList podem existir alarmes de varios tipos..Imagem,som,string, etc
     * @param alarm 
     */
    public void alarmRigs(ArrayList<IAlarm> alarm){
        for(IAlarm a : alarm) {
            a.alarm();
        }
    }
    /*
     * Cada evento é representado por um instante de tempo em Milisegundos
    */
    SortedSet<Long> events = new TreeSet<Long>();
    
    public void start() {

        Iterator<Long> iter = events.iterator();
        Long instant = iter.hasNext() ? iter.next() : null;
        while (instant != null) {
            if (System.currentTimeMillis() >= instant) {
                alarmRigs(alarmList);
                System.out.println("Triiiim");
                iter.remove();
                instant = iter.hasNext() ? iter.next() : null;
            }
        }
    }

}
