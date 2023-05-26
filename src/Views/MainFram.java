package Views;

import Views.Dialogs.NewGsnInputs;
import Models.GSN;


import Controlers.Files_management;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;

public class MainFram extends javax.swing.JFrame {

    int i =1 ;
    Files_management fmanager;
    
//    Files_management fileManager;
    public MainFram() {
        initComponents();
        fmanager=new Files_management(this);
        this.setLocationRelativeTo(null);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            setSize(1000, 800);
        this.setVisible(true);
    }

    public JTabbedPane getjTabbedPane2() {
        return jTabbedPane2;
    }

    public int getI() {
        return i;
    }

    public Files_management getFmanager() {
        return fmanager;
    }
    

    public void setI(int i) {
        this.i = i;
    }
    
    

    
    
    public void createNewGSN()
    {
        NewGsnInputs gsnInputName = new NewGsnInputs(this, true);
 
    }
    
    
    
    public void createNewGSN(String name, String path) throws IOException
    {
        GSN gsn=fmanager.createNewGSN(name,path);
        fmanager.SaveAsXml(gsn);
        GsnPannel g = new GsnPannel(this, gsn);
        jTabbedPane2.addTab("GSN: "+ gsn.getName(), g);
        this.jTabbedPane2.setIconAt(this.jTabbedPane2.getTabCount()-1, new javax.swing.ImageIcon(getClass().getResource("/Ressources/24diagram.png")));
//        this.jTabbedPane2.setIconAt(this.jTabbedPane2.getTabCount()-1, new javax.swing.ImageIcon(getClass().getResource("1diagram.png")));
       i++;
    }
    
    
    public void refreshScreen()
    {
        this.jTabbedPane2.validate();
    }
    
    
//    private void importGsn() {
//        this.fileChooser();


//        Files_management fmanager=new Files_management();
//         GSN gsn = fmanager.desiarilize(gsnpath);
//         GsnPannel g = new GsnPannel(this, gsn);
//         jTabbedPane2.addTab("GSN: "+ gsn.getName(), g);
//         this.jTabbedPane2.setIconAt(this.jTabbedPane2.getTabCount()-1, new javax.swing.ImageIcon(getClass().getResource("/Ressources/GsnDiagram.png")));
//        i++;
        
        
        
//       Unmarshaller unmarshaller;
//            try {
//                System.out.println("1///////////////////////////////////////////");
//                 JAXBContext jaxbContext = JAXBContext.newInstance(GSN.class, Goal.class, Strategy.class, Solution.class);
//                 System.out.println("2///////////////////////////////////////////");
//                  unmarshaller = jaxbContext.createUnmarshaller();
//                  System.out.println("3///////////////////////////////////////////");
//                 GSN gsn = (GSN) unmarshaller.unmarshal(new File("file.xml"));
//                 System.out.println("4///////////////////////////////////////////");
//                 System.out.println(gsn.getName()+"///////////////////////////////////////////");
//                         GsnPannel g = new GsnPannel(this, gsn);
//                       jTabbedPane2.addTab("GSN: "+ gsn.getName(), g);
//                        this.jTabbedPane2.setIconAt(this.jTabbedPane2.getTabCount()-1, new javax.swing.ImageIcon(getClass().getResource("/Ressources/GsnDiagram.png")));
//        i++;
//             } catch (JAXBException e) {
//                 e.printStackTrace();
//                 System.out.println("this is exception");
//             }
//    }
    
//    public void fileChooser()
//    {
//        JFileChooser fileChooser = new JFileChooser(); // create a file chooser
//        int result = fileChooser.showOpenDialog(null); // show the dialog and get the result
//        if (result == JFileChooser.APPROVE_OPTION) { // if the user selected a file
//           File selectedFile = fileChooser.getSelectedFile(); // get the selected file
//           this.gsnpath=selectedFile.getAbsolutePath();
//        } 
//        
//    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USTHB-FI-GSN Tool");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setAlignmentX(0.0F);
        jToolBar1.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/..floppy-disk-circle-arrow-right (2).png"))); // NOI18N
        jButton1.setText("Nouveau GSN");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/..floppy-disk-circle-arrow-right (5).png"))); // NOI18N
        jButton2.setText("Import GSN ");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setMaximumSize(new java.awt.Dimension(106, 28));
        jButton2.setMinimumSize(new java.awt.Dimension(106, 28));
        jButton2.setPreferredSize(new java.awt.Dimension(106, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jToolBar2.setBackground(new java.awt.Color(0, 40, 81));
        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar2.setFloatable(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    USTHB-FI-GSN Tool");
        jToolBar2.add(jLabel1);
        jToolBar2.add(jSeparator1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.createNewGSN();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        this.importGsn();
    fmanager.importGSN();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
                ImageIcon icon = new ImageIcon("C:\\Users\\Mou nir\\Documents\\NetBeansProjects\\SGSN\\src\\Ressources\\Component2.png");
                 setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MainFram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

 
}
