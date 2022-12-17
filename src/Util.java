import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class Util {
    public static void setGlobalFont(String fontFilePath) {
        try (InputStream is = Util.class.getResourceAsStream(fontFilePath)) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            java.util.Enumeration keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if (value instanceof javax.swing.plaf.FontUIResource)
                    UIManager.put(key, font);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
