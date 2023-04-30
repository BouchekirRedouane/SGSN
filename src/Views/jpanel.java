/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Models.Element;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import Models.GSN;
import Models.Goal;
import Models.Solution;
import Models.Strategy;
import java.util.ArrayList;








/**
 *
 * @author Mou nir
 */
public class jpanel extends javax.swing.JPanel {
    private int mouseX;
    private int mouseY;
    private boolean toggle ;
    private int offsetX;
    private int offsetY;
    private GsnPannel pannel;
    GSN gsn;
    private ArrayList<Element> Elementss ;
    private  Element selectedObject;

    public jpanel(GSN gsn,GsnPannel pannel) {
        this.gsn = gsn;
        this.pannel=pannel;
    }
    
     
    

  
    
      private String buttonTextG = "G1\n\n Goal description goes here";
       private String buttonTextS = "S1\n\n Strategy description goes here";
      
      
    @Override
      public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        if (toggle==true) {
            switch (pannel.action) {
                case "Goal":
                     System.out.print("\n Switch case worcked ");
                    Goal goal = new Goal();
                    goal.draw(g,mouseX,mouseY,buttonTextG);
                    break;
                case "Strategy":
//                     System.out.print("\n Switch case worcked for strategy hhhhhhhhhhhhhhhhhhhhhh");
                    Strategy strategy = new Strategy();
                    strategy.draw(g,mouseX,mouseY,buttonTextS);
                    break;
                case "Solution":
//                     System.out.print("\n Switch case worcked for strategy hhhhhhhhhhhhhhhhhhhhhh");
                    Solution solution = new Solution();
                    solution.draw(g,mouseX,mouseY,buttonTextS);
                    break;
            }            
          }
        Elementss = gsn.getElements();
        for (int i = 0; i < Elementss.size(); i++) {
             Element element = Elementss.get(i);
             element.draw(g);
             
        }
      }

   
        

    
    
        void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseMoved
        mouseX = evt.getX();
        mouseY = evt.getY();
        repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseMoved
        
    public void setClicked(boolean clicked) {
    }

    public void setMouseXf(int mouseXf) {
    }

    public void setMouseYf(int mouseYf) {
    }
    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

        
    /**
     * Creates new form jpanel
     */
    public jpanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     
   public void formMousePressed(java.awt.event.MouseEvent evt) {
   
       System.out.print("\n mouse pressed");
       
    for (Element obj : Elementss) {
       
        if (obj.contains(evt.getX(), evt.getY())) {
             selectedObject = obj;
            offsetX = evt.getX() - obj.getX();
            offsetY = evt.getY() - obj.getY();
            System.out.print("\n"+selectedObject.getID()+"\n");
            break;
        }
    }

            
    }                                 

    public void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        System.out.print("\n mouse dragged");
        if (selectedObject != null) {
        selectedObject.setX(evt.getX() - offsetX);
        selectedObject.setY(evt.getY() - offsetY);
        repaint();
    }
    }//GEN-LAST:event_formMouseDragged

    public void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        System.out.print("\n mouse Released");
        selectedObject = null;
    }//GEN-LAST:event_formMouseReleased

    public void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
            for (Element obj : Elementss) {
       
        if (obj.contains(evt.getX(), evt.getY())) {
             selectedObject = obj;
             
             pannel.modifyGoal(obj);
            System.out.print("\n"+selectedObject.getID()+"\n");
            break;
        }
    }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}