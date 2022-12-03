package panels;

import data.*;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    //data로부터 정보를 읽어와서 메뉴버튼을 만든다.
    MenuButton test, test2;
    public MenuPanel(){
        setSize(500, 600);
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        test = new MenuButton(new Item("test", 1000));
        test2 = new MenuButton(new Item("test2", 2000));
        add(test);
        add(test2);
    }
}
