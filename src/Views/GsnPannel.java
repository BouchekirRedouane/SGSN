package Views;

import Models.Element;
import Models.Goal;
import Models.GSN;
import Models.Solution;
import Models.Strategy;
import Views.Dialogs.NewGoalInputs;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class GsnPannel extends javax.swing.JPanel {

    GSN gsn;
    String action;
    MainFram mainFram;
    jpanel jPanel6;
//            = new jpanel(gsn);
    String xmlString;
    
    
  
    
    
    
    public GsnPannel(MainFram mainFram, GSN gsn) {
        
        this.action = "None";
        this.mainFram = mainFram;
        this.gsn = gsn;
        this.jPanel6= new jpanel(gsn,this);
        initComponents();
        this.initAffichage();
       
    }

    public void initAffichage() {
        this.jLabel2.setText(this.gsn.getName());
        this.jLabel4.setText(this.gsn.getPath());
    }

    public void addElement(int x, int y) {
//        if (this.action.equals("Goal")) {
            this.addGoal(x, y);   
//        }
//        switch (this.action) {
//            case "Goal" -> this.addGoal(x, y);
//            case "Strategy" -> this.addGoal(x, y);    
//            case "Solution" -> this.addGoal(x, y);    
//        }
        
        this.mainFram.refreshScreen();

    }

        public void addGoal(int x, int y) {
        NewGoalInputs newGoalInputs = new NewGoalInputs(mainFram, true);
        switch (this.action) {
            case "Goal":
                Goal goal = newGoalInputs.getGoal(); 
                 if(goal != null){
                    goal.setX(x);
                    goal.setY(y);
                    gsn.addElementt(goal);
                }
                break;
            case "Strategy":
                 Strategy strategy = newGoalInputs.getStrategy(); 
                if(strategy != null){
                    strategy.setX(x);
                    strategy.setY(y);
                    gsn.addElementt(strategy);
                }
                break;    
            case "Solution":
                 Solution solution = newGoalInputs.getSolution(); 
                if(solution != null){
                    solution.setX(x);
                    solution.setY(y);
                    gsn.addElementt(solution);
                }
                break;    
        }
                this.Goal_Btn.setSelected(false);
                this.Strategy_Btn.setSelected(false);
                this.action = "None";
                this.jLabel6.setText("None");
                this.jPanel6.setToggle(false);
                    
//        Goal goal = newGoalInputs.getGoal(); 
        
//whene editing this to accept all types of elements  add a switch case in line 47 of the class Newgoal input and pass the name of the element to the method so you construct the right object
       
    }
       
      public void modifyGoal(Element goal) {
        NewGoalInputs newGoalInputs = new NewGoalInputs(mainFram, true,goal,gsn);
       
      }
    public void setGoalLocation(GoalPannel goalPannel, int x, int y){
        goalPannel.setLocation(x, y);            
    }
    
    
    public void deleteGoal(GoalPannel goalPannel)
    {
        jPanel6.remove(goalPannel);
        jPanel6.repaint();
        jPanel6.validate();
    }
    
     public GSN getGsn() {
        return gsn;
    }
     
    public void serialization() {
        File file = new File("file.xml");
        StringWriter sw = new StringWriter();
        Marshaller marshaller;
        try {
            JAXBContext context = JAXBContext.newInstance(GSN.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(gsn, sw);
            marshaller.marshal(gsn, file);
            xmlString = sw.toString();
            jTextPane1.setText("");
            jTextPane1.setText(xmlString);
         
            
        } catch (JAXBException ex) {
            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     

    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Goal_Btn = new javax.swing.JToggleButton();
        Strategy_Btn = new javax.swing.JToggleButton();
        Solution_Btn = new javax.swing.JToggleButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
  
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("GSN:   ");
        jToolBar1.add(jLabel1);

        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("jLabel2");
        jToolBar1.add(jLabel2);

        jLabel3.setText("   | Chemin:   ");
        jToolBar1.add(jLabel3);

        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("jLabel4");
        jToolBar1.add(jLabel4);

        jLabel7.setText("  | Statut:  ");
        jToolBar1.add(jLabel7);

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("None");
        jToolBar1.add(jLabel6);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Éléments du GSN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        Goal_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        Goal_Btn.setText("Goal     ");
        Goal_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Goal_BtnActionPerformed(evt);
            }
        });

        Strategy_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        Strategy_Btn.setText("Strategy");
        Strategy_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Strategy_BtnActionPerformed(evt);
            }
        });

        Solution_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        Solution_Btn.setText("Solution");
        Solution_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Solution_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Goal_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Strategy_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Solution_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Goal_Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strategy_Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Solution_Btn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Export.png"))); // NOI18N
        jButton1.setText("Exporter comme image");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Save.png"))); // NOI18N
        jButton2.setText("Enregistrer XML");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar2.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Verify.png"))); // NOI18N
        jButton3.setText("Analyse syntaxique");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Verify.png"))); // NOI18N
        jButton4.setText("Analyse sémantique ");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar2.add(jButton4);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setAutoscrolls(true);
        jPanel6.setPreferredSize(new java.awt.Dimension(4000, 4000));
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel6MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel6MouseMoved(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel6MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1316, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("GSN Viewer", new javax.swing.ImageIcon(getClass().getResource("/Ressources/GSN.png")), jPanel4); // NOI18N

        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("GSN-XML", new javax.swing.ImageIcon(getClass().getResource("/Ressources/XML.png")), jPanel5); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Goal_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Goal_BtnActionPerformed
                            if (this.Goal_Btn.isSelected()) {
                                //set all other Button to unselected   
                                this.Strategy_Btn.setSelected(false);
                                this.action = "Goal";
                                this.jLabel6.setText("Adding a Goal...");
                                jPanel6.setToggle(true);
                                
                            } else {
                                this.action = "None";
                                this.jLabel6.setText("None...");
                                jPanel6.setToggle(false);
                            }
    }//GEN-LAST:event_Goal_BtnActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        if(this.action!="None"){
        int x = evt.getX();
        int y = evt.getY();
        jPanel6.setMouseYf(y);
        jPanel6.setMouseXf(x);
        jPanel6.setClicked(true);
         System.out.print(x+":x////y:"+y);
        addElement(x, y);
        }else{
            jPanel6.formMouseClicked(evt);
        }
        
         
         
        
        
    
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
      jPanel6.formMousePressed(evt);
    }//GEN-LAST:event_jPanel6MousePressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
          serialization();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseReleased
        jPanel6.formMouseReleased(evt);      
    }//GEN-LAST:event_jPanel6MouseReleased

    private void jPanel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseDragged
       jPanel6.formMouseDragged( evt);
    }//GEN-LAST:event_jPanel6MouseDragged

    private void Strategy_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Strategy_BtnActionPerformed
        if (this.Strategy_Btn.isSelected()) {
            //set all other Button to unselected 
            this.Goal_Btn.setSelected(false);
            this.action = "Strategy";
            this.jLabel6.setText("Adding a Strategy...");
            jPanel6.setToggle(true);
            System.out.print(jPanel6.isToggle());
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
            }
    }//GEN-LAST:event_Strategy_BtnActionPerformed

    private void Solution_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Solution_BtnActionPerformed
   if (this.Solution_Btn.isSelected()) {
            //set all other Button to unselected 
            this.Goal_Btn.setSelected(false);
            this.Strategy_Btn.setSelected(false);
            this.action = "Solution";
            this.jLabel6.setText("Adding a Solution...");
            jPanel6.setToggle(true);
            System.out.print(jPanel6.isToggle());
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
            }
    }//GEN-LAST:event_Solution_BtnActionPerformed
    private void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {                                     
    	jPanel6.jPanel6MouseMoved( evt);
     }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Goal_Btn;
    private javax.swing.JToggleButton Solution_Btn;
    private javax.swing.JToggleButton Strategy_Btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
 
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
