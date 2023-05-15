package Models.Relation;

import Models.Element;
import java.awt.Graphics;
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
    
    
   
    
    
    
    public void Relation(){
        
    }
  

    public Element getSource() {
        return source;
    }


    public Element getTarget() {
        return target;
        
    }


    
    
    
    public void draw(Graphics g) {}
}
