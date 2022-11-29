package panels;

import data.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CategoryPanel extends JPanel{
    public ArrayList<JButton> categoryButtonList = new ArrayList<>();

    private Data data = Data.getData();
    private MenuPanel menupanel = MenuPanel.getThis();
    private CardLayout cardlay;
    public CategoryPanel() {
        setLayout(new FlowLayout());
        for(int i=0 ; i<data.getCategoryCount() ; i++) {
            categoryButtonList.add(new JButton( data.getCategory(i).name ));
            categoryButtonList.get(i).setBackground(Color.white);
            categoryButtonList.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    cardlay.show(menupanel, b.getActionCommand());
                }
            });

            add(categoryButtonList.get(i));
        }
        setVisible(true);
    }
}