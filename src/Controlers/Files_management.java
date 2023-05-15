/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import java.io.File;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Models.Assumption;
import Models.Context;
import Models.Element;
import Models.GSN;
import Models.Goal;
import Models.Justification;
import Models.Solution;
import Models.Strategy;
import Models.Relation.InContextOf;
import Models.Relation.SupportedBy;
import Views.GsnPannel;
import Views.MainFram;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.basic.BasicFileChooserUI;

/**
 *
 * @author Mou nir
 */
public class Files_management {
        private GsnPannel pannel;
        private MainFram mainf;
	private GSN gsn;
	String xmlString;
        String path;
        
	public Files_management(MainFram mainf) {
		this.mainf=mainf;
	}
        public GSN createNewGSN(String name, String path){
            GSN gsnt =new GSN(name,path);
            return gsnt;
        }
        public void SaveAsXml(GSN gsn) throws IOException{
            File file = new File(gsn.getPath());
            FileWriter fw = new FileWriter(file,false);
            fw.write( serialization(gsn)); 
            fw.close();
        }
        public String serialization(GSN gsn) {
	        File file = new File("file.xml");
	        StringWriter sw = new StringWriter();
	        Marshaller marshaller;
	        try {
	            JAXBContext context = JAXBContext.newInstance(GSN.class, Goal.class, Strategy.class, Solution.class, Context.class, Justification.class, Assumption.class, InContextOf.class, SupportedBy.class);
	            marshaller = context.createMarshaller();
	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            marshaller.marshal(gsn, sw);
	            marshaller.marshal(gsn, file);
	            xmlString = sw.toString();
                    return xmlString;
//	            pannel.getjTextPane1().setText("");
//	            pannel.getjTextPane1().setText(xmlString);
	         
	            
	        } catch (JAXBException ex) {
	            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
	        }
            return null;
	        
	    }
        public GSN desiarilize(String gsnpath) {
	       File file = new File(gsnpath);
	        Unmarshaller unmarshaller;
	        try {
	            JAXBContext context = JAXBContext.newInstance(GSN.class, Goal.class, Strategy.class, Solution.class, Context.class, Justification.class, Assumption.class, InContextOf.class, SupportedBy.class);
	            unmarshaller = context.createUnmarshaller();
	             this.gsn = (GSN) unmarshaller.unmarshal(file);
	          
//	            jTextPane1.setText("");
//	            jTextPane1.setText(xmlString);
	            for(Element element:gsn.getElements()) {
	            	System.out.println("//////////////////////////////////////"+element.getID());
	            }
	            
	            
	        } catch (JAXBException ex) {
	            Logger.getLogger(GsnPannel.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return gsn;
	    }
      
        public void importGSN(){
//                 this.fileChooser();
//                 GSN gsn = desiarilize(path);
                 String path =fileChooser(2);
                 if(path!= null){
                 GSN gsn = desiarilize(path);
                 GsnPannel g = new GsnPannel(mainf, gsn);
                 mainf.getjTabbedPane2().addTab("GSN: "+ gsn.getName(), g);
                 mainf.getjTabbedPane2().setIconAt(mainf.getjTabbedPane2().getTabCount()-1, new javax.swing.ImageIcon(getClass().getResource("/Ressources/GsnDiagram.png")));
                 mainf.setI(mainf.getI()+1);
                 }
        }
      //for creat gsn  

        public static String fileChooser(String fileName) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("GSN Files", "GSN");
            fileChooser.setFileFilter(filter);
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            

            int returnVal = fileChooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();

                File file = new File(selectedDirectory, fileName + ".GSN");

                if (file.exists()) {
                    int result = JOptionPane.showConfirmDialog(null, "The file already exists. Do you want to replace it?", "Replace File", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {
                        file.delete();
                    } else {
                        /*return;*/
                    }
                }
                 try {
                if (file.createNewFile()) {
                    return file.getAbsolutePath();
                } else {
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
//            System.out.println(file.getAbsolutePath());
//
//            return file.getAbsolutePath();
//        }
//        return null;
    }

        
    public static String fileChooser(int choice) {
        JFileChooser fileChooser = new JFileChooser();
        if (choice == 2) {
            
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("GSN Files", "GSN"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            
//            fileChooser.setControlButtonsAreShown(false); // Hide the "Open" and "Cancel" buttons
            
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (selectedFile.exists()) {
                    return selectedFile.getPath();
                } else {
                	 JOptionPane.showConfirmDialog(null, "The file you entered does not exist", "File does not exist", JOptionPane.PLAIN_MESSAGE);
                	 
                    return  fileChooser(choice); // File does not exist
                }
            } else {
                return null; // User canceled the file selection
            }

//            // Choose an XML file
//            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("XML Files", "xml"));
//            int returnValue = fileChooser.showOpenDialog(null);
//            if (returnValue == JFileChooser.APPROVE_OPTION) {
//                File selectedFile = fileChooser.getSelectedFile();
//                return selectedFile.getPath();

            

        } else if (choice == 3) {
            // Choose a directory or image file
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getPath();

                if (selectedFile.isDirectory()) {
                    String fileName = selectedFile.getName();

                    if (fileName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "The chosen directory cannot have an empty file name.",
                                "Invalid File Name", JOptionPane.WARNING_MESSAGE);
                        return null;
                    }

                    if (selectedFile.exists()) {
                        int response = JOptionPane.showConfirmDialog(null,
                                "The chosen directory already exists. Do you want to replace it?", "File Already Exists",
                                JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            return filePath;
                        } else {
                            return null;
                        }
                    }
                } else if (filePath.toLowerCase().endsWith(".jpg") || filePath.toLowerCase().endsWith(".jpeg") || filePath.toLowerCase().endsWith(".png")) {
                    int response = JOptionPane.showConfirmDialog(null,
                            "The chosen image file already exists. Do you want to replace it?", "Replace File",
                            JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        return filePath;
                    } else {
                        return null;
                    }
                }
            }
        }

        return null;
    }
        
        
        
//        public void fileChooser()
//        {
//        JFileChooser fileChooser = new JFileChooser(); // create a file chooser
//        int result = fileChooser.showOpenDialog(null); // show the dialog and get the result
//        if (result == JFileChooser.APPROVE_OPTION) { // if the user selected a file
//           File selectedFile = fileChooser.getSelectedFile(); // get the selected file
//           this.path=selectedFile.getAbsolutePath();
//        } 
//        }
        
        
        
        
        
//          private static File fileChooser(boolean export) {
//              
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        if(export){
//            
//        }else if(!export)
//            
//                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
//                fileChooser.setFileFilter(filter);
//
//               int returnValue = fileChooser.showOpenDialog(null);
//               if (returnValue == JFileChooser.APPROVE_OPTION) {
//                   File selectedFile = fileChooser.getSelectedFile();
//                   String filePath = selectedFile.getAbsolutePath();
//                   if (!filePath.toLowerCase().endsWith(".xml")) {
//                       filePath += ".xml";
//                       selectedFile = new File(filePath);
//                   }
//                   if (selectedFile.exists()) {
//                       int overwrite = JOptionPane.showConfirmDialog(null,
//                               "The file already exists. Do you want to replace it?",
//                               "File Exists", JOptionPane.YES_NO_OPTION);
//                       if (overwrite == JOptionPane.YES_OPTION) {
//                           return selectedFile;
//                       } else {
//                           return null;
//                       }
//                   } else {
//                       return selectedFile;
//                   }
//               } else {
//                   return null;
//               }
//    }
//        
        
}
