
import Views.MainFram;
import javax.swing.UIManager;



/**
 *
 * @author Mou nir
 */
public class GSN_construct {
    public static void main(String[] args) {

       // Change app theme to Win 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception: "+e.toString());
       }

        //Open the main fram 
        MainFram m = new MainFram();

    }
    
}
    