/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Mou nir
 */
public class Goal extends Element {
    
     
    
    public Goal(){
        
    }
  //supp constructeur avc x et y
    
     public Goal(String ID ,String descreption){
        this.ID=ID;
        this.descreption=descreption;
       
       
    }


//    protected void paintComponent(Graphics g) {
//      
//        
//        g.setColor(Color.RED);
//        g.setFont(new Font("Arial", Font.BOLD, 20));
//        
//        // Get the width and height of the text
//        int textWidth = g.getFontMetrics().stringWidth(descreption);
//        int textHeight = g.getFontMetrics().getHeight();
//        
//        // Calculate the position and size of the rectangle
//        int rectX = (140 - textWidth) / 2 - 10; // Subtracting 10 to give some padding
//        int rectY = (150 - textHeight) / 2 - 10;
//        int rectWidth = textWidth + 20;
//        int rectHeight = textHeight + 20;
//        
//        // Draw the rectangle
//        g.drawRect(rectX, rectY, rectWidth, rectHeight);
//        
//        // Draw the text
//        g.drawString(descreption, rectX + 10, rectY + textHeight);
//    }
    
    public String getcontent() {
        String content = ID + "\n\n" + descreption;
        return content;
    }
     public void draw(Graphics g){
         draw(g,X,Y,getcontent());
     }
    public  void draw(Graphics g,int X ,int Y,String content) {
        
         
               
               g.setFont(new Font("Arial", Font.BOLD, 16));
                 int textWidth=1 ;
                 int lineWidth;
                  int textHeight = g.getFontMetrics().getHeight();

                g.setColor(Color.BLACK);
                for (String line : content.split("\n")) {
                    
                g.drawString(line, X+ 10, Y+ textHeight);
                    textHeight += g.getFontMetrics().getHeight();
                    lineWidth = g.getFontMetrics().stringWidth(line);
                    if(textWidth<lineWidth){
                        textWidth=lineWidth;
                    }
                }
                  g.drawRect(X, Y,textWidth+15,textHeight-10);
                  
                 
                    
                    width=textWidth;
                    height=textHeight;
    }
    
    


    
 
    
}
