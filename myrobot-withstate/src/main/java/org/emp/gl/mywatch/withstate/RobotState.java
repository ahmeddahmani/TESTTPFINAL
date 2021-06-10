/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch.withstate;
/**
 *
 * @author ahmed
 */
abstract public class RobotState {
    protected  Robot robot ;
    private RobotState(){}
    public RobotState(Robot w)
    {
        if (w==null) {
        throw new NullPointerException();
           //on peut pas instancier un objet watch state sans cree un objet mywatch
          
        }
        robot=w;
    }
    
    
    public abstract void goLeft() ;
        
    

    
    public abstract void goReight() ;
     public abstract void goUp() ;
        
    

    
    public abstract void goDown() ;

    
    
}
