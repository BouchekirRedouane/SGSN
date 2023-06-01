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
public class Context extends Element {
    
    int th ;

    public Context() {
    }
    
     
  //supp constructeur avc x et y
    
     public Context(String ID ,String descreption){
        this.ID=ID;
        this.descreption=descreption;
       
       
    }


      @Override
    public boolean contains(int x, int y) {
          // Calculate the coordinates of the corners of the object's bounding box
    int x1 = this.X-width/2;
    int y1 = this.Y-height/2;
    int x2 = this.X + this.width/2+th;
    int y2 = this.Y + this.height/2;
    

    //x1,y1 are the top left corner
     
    // Check if the specified point is inside the bounding box
    if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
            System.out.println(this.X+":x   Context    y:"+this.Y+"\n");
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
    public  void draw(Graphics g,int X ,int Y,String content) {
        
         
                              g.setFont(new Font("Arial", Font.BOLD, 13));
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
                    
                     th =textHeight;
                     width=textWidth+textHeight;
                     height=textHeight;
                     
                }
                
                 int buttonxc = X-textWidth/2-textHeight/2;
                    int buttonyc = Y-textHeight/2;
                     g.setColor(new Color(225, 213, 231));
                      g.fillRoundRect(buttonxc, buttonyc, textWidth+textHeight, textHeight, textHeight, textHeight);
                     g.setColor(new Color(150, 115, 166));
                     g.drawRoundRect(buttonxc, buttonyc, textWidth+textHeight, textHeight, textHeight, textHeight);
                    g.setColor( Color.BLACK);

                    textHeight = g.getFontMetrics().getHeight();
                for (String line : content.split("\n")) {
                  g.drawString(line, buttonxc+th/2, buttonyc+ textHeight);
                  textHeight += g.getFontMetrics().getHeight();

                
                }
                 
                 
                 
    }
    
    
}
