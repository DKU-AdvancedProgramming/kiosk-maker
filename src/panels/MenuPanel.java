package panels;

import data.Category;
import data.Data;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class MenuPanel extends JPanel{
	public JButton[] menuButton;
	public int itemCount;
	
	//카테고리 객체를 받아 객체 생성
	public MenuPanel(Category category) {
		itemCount = category.getItemCount(); //추가한 메소드
		menuButton = new JButton[itemCount]; //
		setLayout(new GridLayout(3,itemCount/3,4,4));
		
		for(int i=0; i<itemCount; i++) {
			menuButton[i] = new JButton();
			menuButton[i].setLayout(new FlowLayout());
			menuButton[i].add(new JLabel(category.getItem(i).name));
			menuButton[i].add(new JLabel(Integer.toString(category.getItem(i).price)));
			menuButton[i].setBackground(Color.WHITE);
			add(menuButton[i]);
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
		MenuPanel[] menu= new MenuPanel[categoryCount];
		for(int i=0; i<categoryCount; i++) {
			menu[i] = new MenuPanel(data.getCategory(i));
			menu[i].setLocation(50, 50);
			f.add(menu[i]);
			if(i!=0)
				menu[i].setVisible(false);
		}
		
		f.setSize(400,400);
		f.setVisible(true);
	}
}
