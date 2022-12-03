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
    private MenuPanel menupanel = Panels.getMenuPanel();
    private CardLayout cardlay;
    public CategoryPanel() {
        setLayout(new FlowLayout());
        for(int i=0 ; i<data.getCategoryCount() ; i++) {
        	JButton categoryButton = new JButton( data.getCategory(i).name );
        	categoryButton.setPreferredSize(new Dimension(100, 35));
            categoryButtonList.add(categoryButton);
            categoryButtonList.get(i).setBackground(Color.WHITE);
            categoryButtonList.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    cardlay.show(menupanel, b.getActionCommand()); // 12/03 기윤: 여기서 오류 날 수도.
                }
            });
            
            add(categoryButtonList.get(i));
        }
        setVisible(true);
    }
}