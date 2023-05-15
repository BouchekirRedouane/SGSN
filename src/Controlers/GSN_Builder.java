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
import Views.Dialogs.ContextRelationWarning;
import Views.Dialogs.NewGoalInputs;
import Views.Dialogs.SupportRelationWarning;
import Views.GsnPannel;
import Views.MainFram;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GSN_Builder {

	GSN gsn;
        GsnPannel pannel;
        MainFram mainFram;

    public GSN_Builder(GSN gsn, GsnPannel pannel, MainFram mainFram) {
        this.gsn = gsn;
        this.pannel = pannel;
        this.mainFram = mainFram;
    }
   

    public GSN_Builder(GSN gsn) {
        this.gsn = gsn;
    }
    
    public void addElement(int x, int y) {
//		   NewGoalInputs newGoalInputs = new NewGoalInputs(mainFram, true,pannel);java.awt.Frame parent, boolean modal,GsnPannel pannel
		   NewGoalInputs newGoalInputs = new NewGoalInputs(mainFram,true, this );
		         switch (pannel.getAction()) {
		             case "Goal" -> {
		                 Goal goal = newGoalInputs.getGoal();
		                 if(goal != null){
		                     goal.setX(x);
		                     goal.setY(y);
		                     gsn.addElementt(goal);
		                 }
		             }
		             case "Strategy" -> {
                                 Strategy strategy = newGoalInputs.getStrategy(); 
		                 if(strategy != null){
		                     strategy.setX(x);
		                     strategy.setY(y);
		                     gsn.addElementt(strategy);
		                 }
		             }
		             case "Solution" -> {
		                 Solution solution = newGoalInputs.getSolution();
		                 
		                 if(solution != null){
		                     solution.setX(x);
		                     solution.setY(y);
		                     gsn.addElementt(solution);
		                 }
		             }
		             case "Context" -> {
		                 Context context = newGoalInputs.getContext();
		                 
		                 if(context != null){
		                     context.setX(x);
		                     context.setY(y);
		                     gsn.addElementt(context);
		                 }
		             }
		             case "Justification" -> {
		                 Justification justification = newGoalInputs.getJustification();
		                 
		                 if(justification != null){
		                     justification.setX(x);
		                     justification.setY(y);
		                     gsn.addElementt(justification);
		                 }
		             }
		             case "Assumption" -> {
		                 Assumption assumption = newGoalInputs.getAssumption();
		                 
		                 if(assumption != null){
		                     assumption.setX(x);
		                     assumption.setY(y);
		                     gsn.addElementt(assumption);
		                 }
		             }    
		         }
		                 pannel.deselectbtns();
		                 pannel.setAction("None");
		                 
		                 
		         this.mainFram.refreshScreen();

		     }
    public void addRelation(Element source ,Element target ) {
        if(pannel.getAction()=="Relation.support"){
            if(source==target){
                
            }else if(SupportedBy.canBeSourceAndTarget(source,target) ){
                Relations currentRelation = new SupportedBy(source,target);
                gsn.addRelationn(currentRelation);     
                currentRelation=null;
                pannel.setAction("None");
            }else{
                SupportRelationWarning supportRelationWarning =new SupportRelationWarning(mainFram,false);
                supportRelationWarning.setVisible(true);
            }    
            }else if(pannel.getAction()=="Relation.context"){
                if(source==target){
                
                }else if( InContextOf.canBeSource(source) && InContextOf.canBeTarget(target)){
                
                    Relations currentRelation = new InContextOf(source,target);
                    gsn.addRelationn(currentRelation);
                    System.out.println("added the context realtion");
                    pannel.setAction("None");
                }else{
                    ContextRelationWarning contextRelationWarning =new ContextRelationWarning(mainFram,false);
                    contextRelationWarning.setVisible(true);
                }
                    
                
            }
    }
    
    public void deleteRelation(Element element) {
    }
    public void deleteElement(Element element) {
            gsn.deletElement(element);
            
    }

    public void modifyElement(Element element,String ID,String Desc) {
        element.setID(ID);
        element.setDescreption(Desc);
        
    }
//    public Element CreateElement(Element element){
//        
//    }
    public boolean CheckInput(String ID,String Desc){
        ArrayList<Element> elmnts = gsn.getElements();
        if(ID.equals("") || Desc.equals(""))
        {
            JOptionPane.showConfirmDialog(null, "Error name or path empty", "error", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Error name or path empty");
            return false;
        }
        if(!ID.matches("[G|S|C|Sn|A|J]\\d+")){
            JOptionPane.showConfirmDialog(null, "ID should Contain G/S/C/Sn/A/J and a number", "ID error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        for(Element elmnt : elmnts){
            if(ID.equals(elmnt.getID())){
                JOptionPane.showConfirmDialog(null, "ID should be unique", "ID error", JOptionPane.PLAIN_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
}
