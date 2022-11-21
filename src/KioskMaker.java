import panels.*;
import java.awt.*;
import javax.swing.*;

//프로젝트 설계도 제안안
public class KioskMaker extends JFrame{
    private JPanel list, menu, order, north;

    public KioskMaker() {
        setTitle("주문 시스템");
        setBackground(Color.DARK_GRAY);

        Container c = getContentPane();
        c.setLayout(null);

        //각 패널들의 클래스 객체 생성
        list = new ListPanel();
        menu = new MenuPanel();
        order = new OrderPanel();
        north = new NorthPanel();

        //대충 패널들 위치지정
        list.setSize(200,1000);
        list.setLocation(0, 0);
        menu.setSize(550, 550);
        menu.setLocation(200, 170);
        order.setSize(300,600);
        order.setLocation(700, 170);
        north.setSize(800, 200);
        north.setLocation(200,0);

        c.add(list);
        c.add(menu);
        c.add(order);
        c.add(north);

        setSize(1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new KioskMaker();
    }
}
