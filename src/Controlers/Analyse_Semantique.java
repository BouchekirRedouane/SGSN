/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Models.Element;
import Models.GSN;
import Models.Relation.InContextOf;
import Models.Relation.Relations;
import Models.Relation.SupportedBy;
import Models.Solution;
import Views.AnalyseSemantique;
import Views.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Compiler.command;
import java.util.List;

import parser.Values;
import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismFileLog;
import prism.PrismLog;
import prism.Result;
import prism.UndefinedConstants;


//import prism.util.PrismLoader;
/**
 *
 * @author Mou nir
 */
public class Analyse_Semantique {
    GSN gsn;
String Logg;
    public Analyse_Semantique(GSN gsn) {
        this.gsn = gsn;
    }
    
  
         
//       public void checkPrism()  {
//    MDPModel model = new MDPModel();
//    PrismLoader.loadModel("path/to/mdp.prism");
//    
//    Property property = new Property("P=? [F \"goal\"]");
//    
//    Prism prism = new Prism();
//    prism.setEngineType(Prism.EXPLICIT);
//    prism.setProperties(property);
//    
//    ModelChecker modelChecker = prism.getModelChecker();
//    Result result = modelChecker.check(model);
//    
//    boolean isSatisfied = result.isResultOK();
//    double probability = result.getResult();
//}
       public  Boolean checkPrism() throws PrismException, FileNotFoundException, InterruptedException, IOException  {
            File model = new File("PrismModel/model.pm");
            File proprety = new File("PrismModel/property.pctl");
            String Prism = System.getenv("Prism");
//                        System.out.println(Prism);
            Prism = Prism.replace("\\", "\\\\");
//                        System.out.println(Prism);

                
        
        if (model != null &&proprety!=null) {
            String modelpath = model.getAbsolutePath().replace("\\", "\\\\");;
            String Ppath = proprety.getAbsolutePath().replace("\\", "\\\\");;
            
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "cd "+"\""+Prism+"\""+" && prism "+"\""+modelpath+"\"  "+"\""+Ppath+"\"");
            processBuilder.redirectErrorStream(true); // Merge error stream with the standard output
            
            Process process = processBuilder.start();
            int exitCode = process.waitFor(); // Wait for the commands to finish
            
            // You can also read the output of the command if needed
             InputStream inputStream = process.getInputStream();
             BufferedReader reader =    new BufferedReader(new InputStreamReader(inputStream));
             String line,d="",h="";
             String Log="";
             while ((line = reader.readLine()) != null) {
                 System.out.println(line);
                 Log=Log+"\n"+line;
                 h=d;
                 d=line;
             }
             this.Logg=Log;
             
             
             
             
             
             if (h.contains("true")){
                 return true;
             }if(h.contains("false")){
                 return false;
             }else{
                 return false;
             }
       
 
        }
           return false;
       }
       

    
public   void AfficheLog() {
    new Log(Logg);
}
public  String  generateMDP() {
         ArrayList<Element> states =gsn.getElements();
         ArrayList<Relations> actions=gsn.getRelations();
         StringBuilder mdpCode = new StringBuilder();

        // MDP declaration
        mdpCode.append("mdp\n\n");

        // Single module declaration
        mdpCode.append("module M\n\n");

        // State variable declaration
        mdpCode.append("\tstate : [");
        mdpCode.append("0.."+(states.size()-1));
       
        mdpCode.append("] init 0");
//        mdpCode.append(states.get(0).getID());
//        mdpCode.append(states.get(0).getID());
        mdpCode.append(";\n\n");

        // Transitions for each action
        for (Relations action : actions) {
            
             
              if (action instanceof InContextOf) {
                  mdpCode.append("//\t[");
                mdpCode.append("inContextOf");
            } else if (action instanceof SupportedBy) {
                mdpCode.append("\t[");
                mdpCode.append("supportedBy");
            }
               mdpCode.append("]");
            mdpCode.append("state=");
            mdpCode.append(states.indexOf(action.getSource()));
//            mdpCode.append(action.getSource().getID());
            mdpCode.append(" -> 1 : (state'=");
//            mdpCode.append("s");
            mdpCode.append(states.indexOf(action.getTarget()));
            mdpCode.append(")");

         

            mdpCode.append(";\n");
        }
         for (Element state : states){
              if(state instanceof Solution){
                mdpCode.append("\t[");
                mdpCode.append("Solution");
               mdpCode.append("]");
            mdpCode.append("state=");
            mdpCode.append(states.indexOf(state));
//            mdpCode.append(action.getSource().getID());
            mdpCode.append(" -> 1 : (state'=");
//            mdpCode.append("s");
            mdpCode.append(states.indexOf(state));
            mdpCode.append(")");
            
            mdpCode.append(";\n");
              }
          }

        // Closing module and end of MDP declaration
        mdpCode.append("\nendmodule");
         mdpCode.append("\n");
         mdpCode.append("\n");

         
             mdpCode.append("label ");
               mdpCode.append("\"Solution\"=");
         for (Element state : states){
         if(state instanceof Solution){           
             mdpCode.append(" state=");
             mdpCode.append(states.indexOf(state));
             mdpCode.append(" | ");
         }
         }
         mdpCode.deleteCharAt(mdpCode.length() - 2);
         mdpCode.append(";\n");
         for (Element state : states){
             mdpCode.append("label ");
             mdpCode.append("\""+state.getID()+"\"");
             mdpCode.append("= state=");
             mdpCode.append(states.indexOf(state));
             mdpCode.append(";\n");
         }
//                 System.out.println(mdpCode.toString());

           try (PrintWriter writer = new PrintWriter(new FileWriter("PrismModel/model.pm"))) {
            writer.println(mdpCode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mdpCode.toString();
         // Print the generated MDP code
    }

//}
//  
}

//    
//    
//    
//    
////    
//    
//}
