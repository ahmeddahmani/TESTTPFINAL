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
public class UpState extends RobotState{

    public UpState(Robot w) {
        super(w);
    }
   
    
    @Override
    public void goLeft() {
         robot.setState(new LeftSettingState(robot));
         robot.orientation="left";
    }

    @Override
    public void goReight() {
        robot.setState(new ReightSettingState(robot));
        robot.orientation="reight";
    }
    /*
    @Override
    public void doIncrement() {
           }

   */

    @Override
    public void goUp() {
        
    }

    @Override
    public void goDown() {
       
    }
    
}
