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
import Views.Dialogs.NewGoalInputs;
import Views.GsnPannel;
import Views.MainFram;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GSN_Builder {

                            private GSN gsn;
                           private GsnPannel pannel;
                          private  MainFram mainFram;

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
//                SupportRelationWarning supportRelationWarning =new SupportRelationWarning(mainFram,false);
//                supportRelationWarning.setVisible(true);
            }    
            }else if(pannel.getAction()=="Relation.context"){
                if(source==target){
                
                }else if( InContextOf.canBeSource(source) && InContextOf.canBeTarget(target)){
                
                    Relations currentRelation = new InContextOf(source,target);
                    gsn.addRelationn(currentRelation);
                    System.out.println("added the context realtion");
                    pannel.setAction("None");
                }else{
//                    ContextRelationWarning contextRelationWarning =new ContextRelationWarning(mainFram,false);
//                    contextRelationWarning.setVisible(true);
                }
                    
                
            }
    }
    public void deleteRelation(Relations relation) {
        gsn.deletRelation(relation);
    }
    public void deleteElement(Element element) {
            gsn.deletElement(element);
            
    }
    public void modifyElement(Element element,String ID,String Desc) {
        element.setID(ID);
        element.setDescreption(Desc);
       
        
    }
    public void modifyElement(Element element,String ID,String Desc,boolean undev) {
        element.setID(ID);
        element.setDescreption(Desc);
        element.setunDevelloped(undev);
        
    }
    public void modifyElement(Element element,String ID,String Desc,String Link1,String Link2) {
        element.setID(ID);
        element.setDescreption(Desc);
        element.setLink1(Link1);
        element.setLink2(Link2);
        
    }
    public Element CreateElement(String ID,String Desc , String Type){
              switch (Type) {
                  case "Context" -> {Context context = new Context(ID,Desc);return context;}
                  case "Justification" -> {Justification justification = new Justification(ID,Desc);return justification;}
                  case "Assumption" -> {Assumption assumption = new Assumption(ID,Desc);return assumption;}
           }
              return null;
    }
    public Element CreateElement(String ID,String Desc , Boolean undev,String Type){
              switch (Type) {
                  case "Goal" -> {Goal goal = new Goal(ID,Desc,undev);return goal;}
                  case "Strategy" -> {Strategy strategy = new Strategy(ID,Desc,undev);return strategy;}
           }
              return null;
    }
    public Element CreateElement(String ID,String Desc , String Link1,String Link2){
              Solution solution = new Solution(ID,Desc);
              solution.setLink1(Link1);
              solution.setLink2(Link2);
              return solution;
    }
    //pour la creation
    public boolean CheckInput(String ID,String Desc,String type){
        ArrayList<Element> elmnts = gsn.getElements();
        
        if(ID.equals("") || Desc.equals(""))
        {
            JOptionPane.showConfirmDialog(null, "erreur Nom ou chemin vide.","Erreur.", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Error name or path empty");
            return false;
        }
     
        if(type!="Solution" &&(ID.charAt(0) != type.charAt(0)|| !ID.matches(type.charAt(0)+"\\d+"))){
            JOptionPane.showConfirmDialog(null, "l'ID d'un "+type+"doit commancer par"+type.charAt(0), "ID error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }else if(type=="Solution" && !ID.matches("Sn\\d+")){
            JOptionPane.showConfirmDialog(null, "l'ID d'une "+type+" doit commancer par Sn", "ID error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        //modify because like this it is always returning false (if you didnt edit the id of the element)
            for(Element elmnt : elmnts){
                if(ID.equals(elmnt.getID())){
                    JOptionPane.showConfirmDialog(null, "L'ID doit être unique.","Erreur d'ID.", JOptionPane.PLAIN_MESSAGE);
                    return false;
                }
            }
        
        return true;
    }
    //pour la modification
    public boolean CheckInput(Element e,String ID,String Desc){
        ArrayList<Element> elmnts = gsn.getElements();
        String type = e.getClass().getSimpleName();
        
        if(ID.equals("") || Desc.equals(""))
        {
            JOptionPane.showConfirmDialog(null, "erreur Nom ou chemin vide.","Erreur.", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Error name or path empty");
            return false;
        }
        
         if(e instanceof Solution && !ID.matches("Sn\\d+")){
            System.out.print("bouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuucle");
            JOptionPane.showConfirmDialog(null, "l'ID d'une Solution doit commancer par Sn", "ID error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }else if(!type.equals("Solution") &&(ID.charAt(0) != type.charAt(0) || !ID.matches(type.charAt(0)+"\\d+"))){
               System.out.println(type);
               System.out.println("bouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuucle22222222222222222222222222222222222222");
               
            JOptionPane.showConfirmDialog(null, "l'ID d'un ::"+type+" doit commancer par un "+type.charAt(0), "ID error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        
            for(Element elmnt : elmnts){
                if(ID.equals(elmnt.getID()  )&& elmnt!=e){
                    JOptionPane.showConfirmDialog(null, "L'ID doit être unique.","Erreur d'ID.", JOptionPane.PLAIN_MESSAGE);
                    return false;
                }
            }
        
        return true;
    }
}
