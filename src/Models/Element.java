/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Graphics;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Mou nir
 */

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Element {
    
    @XmlElement(name = "id")
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
    int x1 = this.X;
    int y1 = this.Y;
    int x2 = this.X + this.width+15;
    int y2 = this.Y + this.height+10;
     
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
    
    

  
    
    
    
    
}
