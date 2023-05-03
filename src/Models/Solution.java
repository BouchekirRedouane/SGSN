/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Mou nir
 */
public class Solution extends Element {
    

    public Solution(){
        
    }
  //supp constructeur avc x et y
    
     public Solution(String ID ,String descreption){
        this.ID=ID;
        this.descreption=descreption;
       
       
    }


    @Override
    public boolean contains(int x, int y) {
          // Calculate the coordinates of the corners of the object's bounding box
    int x1 = this.X-width/2;
    int y1 = this.Y-height/2;
    int x2 = this.X + this.width/2+15;
    int y2 = this.Y + this.height/2+10;
    
     System.out.println(this.X+":x   Solution    y:"+this.Y+"\n");

    
    System.out.print("Solution pressed");
     
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

         draw(g,X,Y,getcontent());
     }
     
     public void calcule(Graphics g){
         System.out.print("hello world");
     }
    public  void draw(Graphics g,int X ,int Y,String content) {
                double mou3amil = sqrt(2);
                String id="";
               
                g.setFont(new Font("Arial", Font.BOLD, 16));
                 int textWidth=0;
                 int minTW= (int) pow(5,100);
                  int textHeight = g.getFontMetrics().getHeight();
                  
                int delimiterIndex = content.indexOf("\n\n");
//  decouper le content en id et descreption
                if (delimiterIndex != -1) {
                     id = content.substring(0, delimiterIndex);
                     content = content.substring(delimiterIndex + 2);
                    
                }
//  compter le width et le height de descreption entree par letulisateur
                for (String line : content.split("\n")) {   
            
                    textHeight += g.getFontMetrics().getHeight();
                    int lineWidth = g.getFontMetrics().stringWidth(line);
                    if(textWidth<lineWidth){
                        textWidth=lineWidth;
                       
                    }
                    if(minTW>lineWidth){
                        minTW=lineWidth;
                        
                    }
                }
                
//  donner une valeur initial a finalTW --> le final width de descreption / le width de carre qu'om va ecrire in
                int finalTW=textHeight+(textWidth-textHeight)/2;
//  compter la valeur final de finalTW                
                while(textHeight*3/2<finalTW && minTW*3/2<finalTW ){
//                while(textHeight+20<finalTW ){
                    System.out.println(textHeight+":H////while loop///W:"+finalTW);
                   finalTW=textHeight+(finalTW-textHeight)/2;  
                   textHeight += g.getFontMetrics().getHeight();
                   System.out.println(textHeight+":H///////W:"+finalTW);
                }
                
                 height=(int) (finalTW*mou3amil);
                 width=height;
                
                    
// buttonX,buttonY sont pour que la souris sera au centre de preview
                int buttonX=(int) (X-finalTW*sqrt(2)/2);
                int buttonY=(int) (Y-finalTW*sqrt(2)/2);
//                this.X= buttonX;
//                this.Y=buttonY;

//word X une variable pour controller le                 
                int wordX=0;
                int wordY=0;
                
              
                
                textHeight = g.getFontMetrics().getHeight();
                int  buttonYf=(int) (buttonY+((finalTW*sqrt(2)-finalTW)/2));
                int  buttonXf=(int) (buttonX+((finalTW*sqrt(2)-finalTW)/2));
                g.setColor(Color.BLUE);
                g.drawRect(buttonXf, buttonYf,finalTW,finalTW);
                g.setColor(Color.BLACK);
                for (String line : content.split("\n")) {
                    wordX= 0;
                    wordY += g.getFontMetrics().getHeight();
                    buttonYf+=g.getFontMetrics().getHeight();
                        
                for (String word : line.split(" ")) {
                         word=word+" ";
                    if(wordX+ g.getFontMetrics().stringWidth(word)<finalTW){
                        g.drawString(word, buttonXf+wordX, buttonYf);
                        wordX += g.getFontMetrics().stringWidth(word);
                    }else{
                        wordX=0;
                        wordY += g.getFontMetrics().getHeight();
                        buttonYf+=g.getFontMetrics().getHeight();
                        g.drawString(word, buttonXf+wordX, buttonYf);
                        wordX += g.getFontMetrics().stringWidth(word);
                    }
                    
                }}
                
                
                g.drawString(id, buttonX+ (int) (finalTW*mou3amil)/2- g.getFontMetrics().stringWidth(id)/2,buttonY+g.getFontMetrics().getHeight() );
                
                g.drawOval(buttonX, buttonY, (int) (finalTW*mou3amil),(int) (finalTW*mou3amil));
                g.setColor(Color.RED);
                g.drawRect(buttonX, buttonY,(int) (finalTW*mou3amil),(int) (finalTW*mou3amil));
                
               
                  
                 
                
                
                  

    }
    
    


    
 
    
}

