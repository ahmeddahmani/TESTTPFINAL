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
public class LeftSettingState extends RobotState{
    public LeftSettingState(Robot w) {
        super(w);
    }

    @Override
    public void goLeft() {
         //robot.setState(new DownSettingState(robot));
         //robot.orientation="down";
    }

    @Override
    public void goReight() {
       // robot.setState(new UpState(robot));
       // robot.orientation="up";
    }
/*-
    @Override
    public void doIncrement() {
        watch.updateHours();
    }
    */

    @Override
    public void goUp() {
        robot.setState(new UpState(robot));
        robot.orientation="up";
    }

    @Override
    public void goDown() {
       robot.setState(new DownSettingState(robot));
         robot.orientation="down";
    }
}
