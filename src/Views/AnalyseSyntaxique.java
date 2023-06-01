/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Mou nir
 */
public class AnalyseSyntaxique extends javax.swing.JFrame {
//      Object[][] Data = {
//                {"E01", "Diagramme", "Chaque diagramme GSN devrait avoir un objectif principal unique."},
//                {"E02", "Éléments", "Erreur : Le but-stratégie doit être lié à au moins un autre élément ou être marqué comme non développé."},
//                {"E05", "Identifiant d'élément", "Erreur : L'identifiant doit être lié à l'élément."},
//                {"E09", "Identifiants d'éléments", "Erreur : L'élément doit avoir un caractère parmi 'G-S-Sn-A-J...' et un nombre."},
//                {"E10", "Identifiants d'éléments", "Erreur : Chaque élément dans le diagramme devrait avoir un identifiant unique."},
//                {"E03", "Éléments", "Erreur : L'assomption-justification-solution-contexte doit être lié à un seul autre élément."},
//                {"E08", "Éléments", "Erreur : Les objectifs et les stratégies marqués comme non développés ne doivent pas avoir d'arguments de soutien."},
//                {"E04", "Identifiants d'éléments", "Erreur : Les numéros d'identifiant devraient être ordonnés par type d'élément '1-2-3-4, etc.'."},
//                {"R01", "Relations", "Erreur : Il ne doit y avoir aucune référence circulaire supportedBy."},
//                {"E06", "Éléments", "Erreur : Tous les éléments doivent être accessibles à partir des éléments racine. Ce message peut par exemple apparaître s'il y a plusieurs graphes indépendants où l'un contient uniquement des références circulaires."},
//                {"R02", "Relations", "Erreur : Tous les éléments référencés dans supportedBy et inContextOf ne doivent pas se référer à l'élément lui-même."},
//                {"R03", "Type de relation - supportedBy", "Erreur : Doit être seulement Goal -> stratégie ou objectif ou solution, ou stratégie -> objectif."},
//                {"R04", "Type de relation - inContextOf", "Erreur : Doit être seulement de 'Goal - Stratégie' à 'Assumption-Context-Justification'."},
//                {"R05", "Relation", "Erreur : La stratégie ne peut pas être directement liée à une solution."},
//                {"R06", "Relation", "Erreur : La solution ne peut être directement liée qu'à un objectif."},
//                {"R07", "Relation", "Erreur : Le contexte ne peut être directement lié qu'à un objectif/stratégie."},
//                {"R08", "Relation", "Erreur : L'assomption ne peut être directement liée qu'à un objectif/stratégie."},
//                {"R09", "Relation", "Erreur : La justification ne peut être directement liée qu'à un objectif/stratégie."}
//        };
      String[][] Data = {
                {"E01",  "Chaque diagramme GSN devrait avoir un objectif principal unique."},
                {"E02", "Erreur : Le but-stratégie doit être lié à au moins un autre élément ou être marqué comme non développé."},
                {"E03", "Erreur : L'assomption-justification-solution-contexte doit être lié à un seul autre élément."},
                {"E04", "Warning : Les numéros d'identifiant devraient être ordonnés par type d'élément '1-2-3-4, etc.'."},
                {"E05", "Erreur : L'identifiant doit être lié à l'élément."},
                {"E06", "Erreur : Tous les éléments doivent être accessibles à partir des éléments racine."},
                {"E07", "Warning : toutes les solutions n'ont pas de preuve d'assurance."},
                {"E08",  "Erreur : Les objectifs et les stratégies marqués comme non développés ne doivent pas avoir d'arguments de soutien."},
                {"E09","Erreur : L'élément doit avoir un caractère parmi 'G-S-Sn-A-J...' et un nombre."},
                {"E10",  "Erreur : Chaque élément dans le diagramme devrait avoir un identifiant unique."},
                {"R01",  "Erreur : Il ne doit y avoir aucune référence circulaire supportedBy."},
                {"R02",  "Erreur : Tous les éléments référencés dans supportedBy et inContextOf ne doivent pas se référer à l'élément lui-même."},
                {"R03", "Erreur : Doit être seulement Goal -> stratégie ou objectif ou solution, ou stratégie -> objectif."},
                {"R04", "Erreur : Doit être seulement de 'Goal - Stratégie' à 'Assumption-Context-Justification'."},
                {"R05", "Erreur : La stratégie ne peut pas être directement liée à une solution."},
                {"R06",  "Erreur : La solution ne peut être directement liée qu'à un objectif."},
                {"R07",  "Erreur : Le contexte ne peut être directement lié qu'à un objectif/stratégie."},
                {"R08",  "Erreur : L'assomption ne peut être directement liée qu'à un objectif/stratégie."},
                {"R09",   "Erreur : La justification ne peut être directement liée qu'à un objectif/stratégie."}
        };

        // Column Names
//        String[] columnNames = {"Code", "Erreur", "Description"};
        String[] columnNames = {"Code","Description"};
        DefaultTableModel modell = new DefaultTableModel(Data, columnNames);
        
    /**
     * Creates new form AnalyseSyntaxique
     */
    public AnalyseSyntaxique() { }
//        initComponents();
//        jTable1.setModel(modell);
//            TableColumn column = jTable1.getColumnModel().getColumn(1);
//         
//        // Set the preferred width of the column
//        column.setPreferredWidth(50);
////           jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//             TableColumn secondColumn = jTable1.getColumnModel().getColumn(0);
//             column.setMinWidth(950);
////             column.setPreferredWidth(500);
//        secondColumn.setResizable(true);
//         
 //        setVisible(true);}
               List<Integer> rowsss ;
    
            TableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Customize the text color for a specific row
                    
              
                   if(rowsss.contains(row)){
                        component.setForeground(Color.RED); // Change to your desired color
                   } else {
                         component.setForeground(table.getForeground());
                    }
                        if(rowsss.contains(row) &&( Data[row][0].equals("E07") ||  Data[row][0].equals("E04"))){
                         component.setForeground(new Color(218, 88, 0));
                   }
                    return component;
                }
            };
        
    public AnalyseSyntaxique(List<String> errors) {
        initComponents();
        rowsss=new ArrayList();
        jTable1.setModel(modell);
            TableColumn column = jTable1.getColumnModel().getColumn(1);
         
        // Set the preferred width of the column
        column.setPreferredWidth(50);
//           jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
             TableColumn secondColumn = jTable1.getColumnModel().getColumn(0);
             column.setMinWidth(950);
//             column.setPreferredWidth(500);
        secondColumn.setResizable(true);
        for(String err : errors){
                    for (int i = 0; i < Data.length; i++) {
                        if(err == Data[i][0]){
                                 if (i != -1) {
                                     rowsss.add(i);
        }
                        }
                        
                    }
        }
         jTable1.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
         jTable1.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
         
        setVisible(true);
      
    }
//    DefaultTableModel tableModel = new DefaultTableModel(
//                new Object[][]{}, // data
//                new Object[]{"Type", "Component", "Description"} // column identifiers
//        );

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 153, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Erreur", "Description"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(35);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AnalyseSyntaxique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalyseSyntaxique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalyseSyntaxique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalyseSyntaxique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalyseSyntaxique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
