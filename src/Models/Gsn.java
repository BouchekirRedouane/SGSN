/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mou nir
 */

@XmlRootElement(name = "GSN")
@XmlAccessorType(XmlAccessType.FIELD)
public  class GSN { 
    
    private String name;
    private String path;
    @XmlElement(name = "elements")
    private ArrayList<Element> Elements;

    public ArrayList<Element> getElements() {
        return Elements;
    }
    
    public GSN(String name , String path){
        this.name=name;
        this.path=path;
        Elements = new ArrayList<>();        
    }

    public GSN() {
    }
    
    
    
     public void addElementt(Element item) {
        boolean add = Elements.add( item);
//        Elements.size()+1,
        for (int i = 0; i <Elements.size(); i++) {
         
         System.out.print("\n"+Elements.get(i).getID()+"\n");
        }
        System.out.print("///////////////////////////////// \n");
       
    }

    public void deletElement(Element item) {
        for (int i = 0; i < Elements.size(); i++) {
            if (Elements.get(i) != null && Elements.get(i).equals(item)) {
                Elements.remove(i);
                return;
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
