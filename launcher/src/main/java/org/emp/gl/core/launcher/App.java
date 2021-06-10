package org.emp.gl.core.launcher;

import org.emp.gl.gamespace.gameSpace;
import org.emp.gl.mywatch.withstate.Robot;

import org.emp.gl.time.control.GuiControl;
import org.emp.gl.time.display.Labyrinthe;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

/**
 * Hello world!
 *
 */
public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
   
    

    public static void main(String[] args) {
        
         Robot r=new Robot();
         TimerServiceImplWithDelegation t=new TimerServiceImplWithDelegation();
         t.addTimeChangeListener(r);
         gameSpace g=new gameSpace();
         r.addTimeChangeListener(g);
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Labyrinthe h= new Labyrinthe();
               g.addListener(h);
               new GuiControl().setVisible(true);
            }
        });
         
}
}
