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
public class Strategy extends Element{
   int diagonal=15;
    public Strategy(){
        
    }
  //supp constructeur avc x et y
    
     public Strategy(String ID ,String descreption){
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

                g.setColor(Color.BLACK);
                int i=2;
                int j =1;
                for (String line : content.split("\n")) {
                    
                g.drawString(line, X+i*10, Y+ textHeight+j*10);i=diagonal/7;j=0;System.out.print(j);
                    textHeight += g.getFontMetrics().getHeight();
                    lineWidth = g.getFontMetrics().stringWidth(line);
                    if(textWidth<lineWidth){
                        textWidth=lineWidth;
                    }
                }
                g.drawLine(X,Y,X+textWidth+diagonal,Y);
                g.drawLine(X+textWidth+diagonal,Y,X+textWidth+diagonal+diagonal, Y+textHeight);
                g.drawLine(X+textWidth+diagonal+diagonal, Y+textHeight,X+diagonal, Y+textHeight);
                g.drawLine(X+diagonal, Y+textHeight,X,Y);
                
//                parallelogram.addPoint(X, Y);  // top-left
//                parallelogram.addPoint(X+textWidth+60,Y );  // top-right
//                parallelogram.addPoint(X+textWidth+60+60, Y+textHeight);  // bottom-left
//                parallelogram.addPoint(X+60, Y+textHeight);  // bottom-right
                  
//                g.drawPolygon(parallelogram);
                  
                 
                    
                    width=textWidth;
                    height=textHeight;
    }
    
}
