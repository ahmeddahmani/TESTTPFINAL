
package org.emp.gl.time.display;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JFrame;


public class Labyrinthe extends JFrame implements PropertyChangeListener {
    
    
    /** Taille du pion se déplaçant dans le labyrinthe. */
   private static final int TAILLE_PION = 45;

   /** Taille des cases du labyrinthe. */
   private static final int TAILLE_CASE = 50;

   /** Taille du décalage à gauche du labyrinthe. */
   private static final int DEC_GAUCHE = 25;

   /** Taille du décalage en haut du labyrinthe. */
   private static final int DEC_HAUT = 50;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("changementdansGUI")){
            y =((ArrayList<Integer>) evt.getOldValue()).get(0);
            x= ((ArrayList<Integer>) evt.getOldValue()).get(1);
            this.repaint();
            
        }
    }
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
    
    /** Position courante en x dans le labyrinthe. */
   private int x;

   /** Position courante en y dans le labyrinthe. */
   private int y;

   /** Position de départ en x dans le labyrinthe. */
   private final int xd = 0;

   /** Position de départ en y dans le labyrinthe. */
   private final int yd = 2;
   
   
   
    public Labyrinthe()
   {
      super("Labyrinthe graphique");

      // Initialisation du labyrinthe.
      //System.out.println("hii");
      this.x = 2;
      this.y = 2;
      setLocation(100, 100);
      setSize(600, 600);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    
    
     public void paint(Graphics g)
   {
      // Parcourt le labyrinthe.
      for(int i = 0; i < this.labyrinthe.length; i++)
      {
         for(int j = 0; j < this.labyrinthe.length; j++)
         {
            // Case libre.
            if(this.labyrinthe[i][j])
            {
               g.setColor(Color.WHITE);
               g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
               g.setColor(Color.LIGHT_GRAY);
               g.drawRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
            }
            // Mur.
            else
            {
               g.setColor(Color.YELLOW);
               g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
            }
         }
      }
      g.setColor(Color.GREEN);
      g.fillOval(DEC_GAUCHE+1+this.x*TAILLE_CASE,DEC_HAUT+1+this.y*TAILLE_CASE,TAILLE_PION,TAILLE_PION);
   }
}
    
    
    
    
    
