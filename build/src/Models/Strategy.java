/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mou nir
 */
public class Strategy extends Element{
//    private boolean unDevelloped;
    @XmlElement(name = "Undevelloped")
    public boolean unDevelloped;
  @XmlTransient
    int diagonal=15;
  @XmlTransient
   int Xc,Yc;
    public Strategy(){
        
    }
  //supp constructeur avc x et y
    
     public Strategy(String ID ,String descreption){
        this.ID=ID;
        this.descreption=descreption;
    }
     public Strategy(String ID ,String descreption,boolean undev){
        this.ID=ID;
        this.descreption=descreption;
        this.unDevelloped=undev;
    }

      @Override
    public boolean isunDevelloped() {
            return unDevelloped;
    }

     @Override
    public void setunDevelloped(boolean unDevelloped) {
        this.unDevelloped=unDevelloped;
        
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
                int i=2;
                int j =1;
                
                for (String line : content.split("\n")) {
                    
//                g.drawString(line, X+i*10, Y+ textHeight+j*10);i=diagonal/7;j=0;System.out.print(j);
                    textHeight += g.getFontMetrics().getHeight();
                    lineWidth = g.getFontMetrics().stringWidth(line);
                    if(textWidth<lineWidth){
                        textWidth=lineWidth;
                    }
                }
                    
                     Xc=X-textWidth/2;
                     Yc=Y-textHeight/2;
                    
                     
                          int[] xPoints={Xc,Xc+textWidth+diagonal,Xc+textWidth+2*diagonal,Xc+diagonal};
                          int[] yPoints={Yc,Yc,Yc+textHeight,Yc+textHeight};
//                          g.setColor(Color.WHITE);
                           Color color = new Color(213, 232, 212);
                             g.setColor(color);
                          g.fillPolygon(xPoints,yPoints,4);
                          
                          g.setColor(Color.BLACK);
                          
                          g.drawLine(Xc,Yc,Xc+textWidth+diagonal,Yc);  //
                          g.drawLine(Xc+textWidth+diagonal,Yc,Xc+textWidth+diagonal+diagonal, Yc+textHeight);
                          g.drawLine(Xc+textWidth+diagonal+diagonal, Yc+textHeight,Xc+diagonal, Yc+textHeight);
                          g.drawLine(Xc+diagonal, Yc+textHeight,Xc,Yc);
                          
                        
                          
                     
                    textHeight = g.getFontMetrics().getHeight();
                    
                
//               
                for (String line : content.split("\n")) {
                        
                        g.drawString(line, Xc+15, Yc+ textHeight);
                      
                       
                            textHeight += g.getFontMetrics().getHeight();
                           
                        }
//                g.drawLine(Xc,Yc,Xc+textWidth+diagonal,Yc);  //line ta3 lfo9
//                g.drawLine(Xc+textWidth+diagonal,Yc,Xc+textWidth+diagonal+diagonal, Yc+textHeight); //line ta3 adroit
//                g.drawLine(Xc+textWidth+diagonal+diagonal, Yc+textHeight,Xc+diagonal, Yc+textHeight);//line ta3 ta7t
//                g.drawLine(Xc+diagonal, Yc+textHeight,Xc,Yc); //line ta3 gauche
                 
                    if (this.unDevelloped){
                      int[] xPointss={Xc+textWidth/2,Xc+textWidth/2+10,Xc+textWidth/2,Xc+textWidth/2-10};
                      int[] yPointss={Yc+textHeight,Yc+textHeight+10,Yc+textHeight+20,Yc+textHeight+10};
                      g.fillPolygon(xPointss, yPointss, 4);
                  }
                    width=textWidth;
                    height=textHeight;
    }
    
}
