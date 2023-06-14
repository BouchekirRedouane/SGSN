/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.awt.*;
import java.awt.datatransfer.*;
import Controlers.Analyse_Semantique;
import Models.Element;
import Models.GSN;
import Models.Relation.InContextOf;
import Models.Relation.Relations;
import Models.Solution;
import com.kitfox.svg.Path;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.Node;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static org.jfree.util.ObjectUtilities.getClassLoader;
import prism.Prism;
import prism.PrismException;



/**
 *
 * @author Mou nir
 */


public class AnalyseSemantique extends javax.swing.JFrame {

    
    
  

    /**
     * Creates new form AnalyseSemantique
     */
    GSN gsn;
    Analyse_Semantique semantique;

    public AnalyseSemantique(GSN gsn) throws InterruptedException, IOException, PrismException{
        this.gsn=gsn;
        initComponents();
                semantique = new Analyse_Semantique(this.gsn);

        generateGraph(this.gsn) ;
        
        
        
//        TimeUnit.SECONDS.sleep(3);
        setVisible(true);
//       checkPrism();
//         convertAndDisplayGraph(convertToGraph());
         
        // Obtain the URL of the file
//        URL url = AnalyseSemantique.class.getClassLoader().getResource("PrismModel/model.pm");
       
        
    }
    public AnalyseSemantique() {
        initComponents();
        setVisible(true);
    }
  
    public void generateGraph(GSN gsn) throws IOException, InterruptedException, PrismException {
              ArrayList<Element> nodes=gsn.getElements();
             ArrayList<Relations> edges=gsn.getRelations();
             
             
             
             
              StringBuilder dotGraph = new StringBuilder();
        dotGraph.append("digraph G {\n");
        dotGraph.append("  node [shape = circle,  style = filled,fillcolor = \"#ffe699\",color=orange, stroke = red, ];\n");
        

        for (Element node : nodes) {
            dotGraph.append("  ").append("s"+nodes.indexOf(node)).append(";\n");
            if(node instanceof Solution){
                dotGraph.append("  ").append("s"+nodes.indexOf(node)).append(" -> ").append("s"+nodes.indexOf(node)).append(";\n");
            }
        }


        for (Relations edge : edges) {
//            dotGraph.append("  ").append(edge.getSource()).append(" -> ").append(edge.getDestination()).append(";\n");
                
                        dotGraph.append("  ").append("s"+nodes.indexOf(edge.getSource())).append(" -> ").append("s"+nodes.indexOf(edge.getTarget()));
                        if(edge instanceof InContextOf){
                            dotGraph.append("[color=grey]");
                        }
                         dotGraph.append("\n");
        }

        dotGraph.append("}");
//        return dotGraph.toString();
    
        
        

//        String dotGraph = dotGraph.toString();
        String dotFilePath = "graph.dot";
//        Date d = new Date();
         try (PrintWriter writer = new PrintWriter(new FileWriter(dotFilePath))) {
            writer.println(dotGraph.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
//           String command1 = "dot -Tpng " + dotFilePath + " -o graphc.png";
            String ig=" -o graph.png";
           String command = "dot -Tpng " + dotFilePath +ig;
//           System.out.println(ig);
//           System.out.println(command);
           Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

//        generateGraphImage(dotFilePath);
           ImageIcon newImageIcon=null;
           
            
            
            newImageIcon = new ImageIcon("graph.png");
            File file=new File("graph.png");
           BufferedImage newImageIcon1 =ImageIO.read(file);
               // Create a new label and set its icon to the new image.
        JLabel  jLabel = new JLabel(new ImageIcon(newImageIcon1));
      
        // Remove the old label from the panel.
        jPanel2.remove(jPanel2.getComponentCount() - 1);

        // Add the new label to the panel.
        jPanel2.add(jLabel);

        // Revalidate and repaint the panel.
        jPanel2.revalidate();
        jPanel2.repaint();

//            this.jLabel2 =  new JLabel();
//            this.jPanel2.removeAll();
      jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel2.setIcon(null);
//        this.jLabel2.removeAll();
//        jLabel2.setIcon(newImageIcon);
//         this.jLabel2.repaint();
//        this.jLabel2.revalidate();
//       System.out.print("//////////////////////////////////////////////////////MMMMMMMMMMMMMMMMMMMMMMMMMM");
        jLabel.setPreferredSize(new java.awt.Dimension(357, 359));
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
         jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        
//        jLabel2.setPreferredSize(new java.awt.Dimension(357, 359));
//        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//         jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
//        );
//        jPanel2Layout.setVerticalGroup(
//            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
//        );
        
        
        jTextPane2.setText(semantique.generateMDP());
        
            this.jPanel2.add(jLabel2);
            this.jPanel2.repaint();
            
            this.jPanel2.revalidate();
            
            if(semantique.checkPrism()){
                jLabel4.setForeground(new Color(0,153,51));
                jLabel4.setText("Valide");
            }else{
                jLabel4.setForeground(Color.red);
                jLabel4.setText("Invalide");
            }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(357, 359));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel2);

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(new java.awt.Color(255, 255, 153));
        jTextPane2.setText("     ");
        jTextPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextPane2.setMinimumSize(new java.awt.Dimension(400, 22));
        jTextPane2.setPreferredSize(new java.awt.Dimension(400, 250));
        jScrollPane2.setViewportView(jTextPane2);

        jSplitPane2.setLeftComponent(jScrollPane2);

        jButton1.setText("Copier MDP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("GSN sous form MDP :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Resultat PRISM :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Valide");

        jButton2.setText("Affiher log PRISM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(semantique.generateMDP());
        clipboard.setContents(selection, null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            semantique.AfficheLog();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AnalyseSemantique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalyseSemantique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalyseSemantique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalyseSemantique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalyseSemantique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
