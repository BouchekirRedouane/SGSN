package Views;

import Controlers.Analyse_Syntaxique;
import Controlers.Files_management;
import Controlers.GSN_Builder;
import Models.Element;
import Models.GSN;
import Models.Relation.Relations;
import Views.Dialogs.NewGoalInputs;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;




public class GsnPannel extends javax.swing.JPanel {

    GSN gsn;
    String action;
    MainFram mainFram;
    jpanel jPanel6;
//            = new jpanel(gsn);
    GSN_Builder builder;
    Files_management fmanager;
    
    
    
  
    
    
    
    public GsnPannel(MainFram mainFram, GSN gsn) {
        
        this.action = "None";
        this.mainFram = mainFram;
        this.gsn = gsn;
        this.jPanel6= new jpanel(gsn,this);
        initComponents();
        this.initAffichage();
        builder = new GSN_Builder( gsn, this ,  mainFram);
        fmanager= new Files_management(mainFram);
        
       
    }

    public MainFram getMainFram() {
        return mainFram;
    }
    

    public JTextPane getjTextPane1() {
        return jTextPane1;
    }
    

    public jpanel getjPanel6() {
        return jPanel6;
    }

    public String getAction() {
        return this.action;
    }
    public void setAction(String action) {
        this.action = action;
        if("None".equals(action))
            this.jLabel6.setText("None");
            this.jPanel6.setToggle(false);
         
    }
    
    
    public void initAffichage() {
        this.jLabel2.setText(this.gsn.getName());
        this.jLabel4.setText(this.gsn.getPath());
    }
        
//    void addRelation(Element source ,Element target ) {
//        if(this.action=="Relation.support"){
//            if(source==target){
//                
//            }else if(SupportedBy.canBeSourceAndTarget(source,target) ){
//                currentRelation = new SupportedBy(source,target);
//                gsn.addRelationn(currentRelation);     
//                currentRelation=null;
//                this.action="None";
//            }else{
//                SupportRelationWarning supportRelationWarning =new SupportRelationWarning(mainFram,false);
//                supportRelationWarning.setVisible(true);
//            }    
//            }else if(this.action=="Relation.context"){
//                if(source==target){
//                
//                }else if( InContextOf.canBeSource(source) && InContextOf.canBeTarget(target)){
//                
//                    currentRelation = new InContextOf(source,target);
//                    gsn.addRelationn(currentRelation);
//                    System.out.println("added the context realtion");
//                    this.action="None";
//                }else{
//                    ContextRelationWarning contextRelationWarning =new ContextRelationWarning(mainFram,false);
//                    contextRelationWarning.setVisible(true);
//                }
//                    
//                    currentRelation=null;
//                
//            }
//    }

        
//        
//    
//    public void addElement(int x, int y) {
//  NewGoalInputs newGoalInputs = new NewGoalInputs(mainFram, true);
//        switch (this.action) {
//            case "Goal" -> {
//                Goal goal = newGoalInputs.getGoal();
//                if(goal != null){
//                    goal.setX(x);
//                    goal.setY(y);
//                    gsn.addElementt(goal);
//                }
//            }
//            case "Strategy" -> {
//                Strategy strategy = newGoalInputs.getStrategy(); 
//                if(strategy != null){
//                    strategy.setX(x);
//                    strategy.setY(y);
//                    gsn.addElementt(strategy);
//                }
//            }
//            case "Solution" -> {
//                Solution solution = newGoalInputs.getSolution();
//                
//                if(solution != null){
//                    solution.setX(x);
//                    solution.setY(y);
//                    gsn.addElementt(solution);
//                }
//            }
//            case "Context" -> {
//                Context context = newGoalInputs.getContext();
//                
//                if(context != null){
//                    context.setX(x);
//                    context.setY(y);
//                    gsn.addElementt(context);
//                }
//            }
//            case "Justification" -> {
//                Justification justification = newGoalInputs.getJustification();
//                
//                if(justification != null){
//                    justification.setX(x);
//                    justification.setY(y);
//                    gsn.addElementt(justification);
//                }
//            }
//            case "Assumption" -> {
//                Assumption assumption = newGoalInputs.getAssumption();
//                
//                if(assumption != null){
//                    assumption.setX(x);
//                    assumption.setY(y);
//                    gsn.addElementt(assumption);
//                }
//            }    
//        }
//                this.Goal_Btn.setSelected(false);
//                this.Strategy_Btn.setSelected(false);
//                this.action = "None";
//                this.jLabel6.setText("None");
//                this.jPanel6.setToggle(false);
//                
//        this.mainFram.refreshScreen();
//
//    }

//        public void addGoal(int x, int y) {
      
                    
//        Goal goal = newGoalInputs.getGoal(); 
        
//whene editing this to accept all types of elements  add a switch case in line 47 of the class Newgoal input and pass the name of the element to the method so you construct the right object
       
//    }

    public void modifyGoal(Element goal) {
        NewGoalInputs newGoalInputs = new NewGoalInputs(mainFram, true,goal,gsn);
      }
    public void deleteRelation(Relations rel){
         int result = JOptionPane.showConfirmDialog(null, "vouler vous supprimer cette relation?", "supprimer une relation", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {
                        builder.deleteRelation(rel);
                    }
    }
    public GSN getGsn() {
        return gsn;
    }
//    public void serialization() {
//        File file = new File("file.xml");
//        StringWriter sw = new StringWriter();
//        Marshaller marshaller;
//        try {
//            JAXBContext context = JAXBContext.newInstance(GSN.class, Goal.class, Strategy.class, Solution.class, Context.class, Justification.class, Assumption.class, InContextOf.class, SupportedBy.class);
//            marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(gsn, sw);
//            marshaller.marshal(gsn, file);
//            xmlString = sw.toString();
//            jTextPane1.setText("");
//            jTextPane1.setText(xmlString);
//         
//            
//        } catch (JAXBException ex) {
//            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//    void desiarilize(String gsnpath) {
//       File file = new File(gsnpath);
//        Unmarshaller unmarshaller;
//        try {
//            JAXBContext context = JAXBContext.newInstance(GSN.class, Goal.class, Strategy.class, Solution.class, Context.class, Justification.class, Assumption.class, InContextOf.class, SupportedBy.class);
//            unmarshaller = context.createUnmarshaller();
//             this.gsn = (GSN) unmarshaller.unmarshal(file);
//             this.jPanel6= new jpanel(this.gsn,this);
//            jTextPane1.setText("");
//            jTextPane1.setText(xmlString);
//            for(Element element:gsn.getElements()) {
//            	System.out.println("//////////////////////////////////////"+element.getID());
//            }
//            
//        } catch (JAXBException ex) {
//            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void deselectbtns(){
            this.Goal_Btn.setSelected(false);
            this.Solution_Btn.setSelected(false);
            this.Context_Btn.setSelected(false);
            this.Assumption_Btn.setSelected(false);
            this.Justification_btn.setSelected(false);
            this.SupportedBy_Btn.setSelected(false);
            this.InContextOf_Btn.setSelected(false);
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
        Context_Btn = new javax.swing.JToggleButton();
        Justification_btn = new javax.swing.JToggleButton();
        Assumption_Btn = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        SupportedBy_Btn = new javax.swing.JToggleButton();
        InContextOf_Btn = new javax.swing.JToggleButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        SaveXml_Btn = new javax.swing.JButton();
        Analyse_syntax = new javax.swing.JButton();
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

        Context_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        Context_Btn.setText("Context");
        Context_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Context_BtnActionPerformed(evt);
            }
        });

        Justification_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        Justification_btn.setText("Justification");
        Justification_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Justification_btnActionPerformed(evt);
            }
        });

        Assumption_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        Assumption_Btn.setText("Assumption");
        Assumption_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Assumption_BtnActionPerformed(evt);
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
                    .addComponent(Solution_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Context_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Justification_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Assumption_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Context_Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Assumption_Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Justification_btn))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel8.setBackground(new java.awt.Color(0, 0, 204));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Relations du GSN");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        SupportedBy_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        SupportedBy_Btn.setText("SupportedBy");
        SupportedBy_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupportedBy_BtnActionPerformed(evt);
            }
        });

        InContextOf_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/GoalIcon.png"))); // NOI18N
        InContextOf_Btn.setText("InContextOf");
        InContextOf_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InContextOf_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SupportedBy_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InContextOf_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupportedBy_Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InContextOf_Btn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Export.png"))); // NOI18N
        jButton1.setText("Exporter comme image");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar2.add(jButton1);

        SaveXml_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Save.png"))); // NOI18N
        SaveXml_Btn.setText("Enregistrer XML");
        SaveXml_Btn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SaveXml_Btn.setFocusable(false);
        SaveXml_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        SaveXml_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveXml_BtnActionPerformed(evt);
            }
        });
        jToolBar2.add(SaveXml_Btn);

        Analyse_syntax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressources/Verify.png"))); // NOI18N
        Analyse_syntax.setText("Analyse syntaxique");
        Analyse_syntax.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Analyse_syntax.setFocusable(false);
        Analyse_syntax.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Analyse_syntax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Analyse_syntaxActionPerformed(evt);
            }
        });
        jToolBar2.add(Analyse_syntax);

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
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("GSN-XML", new javax.swing.ImageIcon(getClass().getResource("/Ressources/XML.png")), jPanel5); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Goal_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Goal_BtnActionPerformed
                            if (this.Goal_Btn.isSelected()) {
                                //set all other Button to unselected   
                                deselectbtns();
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
// TODO : whene adding relation the add element could appear whene clicking must fix
        int x = evt.getX();
        int y = evt.getY();
        
        if(this.action!="None"){
  
        
//        addElement(x, y);
            builder.addElement(x, y);
        }else{
            jPanel6.formMouseClicked(evt);
        }
        
         
         
        
        
    
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
      jPanel6.formMousePressed(evt);
      
    }//GEN-LAST:event_jPanel6MousePressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
//          serialization();
        jTextPane1.setText("");
        jTextPane1.setText( fmanager.serialization(gsn));
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
           deselectbtns();
            this.action = "Strategy";
            this.jLabel6.setText("Adding a Strategy...");
            jPanel6.setToggle(true);
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
            }
    }//GEN-LAST:event_Strategy_BtnActionPerformed

    private void Solution_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Solution_BtnActionPerformed
   if (this.Solution_Btn.isSelected()) {
            //set all other Button to unselected 
            deselectbtns();
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

    private void Context_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Context_BtnActionPerformed
  if (this.Context_Btn.isSelected()) {
            //set all other Button to unselected 
            deselectbtns();
            this.action = "Context";
            this.jLabel6.setText("Adding a Context...");
            jPanel6.setToggle(true);
            System.out.print(jPanel6.isToggle());
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
            }    }//GEN-LAST:event_Context_BtnActionPerformed

    private void Justification_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Justification_btnActionPerformed
  if (this.Justification_btn.isSelected()) {
            //set all other Button to unselected 
            deselectbtns();
            this.action = "Justification";
            this.jLabel6.setText("Adding a Justification...");
            jPanel6.setToggle(true);
            System.out.print(jPanel6.isToggle());
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
            }    }//GEN-LAST:event_Justification_btnActionPerformed

    private void Assumption_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Assumption_BtnActionPerformed
  if (this.Assumption_Btn.isSelected()) {
            //set all other Button to unselected 
            deselectbtns();
            this.Goal_Btn.setSelected(false);
            this.action = "Assumption";
            this.jLabel6.setText("Adding a Assumption...");
            jPanel6.setToggle(true);
            System.out.print(jPanel6.isToggle());
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
            }    }//GEN-LAST:event_Assumption_BtnActionPerformed

    private void SupportedBy_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupportedBy_BtnActionPerformed
           if (this.SupportedBy_Btn.isSelected()) {
            deselectbtns();
            this.action = "Relation.support";
            this.jLabel6.setText("Adding a SupportBy Relation...");
            jPanel6.setToggle(true);
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
           }
    }//GEN-LAST:event_SupportedBy_BtnActionPerformed

    private void InContextOf_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InContextOf_BtnActionPerformed
         if (this.InContextOf_Btn.isSelected()) {
            deselectbtns();
            this.action = "Relation.context";
            this.jLabel6.setText("Adding an InContextOf Relation...");
            jPanel6.setToggle(true);
        } else {
            this.action = "None";
            this.jLabel6.setText("None...");
            jPanel6.setToggle(false);
           }
    }//GEN-LAST:event_InContextOf_BtnActionPerformed

    private void Analyse_syntaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Analyse_syntaxActionPerformed
        System.out.println("ANALYSE_Syntaxique");
        Analyse_Syntaxique analyseS = new Analyse_Syntaxique();
        try {
            analyseS.Analyse_General( gsn);
        } catch (Exception ex) {
            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Analyse_syntaxActionPerformed

    private void SaveXml_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveXml_BtnActionPerformed
        try {
            fmanager.SaveAsXml(gsn);
            JOptionPane.showConfirmDialog(null, "enregistré avec succès.", "Ficher Enregistrer", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveXml_BtnActionPerformed
    private void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {                                     
    	jPanel6.jPanel6MouseMoved( evt);
     }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Analyse_syntax;
    private javax.swing.JToggleButton Assumption_Btn;
    private javax.swing.JToggleButton Context_Btn;
    private javax.swing.JToggleButton Goal_Btn;
    private javax.swing.JToggleButton InContextOf_Btn;
    private javax.swing.JToggleButton Justification_btn;
    private javax.swing.JButton SaveXml_Btn;
    private javax.swing.JToggleButton Solution_Btn;
    private javax.swing.JToggleButton Strategy_Btn;
    private javax.swing.JToggleButton SupportedBy_Btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

    

    

    
}
