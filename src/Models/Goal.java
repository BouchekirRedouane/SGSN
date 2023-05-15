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
                 if(this.Hover){
                     g.setColor(Color.RED);
                 }else{
                 g.setColor(Color.BLACK);
                 }
                for (String line : content.split("\n")) {
                    textHeight += g.getFontMetrics().getHeight();
                    lineWidth = g.getFontMetrics().stringWidth(line);
                    if(textWidth<lineWidth){
                        textWidth=lineWidth;
                    }
                }
                
                
                
                int Xc=X-textWidth/2;
                int Yc=Y-textHeight/2;
                Color goalcolor = new Color(218, 232, 252);
                g.setColor(goalcolor);
                 g.fillRect(Xc, Yc,textWidth+15,textHeight-10);
                 g.setColor(Color.BLACK);
                textHeight = g.getFontMetrics().getHeight();
                
                for (String line : content.split("\n")) {
                    
                	g.drawString(line, Xc+ 10, Yc+ textHeight);
                    textHeight += g.getFontMetrics().getHeight();
                }
                  g.drawRect(Xc, Yc,textWidth+15,textHeight-10);
                  
                 
                    
                    width=textWidth;
                    height=textHeight;
    }

   
    
    


    
 
    
}
