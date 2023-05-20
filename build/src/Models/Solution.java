/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mou nir
 */
public class Solution extends Element {
    @XmlTransient
    private int finalTW;
    @XmlTransient
    private int textHeight;
    @XmlTransient
    private int Fontheight;
   

  
     
     
     
    
     @XmlElement(name = "Link1")
    private String Link1;
    
     @XmlElement(name = "Link2")
    private String Link2;
    @Override
    public String getLink1() {
        return Link1;
    }
    @Override
    public void setLink1(String Link1) {
        this.Link1 = Link1;
    }
    @Override
    public String getLink2() {
                

        return Link2;
    }
    @Override
    public void setLink2(String Link2) {
        this.Link2 = Link2;
    }
    
    
    

    public Solution(){
        
    }
  //supp constructeur avc x et y
    
     public Solution(String ID ,String descreption){
        this.ID=ID;
        this.descreption=descreption;
    }

public boolean containsLink1(int x, int y) throws URISyntaxException{
//  g.drawRect(X+10, Yattachement+30, g.getFontMetrics().stringWidth("Attachement1")+10, g.getFontMetrics().getHeight()*2);
   int Yattachement=Y+(int) (finalTW*sqrt(2)/2);
    int x1 = this.X+10;
    int y1 = Yattachement+30;
    int x2 = this.X+96 ;//+  g.getFontMetrics().stringWidth("Attachement1")+10;
    int y2 = Yattachement+30+34;//+ g.getFontMetrics().getHeight()*2;
     
    // Check if the specified point is inside the bounding box
    if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
       System.out.println("ATTACHEMENT1 CLICKED");
       openAttachment(this.Link1);
        return true;
        
    } else {
        return false;
    }
}
public boolean containsLink2(int x, int y) throws URISyntaxException{
     int Yattachement=Y+(int) (finalTW*sqrt(2)/2);
//     g.drawRect(X-15-g.getFontMetrics().stringWidth("Attachement2"), Yattachement+30, g.getFontMetrics().stringWidth("Attachement2")+10, g.getFontMetrics().getHeight()*2);
    int x1 = this.X-15-96;
    int y1 =Yattachement+30;
    int x2 = this.X -5;
    int y2 =Yattachement+30+34;
     
    // Check if the specified point is inside the bounding box
    if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
       System.out.println("ATTACHEMENT2 CLICKED");
       openAttachment(this.Link2);
        return true;
        
    } else {
        return false;
    }
}
@Override 
public boolean contains(int x, int y) {
          // Calculate the coordinates of the corners of the object's bounding box
    int x1 = this.X-width/2;
    int y1 = this.Y-height/2;
    int x2 = this.X + this.width/2+15;
    int y2 = this.Y + this.height/2+10;
    
    
     
    // Check if the specified point is inside the bounding box
    if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
        return true;
        
    } else {
        return false;
    }
}
public String getcontent() {
        String content = ID + "\n\n" + descreption;
        return content;
    }
public void draw(Graphics g){
         
        calcule_dimentions(g);
         draw(g,X,Y,getcontent());
     }
public void calcule_dimentions(Graphics g){
         g.setFont(new Font("Arial", Font.BOLD, 16));
                 int textWidth=0;
                 int maxww=0;
                 int minTW= (int) pow(5,100);
                  int Fontheight = g.getFontMetrics().getHeight();
                  int textHeight= Fontheight;
                  
                  //  compter le width et le height de descreption entree par letulisateur
                String[] lines = descreption.split("\n");
//                System.out.println("nbr of lines is :"+ lines.length);
                if(lines.length == 1){
                    textWidth= g.getFontMetrics().stringWidth(lines[0]);
                     textHeight = Fontheight;
                     for (String word : descreption.split(" ")){                           
                         int wordWidth = g.getFontMetrics().stringWidth(word);
                         if(maxww<5/4*wordWidth){
                            maxww=5/4*wordWidth;
                            System.out.println(word);
                        }
                         
                    
                     }
                }else{
                    for (int i = 0; i < lines.length; i++) {
    //                for (String line : content.split("\n")) {

                        textHeight += Fontheight;
                        int lineWidth = g.getFontMetrics().stringWidth(lines[i]);

                        if(textWidth<lineWidth){
                            textWidth=lineWidth;  
                        }
                        if(minTW>lineWidth){
                            minTW=lineWidth;
                            System.out.println(lines[i]);

                        }
                    }
                }
                
//  donner une valeur initial a finalTW --> le final width de descreption / le width de carre qu'om va ecrire in
                 finalTW=textHeight+(textWidth-textHeight)/2;
//  compter la valeur final de finalTW                
                while(textHeight*3/2<finalTW &&( minTW<finalTW || maxww*4/3<finalTW) ){
                    System.out.println(textHeight+":H////while loop///W:"+finalTW);
                   finalTW=textHeight+(finalTW-textHeight)/2;  
                   textHeight += Fontheight;
//                   System.out.println(textHeight+":H///////W:"+finalTW);
                }
                 this.textHeight=textHeight;
                 this.finalTW=finalTW;
                 this.Fontheight=Fontheight;
                 
                 height=(int) (finalTW*sqrt(2));
                 width=height;
                
         
     }
public  void draw(Graphics g,int X ,int Y,String content) {
                double mou3amil = sqrt(2);
                String id="";
                int firstline=1;
                
                if(finalTW<70)
                    finalTW=70;
                
                
//                System.out.println("finalTW is :"+ finalTW);
//                System.out.println("textHeight is :"+ textHeight);
//                System.out.println("Fontheight is :"+ Fontheight);
               
                
                  
                int delimiterIndex = content.indexOf("\n\n");
//  decouper le content en id et descreption
                if (delimiterIndex != -1) {
                     id = content.substring(0, delimiterIndex);
                     content = content.substring(delimiterIndex + 2);
                    
                }

                    
// buttonX,buttonY sont pour que la souris sera au centre de preview
                int buttonX=(int) (X-finalTW*sqrt(2)/2);
                int buttonY=(int) (Y-finalTW*sqrt(2)/2);
//                int buttonX=(int) (X-finalTW/2);
//                int buttonY=(int) (Y-finalTW/2);
//                this.X= buttonX;
//                this.Y=buttonY;

//word X une variable pour controller le                 
                int wordX=0;
                int wordY=0;
                
             
                
                textHeight = Fontheight;
                
                 int buttonYf=(int) (Y-finalTW/2+Fontheight);
                int  buttonXf=(int)(X-finalTW/2);
//                g.setColor(Color.WHITE);
//                g.drawRect(buttonXf, buttonYf,finalTW,finalTW);
                Color color = new Color(248, 206, 204);
                g.setColor(color);
                g.fillOval(buttonX, buttonY, (int) (finalTW*mou3amil),(int) (finalTW*mou3amil));
                 if(this.Hover){
                     g.setColor(Color.RED);
                 }else{
                 g.setColor(Color.BLACK);
                 }
                
                for (String line : content.split("\n")) {
                    wordX= 0;
                    wordY += Fontheight;
                    buttonYf+=Fontheight;
                        
                for (String word : line.split(" ")) {
                         word=word+" ";
                    if(wordX+ g.getFontMetrics().stringWidth(word)<finalTW){
                        g.drawString(word, buttonXf+wordX, buttonYf);
                        wordX += g.getFontMetrics().stringWidth(word);
                    }else{
                        wordX=0;
                        wordY += Fontheight;
                        buttonYf+=Fontheight;
                        g.drawString(word, buttonXf+wordX, buttonYf);
                        wordX += g.getFontMetrics().stringWidth(word);
                    }
                    
                }}
                
                int halfWdthPoint=buttonX+ (int) (finalTW*mou3amil)/2- g.getFontMetrics().stringWidth(id)/2;
                 
                g.drawString(id, halfWdthPoint,buttonY+Fontheight );
                
                g.drawOval(buttonX, buttonY, (int) (finalTW*mou3amil),(int) (finalTW*mou3amil));
                g.setColor(Color.RED);
//                g.drawOval(X-5, Y+ (int) (finalTW*mou3amil/2), 10,10);
                
                 int Yattachement=Y+(int) (finalTW*mou3amil/2);
                g.setColor(Color.BLACK);
                if( Link1 !=null  && !Link1.equals("")  ){
                   g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.drawLine(X+25, Yattachement-5, X+(g.getFontMetrics().stringWidth("Attachement1")+20)/2,Yattachement+30);
//                    g.drawLine(X+25, Yattachement-5,X+25,Yattachement+30);
                    g.drawRect(X+10, Yattachement+30, g.getFontMetrics().stringWidth("Attachement1")+10, g.getFontMetrics().getHeight()*2);
                    g.drawString("Attachement1", X+15, Yattachement+30+g.getFontMetrics().getHeight());
             
                }                               
                    if( Link2 != null && !Link2.equals("")   ){
                    g.drawLine(X-20 , Yattachement-5,X-(g.getFontMetrics().stringWidth("Attachement1")+20)/2,Yattachement+30);
                    g.drawRect(X-15-g.getFontMetrics().stringWidth("Attachement2"), Yattachement+30, g.getFontMetrics().stringWidth("Attachement2")+10, g.getFontMetrics().getHeight()*2);
//                     g.drawRect(X-20, Yattachement+30, -(g.getFontMetrics().stringWidth("Attachement2")+10), g.getFontMetrics().getHeight()*2);
                    g.drawString("Attachement2", X-15-g.getFontMetrics().stringWidth("Attachement2")+5, Yattachement+30+g.getFontMetrics().getHeight());
//                    g.drawString("Attachement1", X+20, Yattachement+=g.getFontMetrics().getHeight());
                   

//                    g.drawRect(X+20, Yattachement, width, height);
                    
                    
              
                
                
                
                
               
                
//                g.drawRect(buttonX, buttonY,(int) (finalTW*mou3amil),(int) (finalTW*mou3amil));
                
               
                  
                 
                
                
                  
                    }
    } 
public static void openAttachment(String attachment) throws URISyntaxException {
        // Check if the string is a file path
        File file = new File(attachment);
        if (file.exists()) {
//            openFile(file);
                try {
                Desktop.getDesktop().open(file);
                  } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error opening file!", "Error", JOptionPane.ERROR_MESSAGE);
                 }
                return;
        }

        // Check if the string is a website link
        String urlRegex = "^(https?|ftp)://.*$";
        if (attachment.matches(urlRegex)) {
//            openURL(attachment);
             if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(attachment));
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error opening URL!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
         }
            return;
        }

        // Display an error message
        JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
    }
 private static void openFile(File file) {
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error opening file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   


    
 
    
}

