/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Relation.Relations;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author Mou nir
 */


@XmlAccessorType(XmlAccessType.FIELD)
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlSeeAlso({Goal.class, Strategy.class, Solution.class, Justification.class, Assumption.class, Context.class})
public abstract class Element {
    
    @XmlElement(name = "id")
    @XmlID
    String ID;
    @XmlElement(name = "x")
     int X;
    @XmlElement(name = "y")
     int Y;
    @XmlElement(name = "height")
     int height;
    @XmlElement(name = "width")
     int width;
    @XmlElement(name = "descreption")
    String descreption;
    
    
    
    boolean Hover;
    
   
 
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public boolean contains(int x, int y) {
          // Calculate the coordinates of the corners of the object's bounding box
//    int x1 = this.X;
//    int y1 = this.Y;
//    int x2 = this.X + this.width+15;
//    int y2 = this.Y + this.height+10;
    
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

    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setHover(boolean Hover) {
       this.Hover=Hover;
    }

    public Object getParents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
    

  
    
    
    
    
}
