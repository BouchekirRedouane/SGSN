package Controlers;

import Models.Assumption;
import Models.Context;
import Models.Element;
import Models.GSN;
import Models.Goal;
import Models.Justification;
import Models.Relation.InContextOf;
import Models.Relation.Relations;
import Models.Relation.SupportedBy;
import Models.Solution;
import Models.Strategy;
import Views.GsnPannel;
import Views.jpanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;

public class GSN_Renderer {
    
       private GSN gsn;
       private GsnPannel pannel;
    
    
//      private ArrayList<Element> Elementss ;
//      private ArrayList<Relations> Relations ;
    
       
       
       
       
       private String buttonTextG = "G1\n\n Goal description goes here";
       private String buttonTextS = "S1\n\n Strategy description goes here";
       private String buttonTextSn = "Sn1\n\n Solution description goes here";
       private String buttonTextC = "C1\n\n Context description goes here";
       private String buttonTextJ = "J1\n\n Justification description goes here";
       private String buttonTextA = "A1\n\n Assumption description goes here";
       
//        private Goal goal = new Goal();
        private Strategy strategy = new Strategy();
        private Solution solution = new Solution("Sn22",buttonTextSn);
        private Context context = new Context();
        private Justification justification = new Justification("Sn22",buttonTextJ);
        private Assumption assumption = new Assumption("Sn22",buttonTextA);
        private InContextOf contextof = new InContextOf();
        private SupportedBy supportedBy = new SupportedBy();

    public GSN_Renderer(GsnPannel pannel) {
        this.pannel = pannel;
        this.gsn=pannel.getGsn();
        
        
    }
public void renderPreview(Graphics g,int mouseX,int mouseY ,int mousePressX ,int mousePressY ){
     switch (pannel.getAction()) {
                case "Relation.support" -> {
                    if(pannel.getjPanel6().isPress()){
//                        System.out.println("switch case draw entred");
                        g.setColor(Color.LIGHT_GRAY);
                        supportedBy.drawArrowLine(g, mousePressX, mousePressY, mouseX, mouseY, 10, 5);
//                        g.drawLine(mousePressX, mousePressY, mouseX, mouseY);
                    }
                }
                case "Relation.context" -> {
                    if(pannel.getjPanel6().isPress()){
                        g.setColor(Color.LIGHT_GRAY);
                        contextof.drawArrowLine(g, mousePressX, mousePressY, mouseX, mouseY, 10, 5);

                        g.drawLine(mousePressX, mousePressY, mouseX, mouseY);
                    }
                }
                case "Goal" -> {
//                    System.out.print("\n Switch case worcked ");
                    new Goal().draw(g,mouseX,mouseY,buttonTextG);
                }
                case "Strategy" -> {
                    //                     System.out.print("\n Switch case worcked for strategy ");
                    
                    strategy.draw(g,mouseX,mouseY,buttonTextS);
                }
                case "Solution" -> {
                    //                     System.out.print("\n Switch case worcked for strategy ");
                   
                    solution.calcule_dimentions(g);
                    solution.draw(g,mouseX,mouseY,buttonTextSn);
                }
                case "Context" -> {
                    //                     System.out.print("\n Switch case worcked for Context ");
                    
                    context.draw(g,mouseX,mouseY,buttonTextC);
                }
                case "Justification" -> {
                    //                     System.out.print("\n Switch case worcked for strategy ");
                   
                    justification.draw(g,mouseX,mouseY,buttonTextJ);
                }
                case "Assumption" -> {
                    //                     System.out.print("\n Switch case worcked for strategy ");
                    
                    assumption.draw(g,mouseX,mouseY,buttonTextA);
                }

            }
    
}
public void renderComponents(Graphics g){
        ArrayList<Relations>  Relations = gsn.getRelations();
	    if(Relations!=null)    
	        for (int i = 0; i < Relations.size(); i++) {
	             Relations relations = Relations.get(i);
	             relations.draw(g);
	             
	        }
        ArrayList<Element> Elementss = gsn.getElements();
        if(Elementss!=null) 
        	for (int i = 0; i < Elementss.size(); i++) {
	             Element element = Elementss.get(i);
	             element.draw(g);
//                     if(element instanceof Solution ){
//                        if( !element.getLink1().equals("")){
//                            JButton button=new JButton("Attachement 1");
//                            ((Solution) element).setButton1(button);
//                        }
//                        if( !element.getLink2().equals("")){
//                            JButton button=new JButton("Attachement 2");
//                            ((Solution) element).setButton1(button);
//                        }
//                            
//                    
//                  }
	             
	        }
}
}
