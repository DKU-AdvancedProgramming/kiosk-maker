import data.Data;
import panels.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;

//프로젝트 설계도 제안안
public class KioskMaker extends JFrame{
    private JPanel list, menu, order, category;

    public KioskMaker() {
        setTitle("주문 시스템");
        setBackground(Color.DARK_GRAY);

        Container c = getContentPane();
        c.setLayout(null);

        Panels.init();
        //각 패널들의 클래스 객체 생성
        menu = Panels.getMenuPanel();
        order = Panels.getOrderPanel();
        category = Panels.getCategoryPanel();

        //대충 패널들 위치지정
//        list.setSize(200,1000);
//        list.setLocation(0, 0);
        menu.setSize(550, 550);
        menu.setLocation(200, 170);
        order.setSize(300,600);
        order.setLocation(700, 170);
        category.setSize(800, 200);
        category.setLocation(200,0);

//        c.add(list);
        c.add(menu);
        c.add(order);
        c.add(category);

        setSize(1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        File file = new File("Gimbap.txt");
        Data.setData(file);
        new KioskMaker();
    }
}
