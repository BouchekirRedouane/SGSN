/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Mou nir
 */
public class Goal extends Element {
//    private boolean unDevelloped;
     @XmlElement(name = "Undevelloped")
    public boolean unDevelloped;
    
    public Goal(){
        
    }
     @Override
    public boolean isunDevelloped() {
            return unDevelloped;
    }

     @Override
    public void setunDevelloped(boolean unDevelloped) {
        this.unDevelloped=unDevelloped;
        
    }
  //supp constructeur avc x et y
    
     public Goal(String ID ,String descreption){
        this.ID=ID;
        this.descreption=descreption;
       
       
    }
     public Goal(String ID ,String descreption,boolean undev){
        this.ID=ID;
        this.descreption=descreption;
        this.unDevelloped=undev;
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
                 
                for (String line : content.split("\n")) {
                    textHeight += g.getFontMetrics().getHeight();
                    lineWidth = g.getFontMetrics().stringWidth(line);
                    if(textWidth<lineWidth){
                        textWidth=lineWidth;
                    }
                }
                
                
                
                int Xc=X-(textWidth+15)/2;
                int Yc=Y-(textHeight-10)/2;
                
                g.setColor(new Color(218, 232, 252));
                 g.fillRect(Xc, Yc,textWidth+15,textHeight-10);
                 g.setColor(new Color(108, 142, 191));
                    g.drawRect(Xc, Yc,textWidth+15,textHeight-10);
                    
                    width=textWidth+15;
                    height=textHeight-10;
                 if(this.Hover){
                     g.setColor(Color.RED);
                 }else{
                 g.setColor(Color.BLACK);
                 }
                textHeight = g.getFontMetrics().getHeight();
                
                for (String line : content.split("\n")) {
                    
                	g.drawString(line, Xc+ 10, Yc+ textHeight);
                    textHeight += g.getFontMetrics().getHeight();
                }
               
                  textWidth+=15;
                  textHeight-=g.getFontMetrics().getHeight()/2;
                  if (this.unDevelloped){
                      int[] xPoints={Xc+textWidth/2,Xc+textWidth/2+10,Xc+textWidth/2,Xc+textWidth/2-10};
                      int[] yPoints={Yc+textHeight,Yc+textHeight+10,Yc+textHeight+20,Yc+textHeight+10};
                      g.fillPolygon(xPoints, yPoints, 4);
                  }
                  
                 
                    
                    
    }

   
    
    


    
 
    
}
