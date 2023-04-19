package Models;

public class Gsn {

    String name;
    String path;
    
    
    //constructeur
    public Gsn(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    
    //main Methods
    
    public void Import(String XmlPath)
    {
        
    }
    
    public void ExportAsXML()
    {
        
    }
    
    public void ExportAsImage()
    {
        
    }
    
    public void save()
    {
        
    }
    
    
    
    
    //Getteurs et Setteurs
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    

    
}
