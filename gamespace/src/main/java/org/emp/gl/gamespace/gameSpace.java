/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.gamespace;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 *
 * @author ahmed
 */
public class gameSpace implements PropertyChangeListener{
    int x=0;
    int y=2;
    
    private PropertyChangeSupport pcs =null;
    
    public gameSpace (){
        pcs=new PropertyChangeSupport(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("changement")){
            x =((ArrayList<Integer>) evt.getOldValue()).get(0);
            y= ((ArrayList<Integer>) evt.getOldValue()).get(1);
            pcs.firePropertyChange("changementdansGUI",evt.getOldValue(),null);
            
        }
    
    }
    public void addListener(PropertyChangeListener pl) {
        pcs.addPropertyChangeListener(pl);
    }

    
    public void removeListener(PropertyChangeListener pl) {
        pcs.removePropertyChangeListener(pl);
    }
}
