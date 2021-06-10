/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ahmed
 */
public class TimerServiceImplWithDelegation extends TimerTask {
int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;
    private PropertyChangeSupport PCS=null ;
    private PropertyChangeEvent pce=null ;

    /**
     * Constructeur du DummyTimeServiceImpl Ici, nnous avons hérité de la classe
     * TimerTask, et nous nous avons utilisé un objet Timer, qui permet de
     * réaliser des tocs à chaque N millisecondes
     */
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();
        this.PCS =new PropertyChangeSupport(this);
        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    

    
    public void addTimeChangeListener(PropertyChangeListener pl) {
        PCS.addPropertyChangeListener(pl);
    }

  
    public void removeTimeChangeListener(PropertyChangeListener pl) {
        PCS.removePropertyChangeListener(pl);
    }


    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;

        // informer les listeners ! 
        
           

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    protected void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;
       pce=new PropertyChangeEvent(this,"seconde",
                    oldValue, secondes);
       PCS.firePropertyChange(pce);
            
        

        if (secondes == 0) {
            updateMinutes();
        }
    }

    protected void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;
        
                
      

        if (minutes == 0) {
            updateHeures();
        }
    }

    protected void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;
        
        
            
        
    }

}
   
    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */








