package Models;

public abstract class Element {
    String ID;
    String Desc;

    public String getID() {
        return ID;
    }

    public String getDesc() {
        return Desc;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
    
}
