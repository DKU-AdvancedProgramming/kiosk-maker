package components;

import components.MenuButton;
import data.Category;
import data.Data;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class MenuPanel extends JPanel{
    public JButton[] menuButtons;
    public int itemCount;
    public CardLayout card;

    private final Data data = Data.getData();

    //카테고리 객체를 받아 객체 생성
    public MenuPanel(Category category) {
        itemCount = category.getItemCount(); //추가한 메소드
        menuButtons = new MenuButton[itemCount];
        setLayout(new GridLayout(3,itemCount/3,4,4));

        for(int i=0; i<itemCount; i++) {
            menuButtons[i] = new MenuButton(category.getItem(i));
            add(menuButtons[i]);
        }
        setVisible(true);
        setSize(300,300);
    }

    //정상작동 하는지 확인
    public static void main(String[] args) {
        File file = new File("Gimbap.txt의 위치");
        Data data = Data.getData();

        JFrame f = new JFrame();
        f.setTitle("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        int categoryCount = data.getCategoryCount();
        panels.MenuPanel[] menu= new panels.MenuPanel[categoryCount];
        for(int i=0; i<categoryCount; i++) {
            menu[i] = new panels.MenuPanel(data.getCategory(i));
            menu[i].setLocation(50, 50);
            f.add(menu[i]);
            if(i!=0)
                menu[i].setVisible(false);
        }

        f.setSize(400,400);
        f.setVisible(true);
    }
}