/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Relation;

import Models.Element;
import Models.Goal;
import Models.Strategy;
import Models.Assumption;
import Models.Justification;
import Models.Context;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mou nir
 */

public class InContextOf extends Relations {

    public InContextOf(Element source,Element target) {
        this.source=source;
        this.target=target;
    }

    public InContextOf() {
    }
    
    

    public static boolean canBeTarget (Element target) {
         if (target instanceof Context || target instanceof Assumption || target instanceof Justification){
            return true;
        }else{
        return false;
         }
    }

    public static boolean canBeSource(Element source) {
        if (source instanceof Goal || source instanceof Strategy){
            return true;
        }else{
        return false;
        }
    }
 

//  
//     public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
//            if(this.hover){
//                     g.setColor(Color.RED);
//                 }else{
//                 g.setColor(Color.BLACK);
//                 }
//            int dx = (x2 - x1)/2, dy = (y2 - y1)/2;
//            double D = Math.sqrt(dx*dx + dy*dy);
//            double xm = D - d, xn = xm, ym = h, yn = -h, x;
//            double sin = dy / D, cos = dx / D;
//
//            x = xm*cos - ym*sin + x1;
//            ym = xm*sin + ym*cos + y1;
//            xm = x;
//
//            x = xn*cos - yn*sin + x1;
//            yn = xn*sin + yn*cos + y1;
//            xn = x;
//            
//            int x3=x1+dx;
//            int y3=y1+dy;
//             
//                int[] xpoints = {x3, (int) xm, (int) xn};
//                int[] ypoints = {y3, (int) ym, (int) yn};
//            
////            int[] xpoints = {x2, (int) xm, (int) xn};
////            int[] ypoints = {y2, (int) ym, (int) yn};
//
//            g.drawLine(x1, y1, x2, y2);
//            g.drawPolygon(xpoints, ypoints, 3);
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        if(this.target!=null ||this.source!=null)
//            drawArrowLine( g, source.getX(), source.getY(), target.getX(), target.getY(), 20, 15);
//    }
     
     public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
    int dx = x2 - x1, dy = y2 - y1;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - d, xn = xm, ym = h, yn = -h, x;
    double sin = dy / D, cos = dx / D;

    x = xm*cos - ym*sin + x1;
    ym = xm*sin + ym*cos + y1;
    xm = x;

    x = xn*cos - yn*sin + x1;
    yn = xn*sin + yn*cos + y1;
    xn = x;

    int[] xpoints = {x2, (int) xm, (int) xn};
    int[] ypoints = {y2, (int) ym, (int) yn};

    g.drawLine(x1, y1, x2, y2);
    g.drawPolygon(xpoints, ypoints, 3);
}
    @Override
    public void draw(Graphics g) {
                  if(this.hover){
                     g.setColor(Color.RED);
                 }else{
                 g.setColor(Color.BLACK);
                 }
                  
        if(this.target!= null && this.target!= null ){
            if(source.getY()+50+source.getHeight()/2 > target.getY()-target.getHeight()/2 && source.getY()-50-source.getHeight()/2 < target.getY()+target.getHeight()/2 ){
                if(source.getX()<target.getX()){
                     drawArrowLine( g, source.getX(), source.getY(), target.getX()-target.getWidth()/2, target.getY(), 10,7 );
                     this.xtarget=target.getX()-target.getWidth()/2;
                     this.ytarget=target.getY();
                }else{
                    drawArrowLine( g, source.getX(), source.getY(), target.getX()+target.getWidth()/2, target.getY(), 10,7 );
                     this.xtarget= target.getX()+target.getWidth()/2;
                     this.ytarget=target.getY();
                }
            }else if( source.getY()<target.getY()){
                drawArrowLine( g, source.getX(), source.getY(), target.getX(), target.getY()-target.getHeight()/2, 10,7);
                 this.xtarget=target.getX();
                     this.ytarget=target.getY()-target.getHeight()/2;
            }else if(source.getY()>target.getY()){
                drawArrowLine( g, source.getX(), source.getY(), target.getX(), target.getY()+target.getHeight()/2, 10,7);
                 this.xtarget= target.getX();
                     this.ytarget=target.getY()+target.getHeight()/2;

            }
        }
    }
   
     
    
}
