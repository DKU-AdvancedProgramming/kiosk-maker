package panels;

import components.FileChooseMenuBar;
import data.Data;
import panels.Panels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLOutput;

//프로젝트 설계도 제안안
public class Kiosk extends JFrame {
    private JPanel north, menu, order, category;
    private FileChooseMenuBar mbbar;
    private static JFrame openFrame = null;

    public Kiosk(File file) {
        Data.setData(file);
        setTitle("주문 시스템");

        Container c = getContentPane();
        c.setLayout(null);

        Panels.init();
        //각 패널들의 클래스 객체 생성
        north = Panels.getNorthPanel();
        menu = Panels.getMenuPanel();
        category = Panels.getCategoryPanel();
        order = Panels.getOrderPanel();

        //패널들 위치지정
        north.setSize(350, 40);
        north.setLocation(0, 0);
        category.setSize(350, 50);
        category.setLocation(0, 35);
        menu.setSize(350, 350);
        menu.setLocation(0, 85);
        order.setSize(350, 350);
        order.setLocation(0, 440);

        mbbar = new FileChooseMenuBar();
        setJMenuBar(mbbar);

        c.add(menu);
        c.add(category);
        c.add(north);
        c.add(order);

        setSize(365, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //추가 22.12.04

        if (openFrame == null) {
            openFrame = this;
        } else {
            openFrame.dispose();
            openFrame = this;
        }
    }

    public static void openAnotherFile(File file) {
        new Kiosk(file);
    }

    public static void refreshThisFrame() {

    }
}
