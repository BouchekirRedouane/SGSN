package Views.Dialogs;

import Controlers.GSN_Builder;
import Models.Assumption;
import Models.Context;
import Models.Element;
import Models.Goal;
import Models.Strategy;
import Models.GSN;
import Models.Justification;
import Models.Solution;
import Views.GsnPannel;
import java.awt.event.KeyEvent;

public class NewGoalInputs extends javax.swing.JDialog {
    Element element;
    boolean modify;
    GSN gsn;
    GSN_Builder builder;
//create
    public NewGoalInputs(java.awt.Frame parent, boolean modal,GSN_Builder builder) {
        super(parent, modal);
        initComponents();
        jButton3.setVisible(false);
        Lien1_Tfield.setVisible(false);
         Lien2_Tfield.setVisible(false);
         jLabel5.setVisible(false);

       jCheckBox1.setVisible(false);
        this.setLocationRelativeTo(null);
       
        this.builder=builder;
//         this.gsn=builder.getGsn();
    }
    public NewGoalInputs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jButton3.setVisible(false);
       
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   

////for edits and delets
    public NewGoalInputs(java.awt.Frame parent, boolean modal,Element element,GSN gsn){
        super(parent, modal);
        this.gsn=gsn;
        this.element = element;
        builder=new GSN_Builder(gsn);
        initComponents();
        Lien1_Tfield.setVisible(false);
         Lien2_Tfield.setVisible(false);
                  jLabel5.setVisible(false);

         jCheckBox1.setVisible(true);
        this.jTextField1.setText(element.getID());
        this.jTextArea1.setText(element.getDescreption());
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
        System.out.print("\n selected obj is :"+element.getID()+"\n");
        modify=true;
        jCheckBox1.setVisible(false);
        if(element instanceof Goal || element instanceof Strategy){
            jCheckBox1.setVisible(true);
            jCheckBox1.setSelected(element.isunDevelloped());
        }else  if(element instanceof Solution){
             Lien1_Tfield.setVisible(true);
         Lien2_Tfield.setVisible(true);
         jLabel5.setVisible(true);
            Lien1_Tfield.setText(element.getLink1());
            Lien2_Tfield.setText(element.getLink2());
              
        }
       
         this.setLocationRelativeTo(null);
        this.setVisible(true);
            
            
        
        
        
         
        
    }
    
    
    public void annuler()
    {
        this.jTextField1.setText("");
        this.jTextArea1.setText("");
    }
    public void modifier(){
          
        String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
//        if(!"".equals(ID)){
//           element.setID(ID); 
//        }
//        if(!"".equals(Desc)){
//        element.setDescreption(Desc);
//        }
        if(builder.CheckInput(element,ID, Desc))
            if(element instanceof Goal || element instanceof Strategy){
                System.out.println("modifier methode set      "+jCheckBox1.isSelected());
                 builder.modifyElement(element,ID,Desc,jCheckBox1.isSelected());
            }else if(element instanceof Solution){
                 builder.modifyElement(element,ID,Desc,Lien1_Tfield.getText(),Lien2_Tfield.getText());
            }else{builder.modifyElement(element,ID,Desc);}
        
        System.out.print("\n modifier method done :"+element.getID()+"\n");
        
    }
    
    public Goal getGoal(){
        
        setTitle("créer un nouveaux Goal");
        jLabel4.setText("Goal");
        jCheckBox1.setVisible(true);
         this.setVisible(true);
        String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
        boolean undev=jCheckBox1.isSelected();
        
        Boolean result= builder.CheckInput(ID, Desc,"Goal");
        
            if(result == true){
//                Goal goall = new Goal(ID, Desc,jCheckBox1.isSelected());
                Goal goall =(Goal) builder.CreateElement(ID,Desc,undev,"Goal");
                return goall;
            }
       
        return null;
    }
     public Strategy getStrategy() {
         setTitle("créer une nouvelle Strategie");
         jLabel4.setText("Strategy");
         jCheckBox1.setVisible(true);
          this.setVisible(true);
        String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
        boolean undev=jCheckBox1.isSelected();
        
        Boolean result= builder.CheckInput(ID, Desc,"Strategy");
        
        if(result == true)
        {
//            Strategy strategyy = new Strategy(ID, Desc,jCheckBox1.isSelected());
            Strategy strategyy =(Strategy) builder.CreateElement(ID,Desc,undev,"Strategy");
            
            return strategyy;
        }
        return null;
     }
     public Solution getSolution() {
         setTitle("créer une nouvelle Solution");
         jLabel4.setText("Solution");
         Lien1_Tfield.setVisible(true);
         Lien2_Tfield.setVisible(true);
         jLabel5.setVisible(true);
//         jCheckBox1.setVisible(false);
          this.setVisible(true);
        String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
        String Link1=this.Lien1_Tfield.getText();
        String Link2=this.Lien2_Tfield.getText();
       
        Boolean result= builder.CheckInput(ID,Desc,"Solution");

        
        if(result == true)
        {
//            Solution solution = new Solution(ID, Desc);
            Solution solution = (Solution) builder.CreateElement(ID,Desc,Link1,Link2);
           
            return solution;
        }
        return null;
     }
      public Context getContext() {
          setTitle("créer un nouveaux Context");
          jLabel4.setText("Context");
          this.setVisible(true);
        String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
        Boolean result= builder.CheckInput(ID, Desc,"Context");
        if(result == true)
        {
//            Context context = new Context(ID, Desc);
                Context context =(Context) builder.CreateElement(ID,Desc,"Context");

           
            return context;
        }
        return null;
    }

    public Justification getJustification() {
         setTitle("créer une nouvelle Justification");
        jLabel4.setText("Justification");
        this.setVisible(true);
        String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
        
        Boolean result= builder.CheckInput(ID, Desc,"Justification");
        if(result == true)
        {
//            Justification justification = new Justification(ID, Desc);
            Justification justification = (Justification) builder.CreateElement(ID,Desc,"Justification");
            
           
            return justification;
        }
        return null;
    }

    public Assumption getAssumption() {
        setTitle("créer une nouvelle Assumption");
        jLabel4.setText("Assumption");
          this.setVisible(true);
            String ID = this.jTextField1.getText();
        String Desc= this.jTextArea1.getText();
        
        Boolean result= builder.CheckInput(ID, Desc,"Assumption");
        if(result == true)
        {
//            Assumption assumption = new Assumption(ID, Desc);
            Assumption assumption = (Assumption) builder.CreateElement(ID,Desc,"Assumption");
           
            return assumption;
        }
        return null;

    }

    
    public void quitter()
    {
        this.dispose();
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        Lien1_Tfield = new javax.swing.JTextField();
        Lien2_Tfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Goal ");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Veuillez préciser ID et Description du ");

        jLabel2.setText("ID:");

        jLabel3.setText("Desc:");

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 255, 0));
        jButton4.setText("Valider");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("...");

        jCheckBox1.setText("Undeveloped ");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        Lien1_Tfield.setForeground(new java.awt.Color(153, 153, 153));
        Lien1_Tfield.setToolTipText("Lien de l'attachement 1");
        Lien1_Tfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lien1_TfieldActionPerformed(evt);
            }
        });

        Lien2_Tfield.setForeground(new java.awt.Color(153, 153, 153));

        jLabel5.setText("Lien au attachements:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jSeparator1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTextField1)
                                    .addComponent(Lien1_Tfield)
                                    .addComponent(Lien2_Tfield)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lien1_Tfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lien2_Tfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jCheckBox1))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
        this.quitter();  
        if (modify==true){
        System.out.print("\n modify is true");
        this.modifier();}
            
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.quitter();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        gsn.deletElement(element);
        builder.deleteElement(element);
        this.quitter();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             this.quitter();  
         }
    }//GEN-LAST:event_formKeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void Lien1_TfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lien1_TfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lien1_TfieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewGoalInputs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGoalInputs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGoalInputs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGoalInputs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewGoalInputs dialog = new NewGoalInputs(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Lien1_Tfield;
    private javax.swing.JTextField Lien2_Tfield;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

   
   
}
