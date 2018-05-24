package mcmarc;
import javax.swing.*;

/**
 *
 * @author Hachi_Boy
 */
public class MCmarc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {//
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        new sesionStart1().setVisible(true);
        //clase principal de arranque 
    }

}
