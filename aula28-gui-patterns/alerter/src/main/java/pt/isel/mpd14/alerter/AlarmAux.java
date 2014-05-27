/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.alerter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koracione
 */
public class AlarmAux extends Alarm{
    /**
     * crio um observable que cada vez que existir uma alteração a sua lista de 
     * dependentes vai avisar o 
     * 
     */
    static ArrayList<IAlarm> alarmList = new ArrayList<IAlarm>();

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
     
    public void alarmRigs(ArrayList<IAlarm> alarm){
        for(IAlarm a : alarm) {
            a.alarm();
        }
    }*/
<<<<<<< HEAD
    
=======
>>>>>>> 3bd156c5048ec5bf0cc0d8c27704138d5d771a04
    public static void alarmRigs(){
        for(IAlarm a : (List<IAlarm>)alarmList.clone()) {
            a.alarm();
        }
    }
    
}
