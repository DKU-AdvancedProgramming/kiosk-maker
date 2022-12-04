import data.*;
import panels.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;

//프로젝트 설계도 제안안
public class KioskMaker extends JFrame{
    private JPanel north, list, order, category;
	MenuPanel menu;

    public KioskMaker(String fileName) {
        setTitle("주문 시스템");

        Container c = getContentPane();
        c.setLayout(null);

        //각 패널들의 클래스 객체 생성
        north = new NorthPanel();
        menu = new MenuPanel(fileName);
        category = new CategoryPanel(menu);
        order = new OrderPanel(menu);

        //패널들 위치지정
        north.setSize(350,40);
        north.setLocation(0,0);
        category.setSize(350, 50);
        category.setLocation(0,35);
        menu.setSize(350, 350);
        menu.setLocation(0, 85);        
        order.setSize(350, 350);
        order.setLocation(0,440);


        c.add(menu);
        c.add(category);
        c.add(north);
        c.add(order);
        
        setSize(365,780);
        setVisible(true);
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\손진호\\Desktop\\kiosk-maker\\Gimbap.txt";
        Data.setData(new File(fileName));
        new KioskMaker(fileName);
    }
    
}