/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

/**
 *
 * @author Mou nir
 */

import Models.Element;
import Models.GSN;
import Models.Goal;
import Models.Strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public  class Analyse_Syntaxique {
    private List<String> errors;
    private List<String> warnings;
    private GSN gsn;

    public Analyse_Syntaxique() {
        this.errors = new ArrayList<>();
        this.warnings = new ArrayList<>();

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
    }
    
     public  void Verify(GSN gsn){
         boolean isValid=true;
         
         //verify that only one top goal exists
          ArrayList<Element> topGoals = new ArrayList<Element>();
        for (Element element : gsn.getElements()) {
            if (element instanceof Goal && gsn.getParent(element).isEmpty()) {
                topGoals.add(element);
            }
        }
        if (topGoals.size() != 1) {
            errors.add("Each GSN diagram should have a single top-level goal.");
            isValid = false;
        }
        
        
        
        //checks id of elemnet
         HashSet<String> ids = new HashSet<String>();
        for (Element element : gsn.getElements()) {
            if (!ids.add(element.getID())) {
                errors.add("Each element in the diagram should have a unique identifier.");
                isValid = false;
            }
            if (!element.getID().matches("[G|S|C|Sn|A|J]\\d+")) {
                errors.add(element.getID()+" The element must have a character from “G-S-Sn-A-J…” and a number.");
                isValid = false;
            }
        }
        
        
        
        
        //checks relations
         HashSet<Element> goalsAndStrategies = new HashSet<Element>();
        HashSet<Element> otherElements = new HashSet<Element>();
        for (Element element : gsn.getElements()) {
            if (element instanceof Goal || element instanceof Strategy) {
                goalsAndStrategies.add(element);
            } else {
                otherElements.add(element);
            }
        }

        for (Element element : goalsAndStrategies) {
            if (gsn.getChilds(element).isEmpty()) {
                errors.add("Goal-strategy should be related to at least one other element.");
                isValid = false;
            }
        }

        for (Element element : otherElements) {
            if (gsn.getChilds(element).isEmpty() && gsn.getParent(element).isEmpty()) {
                errors.add("Assumption-justification-solution-context should be related to one other element.");
                isValid = false;
            }
        }
        
        
        errors.forEach(err -> System.out.println(err));
//         return isValid;
         
         
         
     }
    

    public static void checkDiagram(GSN gsn) throws Exception {
        ArrayList<Element> topGoals = new ArrayList<Element>();
        for (Element element : gsn.getElements()) {
            if (element instanceof Goal && gsn.getParent(element).isEmpty()) {
                topGoals.add(element);
            }
        }
        if (topGoals.size() != 1) {
            throw new Exception("Each GSN diagram should have a single top-level goal.");
        }
    }

    public static void checkElementIDs(GSN gsn) throws Exception {
        HashSet<String> ids = new HashSet<String>();
        for (Element element : gsn.getElements()) {
            if (!ids.add(element.getID())) {
                throw new Exception("Each element in the diagram should have a unique identifier.");
            }
            if (!element.getID().matches("[G|S|C|Sn|A|J]\\d+")) {
                throw new Exception(element.getID()+"The element must have a character from “G-S-Sn-A-J…” and a number.");
            }
        }
    }

    public static void checkElementRelations(GSN gsn) throws Exception {
        HashSet<Element> goalsAndStrategies = new HashSet<Element>();
        HashSet<Element> otherElements = new HashSet<Element>();
        for (Element element : gsn.getElements()) {
            if (element instanceof Goal || element instanceof Strategy) {
                goalsAndStrategies.add(element);
            } else {
                otherElements.add(element);
            }
        }

        for (Element element : goalsAndStrategies) {
            if (gsn.getChilds(element).isEmpty()) {
                throw new Exception("Goal-strategy should be related to at least one other element.");
            }
        }

        for (Element element : otherElements) {
            if (gsn.getChilds(element).isEmpty() && gsn.getParent(element).isEmpty()) {
                throw new Exception("Assumption-justification-solution-context should be related to one other element.");
            }
        }
    }

    public static void checkElementIDOrder(GSN gsn) throws Exception {
        ArrayList<String> ids = new ArrayList<String>();
        for (Element element : gsn.getElements()) {
            ids.add(element.getID());
        }
//            ArrayList<String> sortedIds = new ArrayList<String>(ids);
//            Collections.sort(sortedIds);
//            if (!ids.equals(sortedIds)) {
//                throw new Exception("The id numbers should be ordered “1-2-3-4…etc”.");
//            }
    }
}

