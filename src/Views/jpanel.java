/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controlers.GSN_Builder;
import Controlers.GSN_Renderer;
import Models.*;
import java.awt.Font;
import java.awt.Graphics;
import Models.GSN;
import Models.Relation.Relations;
import Models.Solution;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;








/**
 *
 * @author Mou nir
 */
public class jpanel extends javax.swing.JPanel {
    private int mouseX;
    private int mouseY;
    private int mousePressX;
    private int mousePressY;
    private boolean press=false;
    private boolean toggle ;
    private int offsetX;
    private int offsetY;
    private GsnPannel pannel;
    GSN gsn;
    private ArrayList<Element> Elementss ;
    private ArrayList<Relations> Relations ;
    private  Element selectedObject;
    GSN_Builder builder;   
    GSN_Renderer renderer;

    public jpanel(GSN gsn,GsnPannel pannel) {
        this.gsn = gsn;
        this.pannel=pannel;
        builder = new GSN_Builder( gsn,  pannel, pannel.mainFram);
        renderer = new GSN_Renderer(pannel);
        Relations = gsn.getRelations();
         Elementss = gsn.getElements();
        
        
    }
    
     
    

  
//    
//      private String buttonTextG = "G1\n\n Goal description goes here";
//       private String buttonTextS = "S1\n\n Strategy description goes here";
//       private String buttonTextSn = "Sn1\n\n Solution description goes here";
//       private String buttonTextC = "C1\n\n Context description goes here";
//       private String buttonTextJ = "J1\n\n Justification description goes here";
//       private String buttonTextA = "A1\n\n Assumption description goes here";

    public boolean isPress() {
        return press;
    }
       
      
      
    @Override
      public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        
               g.setFont(new Font("Arial", Font.BOLD, 16));
              
                  
        if (toggle==true) {
            renderer.renderPreview( g,mouseX,mouseY ,mousePressX , mousePressY );
//            switch (pannel.action) {
//                case "Relation.support" -> {
//                    if(press){
//                        System.out.println("switch case draw entred");
//                        g.setColor(Color.LIGHT_GRAY);
//                        g.drawLine(mousePressX, mousePressY, mouseX, mouseY);
//                    }
//                }
//                case "Relation.context" -> {
//                    if(press){
//                        System.out.println("\nPress= true\n");
//                        g.setColor(Color.LIGHT_GRAY);
//                        g.drawLine(mousePressX, mousePressY, mouseX, mouseY);
//                    }
//                }
//                case "Goal" -> {
//                    System.out.print("\n Switch case worcked ");
//                    Goal goal = new Goal();
//                    goal.draw(g,mouseX,mouseY,buttonTextG);
//                }
//                case "Strategy" -> {
//                    //                     System.out.print("\n Switch case worcked for strategy ");
//                    Strategy strategy = new Strategy();
//                    strategy.draw(g,mouseX,mouseY,buttonTextS);
//                }
//                case "Solution" -> {
//                    //                     System.out.print("\n Switch case worcked for strategy ");
//                    Solution solution = new Solution("Sn22",buttonTextSn);
//                    solution.calcule_dimentions(g);
//                    solution.draw(g,mouseX,mouseY,buttonTextSn);
//                }
//                case "Context" -> {
//                    //                     System.out.print("\n Switch case worcked for Context ");
//                    Context context = new Context();
//                    context.draw(g,mouseX,mouseY,buttonTextC);
//                }
//                case "Justification" -> {
//                    //                     System.out.print("\n Switch case worcked for strategy ");
//                    Justification justification = new Justification("Sn22",buttonTextJ);
//                    justification.draw(g,mouseX,mouseY,buttonTextJ);
//                }
//                case "Assumption" -> {
//                    //                     System.out.print("\n Switch case worcked for strategy ");
//                    Assumption assumption = new Assumption("Sn22",buttonTextA);
//                    assumption.draw(g,mouseX,mouseY,buttonTextA);
//                }
//
//            }            
          }
        renderer.renderComponents(g);

//        Relations = gsn.getRelations();
//	    if(Relations!=null)    
//	        for (int i = 0; i < Relations.size(); i++) {
//	             Relations relations = Relations.get(i);
//	             relations.draw(g);
//	             
//	        }
//        Elementss = gsn.getElements();
//        if(Elementss!=null) 
//        	for (int i = 0; i < Elementss.size(); i++) {
//	             Element element = Elementss.get(i);
//	             element.draw(g);
//	             
//	        }
      }

   
        

    
    
        void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseMoved
              for (Element obj : Elementss) {
             
            if (obj.contains(evt.getX(), evt.getY())) {
                obj.setHover(true);
            }else{
                obj.setHover(false);
            }
            }
              for (Relations Rel : Relations) {
             
            Rel.contains(evt.getX(), evt.getY());
              }
           
        mouseX = evt.getX();
        mouseY = evt.getY();
        repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseMoved
        
  

//    public void setMouseXf(int mouseXf) {
//    }
//
//    public void setMouseYf(int mouseYf) {
//    }
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
   
      
//                    System.out.println(mousePressX+":mousePressX////////////mousePressY:"+mousePressY);
                    
       
        for (Element obj : Elementss) {
             
            if (obj.contains(evt.getX(), evt.getY())) {
                if(pannel.action=="Relation.context"||pannel.action=="Relation.support"){
//                        System.out.println(mousePressX+":mousePressX////////////mousePressY:"+mousePressY);
//                       System.out.println("\n mouse pressed");
//                       System.out.println("\n "+pannel.action);    
                    press = true;
                    mousePressX=evt.getX();
                    mousePressY=evt.getY();
                    System.out.println("\n "+obj.getID());    
//                    pannel.addRelation(obj,true);
                    selectedObject = obj;
                     
                }else{
                    selectedObject = obj;
                    offsetX = evt.getX() - obj.getX();
                    offsetY = evt.getY() - obj.getY();
                    System.out.print("\n"+selectedObject.getID()+"\n");           
                }

                break;
            }
        }

            
    }                                 

    public void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        System.out.println("\n mouse dragged");
//        System.out.println("\n/////////////////////////"+press);
        if (selectedObject != null){
            if(pannel.action=="Relation.context"||pannel.action=="Relation.support"){
                mouseX=evt.getX();
                mouseY=evt.getY();

//                       System.out.println(mousePressX+":mousePressX////////////mousePressY:"+mousePressY);
//                       System.out.println(mouseX+":mouseX////////////mouseY:"+mouseY);
//                       System.out.println("///////////////////////////////////////////////////////////////////////////");
//                       
            
            }else {
            selectedObject.setX(evt.getX() - offsetX);
            selectedObject.setY(evt.getY() - offsetY);

            }
                        repaint();
        }
    }//GEN-LAST:event_formMouseDragged

    public void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        System.out.print("\n mouse Released");
        press = false;
        if(pannel.action=="Relation.context"||pannel.action=="Relation.support"){
          for (Element obj : Elementss) {
             
                if (obj.contains(evt.getX(), evt.getY())) {
          
                    builder.addRelation(selectedObject,obj );

                    press = false;
                }
             
            }
        }
                selectedObject = null;
                    System.out.println("/////////////////////////////BUTTON PRESS ENDDEd/////////////////////////////");
                
        
    }//GEN-LAST:event_formMouseReleased

    public void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
            for (Element obj : Elementss) {
                if(obj instanceof Solution){
                    try {
                        ((Solution) obj).containsLink1(evt.getX(), evt.getY());
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(jpanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        ((Solution) obj).containsLink2(evt.getX(), evt.getY());
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(jpanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
       
        if (obj.contains(evt.getX(), evt.getY())) {
             selectedObject = obj;
             pannel.modifyGoal(obj);
            System.out.print("\n"+selectedObject.getID()+"\n");
            break;
        }
        for (Relations Rel : Relations) {
             
            if (Rel.contains(evt.getX(), evt.getY())) {
                   pannel.deleteRelation(Rel);
                   break;
           
        }
            }}
            
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

