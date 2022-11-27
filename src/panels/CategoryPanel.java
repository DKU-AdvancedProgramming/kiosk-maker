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
    private CardLayout cardlay = OverlappedMenuPanel.card;
    public CategoryPanel() {
        setLayout(new FlowLayout());
        for(int i=0 ; i<data.getCategoryCount() ; i++) {
            categoryButtonList.add(new JButton( data.getCategory(i).name ));
            categoryButtonList.get(i).setBackground(Color.white);
            categoryButtonList.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    cardlay.show(XXX, b.getActionCommand());
                    /*XXX 자리에 카테고리가 겹쳐진 화면 클래스의 객체
                    (여기서는 OverlappedMenuPanel)가 와야 함.*/
                }
            });

            add(categoryButtonList.get(i));
        }
        setVisible(true);
    }
}