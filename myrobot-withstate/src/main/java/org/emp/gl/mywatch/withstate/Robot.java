/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch.withstate;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.robotservice.RobotServiceInterface;

/**
 *
 * @author ahmed
 */
public class Robot implements PropertyChangeListener,RobotServiceInterface{
    int posx=2;
    int posy=0;
    String orientation="reight";
   private PropertyChangeSupport PCS=null ;
   
   private boolean[][] labyrinthe = {
         {false, false, false, false, false, false, false, false, false, false },
         {false, false, true, false, true, false, false, false, true, false },
         {true, true, true, false, true, true, true, true, true, true },
         {false, false, true, false, true, false, true, false, false, false },
         {false, false, true, false, false, false, true, true, true, false },
         {false, true, true, true, true, true, true, false, true, false },
         {false, false, true, true, true, false, false, true, true, false},
         {false, false, true, false, true, false, true, true, true, false},
         {false, false, false, false, true, true, true, false, false, false},
         {false, false, false, true, false, false, true, false, false, false},
         };
    

    public Robot() {
        
        Lookup.getInstance().register(RobotServiceInterface.class,this);
        this.ws = new ReightSettingState(this);
        this.PCS =new PropertyChangeSupport(this);
    }
     private RobotState ws ;
    public void setState(RobotState nws)
    {
    ws=nws;
    }
    public void tourneLeft()
    {
        ws.goLeft();
    }
    
    public void tourneReight()
    {
        ws.goReight();
    }

    /*@Override
    public void goLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goReight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if(evt.getPropertyName().equals("seconde")){
        if(orientation=="up"&&posx>0&&this.labyrinthe[posx-1][posy])
            posx--;
        if(orientation=="down"&&posx<9&&this.labyrinthe[posx+1][posy])
            posx++;
        if(orientation=="reight"&&posy<9&&this.labyrinthe[posx][posy+1])
            posy++;
        if(orientation=="left"&&posy>0&&this.labyrinthe[posx][posy-1])
            posy--; 
        ArrayList<Integer> values =new ArrayList<>();
        values.add(posx);values.add(posy);
       PCS.firePropertyChange("changement",values,null);
       System.out.println(posx+" "+posy +"----->"+this.labyrinthe[posy][posx]);
        }
    }
    
    public void addTimeChangeListener(PropertyChangeListener pl) {
        PCS.addPropertyChangeListener(pl);
    }

    
    public void removeTimeChangeListener(PropertyChangeListener pl) {
        PCS.removePropertyChangeListener(pl);
    }

    @Override
    public void tourneUp() {
        ws.goUp();
    }

    @Override
    public void tourneDown() {
       ws.goDown();
    }
}
