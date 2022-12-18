package panels;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import data.Data;
public class NorthPanel extends JPanel{
    JLabel name;

    //맨 위에 이름 나타내는 패널
    public NorthPanel(){
        setBackground(Color.ORANGE);
        setLayout(new FlowLayout());
        name = new JLabel(Data.getData().getName());
        add(name);
    }
}