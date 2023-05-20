/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Relation.InContextOf;
import Models.Relation.Relations;
import Models.Relation.SupportedBy;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
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
//    @XmlElement(name = "Elements")
    @XmlElementWrapper(name = "Elements")
    @XmlElements({
            @XmlElement(name = "goal", type = Goal.class),
            @XmlElement(name = "strategy", type = Strategy.class),
            @XmlElement(name = "solution", type = Solution.class),
            @XmlElement(name = "Context", type = Context.class),
            @XmlElement(name = "Justification", type = Justification.class),
            @XmlElement(name = "Assumption", type = Assumption.class)
    })
    private ArrayList<Element> Elements;
//    @XmlElement(name = "Relations")
     @XmlElementWrapper(name = "relations")
    @XmlElements({
            @XmlElement(name = "InContextOf", type = InContextOf.class),
            @XmlElement(name = "SupportedBy", type = SupportedBy.class)
    })
    private ArrayList<Relations> Relations;

    public ArrayList<Element> getElements() {
        return Elements;
    }

    public ArrayList<Relations> getRelations() {
        return Relations;
    }
    
    
    public GSN(String name , String path){
        this.name=name;
        this.path=path;
        Elements = new ArrayList<>();  
        Relations = new ArrayList<>();  
        
    }

    public GSN() {
    }
    
    public void addElementt(Element item) {
      Elements.add( item);
       
    }

    public void deletElement(Element item) {
        
        
        for (int i = 0; i < Elements.size(); i++) {
            if (Elements.get(i) != null && Elements.get(i).equals(item)) {
                for (int j = 0; j < Relations.size(); j++) {
                 if (Relations.get(j) != null && (Relations.get(j).getSource().equals(item)||Relations.get(j).getSource().equals(item))) {
                            Relations.remove(j);

                        }
                    }
                Elements.remove(i);
                return;
            }
        }
    }
    public void addRelationn(Relations relation) {
        boolean add= true; 
             for (int i = 0; i <Relations.size(); i++) {
                if(Relations.get(i).getSource()== relation.getSource() && Relations.get(i).getTarget()==relation.getTarget())
                    add=false;
                
//             System.out.print("\n"+Relations.get(i).getSource().getID()+":source  //////////////target:"+Relations.get(i).getTarget().getID() +"\n");
            }
             if(add==true)
                    Relations.add( relation);
             
            System.out.print("///////////////////////////////// \n");
       
    }

    public void deletRelation(Relations relation) {
        for (int i = 0; i < Relations.size(); i++) {
            if (Relations.get(i) != null && Relations.get(i).equals(relation)) {
                Relations.remove(i);
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
    
    public ArrayList<Element> getParent(Element element) {
        ArrayList<Element> parents = new ArrayList<>();
      
        for (Relations relation : Relations){
            if(relation.getTarget()==element){
                parents.add(relation.getSource());
            }
        }
        return parents ;
    }

    public ArrayList<Element> getChilds(Element element) {
         ArrayList<Element> childs = new ArrayList<>();
        
        for (Relations relation : Relations){
            if(relation.getSource()==element){
                childs.add(relation.getTarget());
            }
        }
        return childs ;
    }
    
}
