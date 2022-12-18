
import java.io.File;
import javax.swing.*;

public class KioskMaker {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) { e.printStackTrace(); }
        new Kiosk(new File("info\\Gimbap.txt"));
    }
}