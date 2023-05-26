package Models.Relation;

import Models.Element;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType(XmlAccessType.PROPERTY)
public abstract class Relations {
    @XmlElement(name = "id")
    String id;
   
    
    @XmlElement(name = "source")
    @XmlIDREF
    Element source;
    
    @XmlElement(name = "target")
    @XmlIDREF
    Element target;
    
    int xtarget;
    int ytarget;
    
    boolean hover;

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }
    
    
    
   
    
    
    
    public void Relation(){
        
    }
  

    public Element getSource() {
        return source;
    }


    public Element getTarget() {
        return target;
        
    }
//    public boolean contains(int x, int y) {
//          int margin = 10; // Margin of 10 pixels
//          int x2=this.target.getX();
//   int  y2=this.target.getY();
//   int x1=this.source.getX();
//   int y1=this.source.getY();
//    // Calculate the arrow coordinates
//    int dx = (x2 - x1) / 2;
//    int dy = (y2 - y1) / 2;
//    double D = Math.sqrt(dx * dx + dy * dy);
//    double xm = D - 20, xn = xm, ym = 15, yn = -15;
//    double sin = dy / D, cos = dx / D;
//    double xArrow1 = xm * cos - ym * sin + x1;
//    ym = xm * sin + ym * cos + y1;
//    xm = xArrow1;
//    double xArrow2 = xn * cos - yn * sin + x1;
//    yn = xn * sin + yn * cos + y1;
//    xn = xArrow2;
//    int x3 = x1 + dx;
//    int y3 = y1 + dy;
//
//    // Calculate the bounding box of the arrow with margin
//    int minX = Math.min(x3, Math.min((int) xArrow1, (int) xArrow2)) - margin;
//    int maxX = Math.max(x3, Math.max((int) xArrow1, (int) xArrow2)) + margin;
//    int minY = Math.min(y3, Math.min((int) ym, (int) yn)) - margin;
//    int maxY = Math.max(y3, Math.max((int) ym, (int) yn)) + margin;
//
//    // Check if the point is within the bounding box
//    if (x < minX || x > maxX || y < minY || y > maxY) {
//        return false;
//    }
//
//    // Check if the point is within the polygon defined by the arrow
//    int[] xpoints = { x3, (int) xArrow1, (int) xArrow2 };
//    int[] ypoints = { y3, (int) ym, (int) yn };
//
//    Polygon arrowPolygon = new Polygon(xpoints, ypoints, 3);
//    return arrowPolygon.contains(x, y);
//}
    
//    public boolean contains(int x, int y) {
//  
//    int padding = 10; // Padding of 10 pixels
//    int x2=this.target.getX();
//   int  y2=this.target.getY();
//   int x1=this.source.getX();
//   int y1=this.source.getY();
//    // Calculate the arrow coordinates
//    int dx = (x2 - x1) / 2;
//    int dy = (y2 - y1) / 2;
//    double D = Math.sqrt(dx * dx + dy * dy);
//    double xm = D - 20, xn = xm, ym = 15, yn = -15;
//    double sin = dy / D, cos = dx / D;
//    double xArrow1 = xm * cos - ym * sin + x1;
//    ym = xm * sin + ym * cos + y1;
//    xm = xArrow1;
//    double xArrow2 = xn * cos - yn * sin + x1;
//    yn = xn * sin + yn * cos + y1;
//    xn = xArrow2;
//    int x3 = x1 + dx;
//    int y3 = y1 + dy;
//
//    // Check if the point is within the polygon defined by the arrow
//    int[] xpoints = { x3, (int) xArrow1, (int) xArrow2 };
//    int[] ypoints = { y3, (int) ym, (int) yn };
//
//    Polygon arrowPolygon = new Polygon(xpoints, ypoints, 3);
//    if (!arrowPolygon.contains(x, y)) {
//        return false;
//    }
//
//    // Check if the point is within the padding distance of the arrow
//    int dx1 = x - x1;
//    int dy1 = y - y1;
//    int dx2 = x - x2;
//    int dy2 = y - y2;
//
//    double distanceToLine = Math.abs(dx2 * dy1 - dx1 * dy2) / Math.sqrt(dx2 * dx2 + dy2 * dy2);
//
//    return distanceToLine <= padding;
//
//}
//    public boolean contains(int x, int y) {
//        
//    int x1 = this.getSource().getX();
//    int y1 = this.getSource().getY();
//    int x2 = this.getTarget().getY();
//    int y2 = this.getTarget().getY();
//    
//    
//         // Calculate the distance between the point (x, y) and the line segment
//    double distance = Math.abs((x2 - x1) * (y1 - y) - (x1 - x) * (y2 - y1)) / Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//
//        // Check if the distance is within the specified thickness (10 pixels)
//    return distance <= 10;
//            
//    }
//    public boolean contains(int x, int y) {
//        
//    int x1 =xtarget ;
//    int y1 =ytarget;
//    int x2 =x1+20;
//    int y2 =y1+20;
//    
//    
//   if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
//       
//        this.hover=true;
//        return true;
//        
//    } else {
//        this.hover=false;
//        return false;
//    }
//            
//    }
    public  boolean contains(int x, int y) {

        int x1=source.getX();
        int y1=source.getY();
        int x2=xtarget;
        int y2=ytarget;

    
    // Calculate the squared length of the arrow
    int arrowLengthSquared = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

    // Calculate the squared distance from the point to the start of the arrow
    int distanceToStartSquared = (x - x1) * (x - x1) + (y - y1) * (y - y1);

    // Calculate the squared distance from the point to the end of the arrow
    int distanceToEndSquared = (x - x2) * (x - x2) + (y - y2) * (y - y2);

    // Calculate the squared distance from the point to the line formed by the arrow
    int dx = x2 - x1;
    int dy = y2 - y1;
    int crossProduct = (x - x1) * dy - (y - y1) * dx;
    int distanceToLineSquared = crossProduct * crossProduct / arrowLengthSquared;

    // Calculate the squared padding distance
    int paddingSquared = 10 * 10;

    // Check if the point is within the arrow with padding
    if(distanceToLineSquared <= paddingSquared && distanceToStartSquared <= arrowLengthSquared + paddingSquared
            && distanceToEndSquared <= arrowLengthSquared + paddingSquared){
        this.hover=true;
        return true;
    }else{
        this.hover=false;
        return false;
    }
}
    
    
    public void draw(Graphics g) {}
}
