/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

/**
 *
 * @author Mou nir
 */

import Models.*;
import Models.Relation.*;
import Views.AnalyseSyntaxique;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class Analyse_Syntaxique {
    private List<String> errors;
    private List<String> errorss;
    private List<String> warnings;
    private GSN gsn;
    
   

    public Analyse_Syntaxique() {
        this.errors = new ArrayList<>();
        this.errorss = new ArrayList<>();
        this.warnings = new ArrayList<>();

    }
    public Analyse_Syntaxique(GSN gsn) {
        this.errors = new ArrayList<>();
        this.errorss = new ArrayList<>();
        this.warnings = new ArrayList<>();
        Verify(gsn);
        //modify jtable
        AnalyseSyntaxique an =new AnalyseSyntaxique(errorss);

    }
   
    

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }
    
    public  void Analyse_General(GSN gsn) {
//        checkDiagram(gsn);
//        checkElementIDs(gsn);
//        checkElementRelations(gsn);
//        checkElementIDOrder(gsn);
        
        Verify(gsn);
        //modify jtable
        AnalyseSyntaxique an =new AnalyseSyntaxique(errorss);
    }
    
     public  void Verify(GSN gsn){
         boolean isValid=true;
            ArrayList<Relations> relations = gsn.getRelations();
        ArrayList<Element> Elements = gsn.getElements();
         
         //verify that only one top goal exists
         //E01
          //E06
          ArrayList<Element> topGoals = new ArrayList<Element>();
        for (Element element : gsn.getElements()) {
            if (element instanceof Goal && gsn.getParent(element).isEmpty()) {
                topGoals.add(element);
            }
        }
        //E01
        if (topGoals.size() != 1) {
            errors.add("Each GSN diagram should have a single top-level goal.");
            errorss.add("E01");
            isValid = false;
        }else if  (topGoals.size()==1){
         //E06////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                HashMap<Object, List<Object>> graph = new HashMap<>();

        // Build the graph
        for (Relations relation : relations) {
            if (!graph.containsKey(relation.getSource()))
                graph.put(relation.getSource(), new ArrayList<>());
                graph.get(relation.getSource()).add(relation.getTarget());
        }
        
        // Perform BFS traversal
        Queue<Object> queue = new LinkedList<>();
        HashSet<Object> visited = new HashSet<>();

        queue.offer(topGoals.get(0));
        visited.add(topGoals.get(0));

        while (!queue.isEmpty()) {
            Object currentObject = queue.poll();

            if (graph.containsKey(currentObject)) {
                List<Object> targets = graph.get(currentObject);

                for (Object target : targets) {
                    if (!visited.contains(target)) {
                        queue.offer(target);
                        visited.add(target);
                    }
                }
            }
        }

        // Check if all objects are reachable
        for (Element object : Elements) {
            if (!visited.contains(object)) {
               errors.add("All elements must be reachable from the root elements");
            errorss.add("E06");
            }
        }
            
        }
        //E06 END////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        //checks id of elemnet
        //E10
        //E09
        //E05
        //E07
        
         HashSet<String> ids = new HashSet<String>();
        for (Element element : gsn.getElements()) {
                    String type = element.getClass().getSimpleName();
                    //E10
            if (!ids.add(element.getID())) {
                errors.add("Each element in the diagram should have a unique identifier.");
                errorss.add("E10");
                isValid = false;
            }
            //E09
            if (!element.getID().matches("[G|S|C|A|J]\\d+") && !element.getID().matches("Sn\\d+")) {
                errors.add(element.getID()+" The element must have a character from “G-S-Sn-A-J…” and a number.");
                errorss.add("E09");
                isValid = false;
            }
            //E05
                if(element instanceof Solution){
                    if (!element.getID().matches("Sn\\d+")){
                        errors.add("l'ID d'un "+type+" doit commancer par un Sn");//            return false;
                        errorss.add("E05");
                    }
                }else if(type!="Solution" &&(element.getID().charAt(0) != type.charAt(0)|| !element.getID().matches(type.charAt(0)+"\\d+"))){
                errors.add("l'ID d'un "+type+" doit commancer par un "+type.charAt(0));//            return false;
                errorss.add("E05");
                }
             //E07
            if(element instanceof Solution && element.getLink1().equals("")&& element.getLink2().equals("")){
                  errors.add("Goal-strategy should be related to at least one other element OR be marked as undevelloped.");
                errorss.add("E07");
            }
            }
        //
        
        
        
        
        //checks relations
        HashSet<Element> goalsAndStrategies = new HashSet<Element>();
        HashSet<Element> otherElements = new HashSet<Element>();
        ArrayList<Integer> Goalss = new ArrayList<>();
        ArrayList<Integer> Strategiess = new ArrayList<>();
        ArrayList<Integer> Solutionss = new ArrayList<>();
        ArrayList<Integer> Contextss = new ArrayList<>();
        ArrayList<Integer> Justificationss = new ArrayList<>();
        ArrayList<Integer> Assumptionss = new ArrayList<>();
        
        
        for (Element element : gsn.getElements()) {
            if (element instanceof Goal ) {
                goalsAndStrategies.add(element);
//                Goalss.add(element.getID().parseInt(replaceAll("[^\\d]", "")));
                Goalss.add(Integer.parseInt(element.getID().replaceAll("\\D", "")));
            } else if(element instanceof Strategy){
                 goalsAndStrategies.add(element);
                 Strategiess.add(Integer.parseInt(element.getID().replaceAll("\\D", "")));
            } else if(element instanceof Solution){
                  otherElements.add(element);
                  Solutionss.add(Integer.parseInt(element.getID().replaceAll("\\D", "")));
            } else if(element instanceof Context){
                  otherElements.add(element);
                  Contextss.add(Integer.parseInt(element.getID().replaceAll("\\D", "")));
            } else if(element instanceof Assumption){
                  otherElements.add(element);
                  Assumptionss.add(Integer.parseInt(element.getID().replaceAll("\\D", "")));
            } else if(element instanceof Justification){
                  otherElements.add(element);
                  Justificationss.add(Integer.parseInt(element.getID().replaceAll("\\D", "")));
            }
        }
        
        //E04
        chekOrdred(Goalss);
        chekOrdred(Strategiess);
        chekOrdred(Solutionss);
        chekOrdred(Contextss);
        chekOrdred(Assumptionss);
        chekOrdred(Justificationss);
        
     
        
        //E02
        //E08
        //R01
        for (Element element : goalsAndStrategies) {
            if (gsn.getChilds(element).isEmpty() && !element.isunDevelloped()) {
                errors.add("Goal-strategy should be related to at least one other element OR be marked as undevelloped.");
                errorss.add("E02");
                isValid = false;
            }
              if (element.isunDevelloped() && !gsn.getChilds(element).isEmpty()) {
                errors.add("Goals and Strategies marked as undeveloped, must have no supporting arguments.");
                errorss.add("E08");
                isValid = false;
            }
            ArrayList<Element> childs = gsn.getChilds(element);
            for(Element e :childs){
                if(gsn.getChilds(e).contains(element)){
                    errors.add("There must be no circular supportedBy references.");
                    errorss.add("R01");
                    isValid = false;
                }
            }
        }
        
       
        
        //R02
        //R03
        //R04
        //R05
        //R06
        //R07
        //R08
        //R09
        for (Relations relation :relations){
            //R02
            if(relation.getSource()==relation.getTarget()){
                errors.add(" All referenced elements in supportedBy and inContextOf must not refer to the element itself.");
                errorss.add("R02");
            }
            //R05
            if(relation.getSource() instanceof Strategy&& !(relation.getTarget() instanceof Goal 
                        || relation.getTarget() instanceof Context 
                        || relation.getTarget() instanceof Justification 
                        || relation.getTarget() instanceof Assumption)){
                        errors.add("Error : Strategy can not be directly  related to a solution");
                    errorss.add("R05");
                
            }
            //R06
            if(relation.getSource() instanceof Solution && !(relation.getTarget() instanceof Goal)){
                        errors.add("Error : Solution can  only be directly related to goal ");
                    errorss.add("R06");
                
            }
            //R07
            if(relation.getSource() instanceof Context&& !(relation.getTarget() instanceof Goal 
                        || relation.getTarget() instanceof Strategy )){
                        errors.add("Error : Context can only be directly  related to a goal/strategy");
                    errorss.add("R07");
                
            }
            //R08
            if(relation.getSource() instanceof Assumption&& !(relation.getTarget() instanceof Goal 
                        || relation.getTarget() instanceof Strategy )){
                        errors.add("Error : Assumption can only be directly  related to a goal/strategy");
                    errorss.add("R08");
                
            }
            //R09
            if(relation.getSource() instanceof Justification && !(relation.getTarget() instanceof Goal 
                        || relation.getTarget() instanceof Strategy )){
                        errors.add("Error : Justification can only be directly  related to a goal/strategy");
                    errorss.add("R09");
                
            }
            
            if(relation instanceof SupportedBy ){
                if (!((relation.getSource() instanceof Goal 
                        &&(relation.getTarget() instanceof Goal 
                        || relation.getTarget() instanceof Strategy 
                        || relation.getTarget() instanceof Solution)
                        )
                        ||(relation.getSource() instanceof Strategy 
                        && relation.getTarget() instanceof Goal)
                        )){
                    errors.add("SupportedBy Must only be Goal -> strategy or goal or solution , Or  strategy ->  goal");
                    errorss.add("R03");
                    isValid=false;

            }else if(relation instanceof InContextOf ){
                 if (!((relation.getSource() instanceof Goal 
                        || relation.getSource() instanceof Strategy )
                        &&(relation.getTarget() instanceof Context 
                        || relation.getTarget() instanceof Justification 
                        || relation.getTarget() instanceof Assumption)
                        )){
                     errors.add("InContextOf Must only be from “Goal - Strategy” --> “Assumption-Context-Justification”" );
                     errorss.add("R04");
                    isValid=false;
                 }
            }

                    }
        }
        
        //E03
        for (Element element : otherElements) {
            if (gsn.getChilds(element).isEmpty() && gsn.getParent(element).isEmpty()) {
                errors.add("Assumption-justification-solution-context should be related to one other element.");
                isValid = false;
            }
        }
        
       

        
//    
        
        
        
        errors.forEach(err -> System.out.println(err));
//         return isValid;
         
         
         
     }
    
//
    public  void chekOrdred( ArrayList<Integer> ids)  {
           Collections.sort(ids);
       if (!ids.isEmpty() && ids.size() > 0) {
            // Check if the ID numbers form a consecutive sequence
                      
                int expectedID = ids.get(0);
                for (int i = 1; i < ids.size(); i++) {
                    int currentID = ids.get(i);
                    if (currentID - expectedID != 1) {
                        errors.add("Goal-strategy should be related to at least one other element OR be marked as undevelloped.");
                        errorss.add("E04");
                    }
                    expectedID = currentID;
                }
               
           }
        
    }
    }
//        }
//        if (topGoals.size() != 1) {
//            throw new Exception("Each GSN diagram should have a single top-level goal.");
//        }
//    }
//
//    public static void checkElementIDs(GSN gsn) throws Exception {
//        HashSet<String> ids = new HashSet<String>();
//        for (Element element : gsn.getElements()) {
//            if (!ids.add(element.getID())) {
//                throw new Exception("Each element in the diagram should have a unique identifier.");
//            }
//            if (!element.getID().matches("[G|S|C|Sn|A|J]\\d+")) {
//                throw new Exception(element.getID()+"The element must have a character from “G-S-Sn-A-J…” and a number.");
//            }
//        }
//    }
//
//    public static void checkElementRelations(GSN gsn) throws Exception {
//        HashSet<Element> goalsAndStrategies = new HashSet<Element>();
//        HashSet<Element> otherElements = new HashSet<Element>();
//        for (Element element : gsn.getElements()) {
//            if (element instanceof Goal || element instanceof Strategy) {
//                goalsAndStrategies.add(element);
//            } else {
//                otherElements.add(element);
//            }
//        }
//
//        for (Element element : goalsAndStrategies) {
//            if (gsn.getChilds(element).isEmpty()) {
//                throw new Exception("Goal-strategy should be related to at least one other element.");
//            }
//        }
//
//        for (Element element : otherElements) {
//            if (gsn.getChilds(element).isEmpty() && gsn.getParent(element).isEmpty()) {
//                throw new Exception("Assumption-justification-solution-context should be related to one other element.");
//            }
//        }
//    }
//
//    public static void checkElementIDOrder(GSN gsn) throws Exception {
//        ArrayList<String> ids = new ArrayList<String>();
//        for (Element element : gsn.getElements()) {
//            ids.add(element.getID());
//        }
////            ArrayList<String> sortedIds = new ArrayList<String>(ids);
////            Collections.sort(sortedIds);
////            if (!ids.equals(sortedIds)) {
////                throw new Exception("The id numbers should be ordered “1-2-3-4…etc”.");
////            }
//    }


