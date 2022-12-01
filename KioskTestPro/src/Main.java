import panels.MenuPanel;
import panels.OrderPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public MenuPanel mp;
    public OrderPanel op;

    public Main(){
        super("임시");
        setLayout(null);
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI_Set();
        setVisible(true);
    }

    public void GUI_Set(){
        Container c = getContentPane();
        mp = new MenuPanel();
        op = new OrderPanel(mp);

        c.add(op);
        c.add(mp);
        op.setLocation(700, 0);
    }

    public static void main(String[] args) {
        new Main();
    }
}
