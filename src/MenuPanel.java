package zGUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JPanel{
	//필드: Menu, Category는 이 클래스의 내부 클래스로 정의되어 있음
	public static Menu m1, m2, m3;
	public Category c;

	//생성자
	public MenuPanel() {
		setLayout(null); //패널들을 겹치게 놓아야 하므로 null

		m1 = new Menu(Color.WHITE);//색으로 패널 구분
		m2 = new Menu(Color.ORANGE);
		m3 = new Menu(Color.GRAY);
		c = new Category();
		
		m1.setVisible(true); //첫 번째 메뉴 패널만 보이게
		m2.setVisible(false);
		m3.setVisible(false);
		c.setVisible(true);
		
		m1.setLocation(50, 50); //겹쳐서 위치 지정
		m2.setLocation(50, 50);
		m3.setLocation(50, 50);
		c.setSize(400,100);
		c.setLocation(0,0);
		
		add(m1);
		add(m2);
		add(m3);
		add(c);
		
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuPanel menuPanel = new MenuPanel();
		JFrame f =  new JFrame();
		f.add(menuPanel);
		f.setSize(400,400);
		f.setVisible(true);
	}
	
	//메뉴 패널 클래스
	class Menu extends JPanel{
		public JButton[] menuButton; //메뉴 버튼
		public String[] menuName; //버튼에 들어갈 메뉴 이름
		public String[] menuPrice;
		
		public Menu(Color color){
			setLayout(new GridLayout(3,3,4,4));
			
			menuButton = new JButton[9];
			menuName = new String[9];
			menuPrice = new String[9];
			
			getMenuName(menuName);	//메뉴 이름 설정
			getMenuPrice(menuPrice);	//메뉴 가격 설정
			
			for(int i=0; i<9; i++) {
				menuButton[i] = new JButton();
				menuButton[i].setBackground(color);
				menuButton[i].setLayout(new FlowLayout());
				menuButton[i].add(new JLabel(menuName[i]));
				menuButton[i].add(new JLabel(menuPrice[i]));
				add(menuButton[i]);
			}
			
			setVisible(true);
			setSize(300,300);
		}
		
		void getMenuName(String[] menuName) {//파일로 부터 버튼들의 이름 읽어오기
			for(int i=0; i<9; i++) {
				menuName[i] = "메뉴" + Integer.toString(i);//임시 메뉴 이름
			}
		}
		void getMenuPrice(String[] menuPrice) {	//파일로 부터 버튼들의 가격 읽어오기
			for(int i=0; i<9; i++) {
				menuPrice[i] = "1000원"; //임시 메뉴 가격
			}
		}
	}
	
	//카테고리 선택 패널 클래스
	class Category extends JPanel{
		public JButton b1, b2, b3;
		
		public Category() {
			setLayout(new FlowLayout());
			b1 = new JButton("카테고리1");
			b2 = new JButton("카테고리2");
			b3 = new JButton("카테고리3");
			
			b1.setBackground(Color.WHITE);
			b2.setBackground(Color.WHITE);
			b3.setBackground(Color.WHITE);
			
			b1.addActionListener(new CategoryActionListener());//뒤에 정의되어 있음
			b2.addActionListener(new CategoryActionListener());
			b3.addActionListener(new CategoryActionListener());


			add(b1);
			add(b2);
			add(b3);		
		}
		
		
		class CategoryActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton)e.getSource();
				String s = button.getActionCommand();//객체의 문자열을 얻어오는 메소드
				if(s == "카테고리1") {
					MenuPanel.m1.setVisible(true);
					MenuPanel.m2.setVisible(false);
					MenuPanel.m3.setVisible(false);
				}
				else if(s == "카테고리2") {
					MenuPanel.m1.setVisible(false);
					MenuPanel.m2.setVisible(true);
					MenuPanel.m3.setVisible(false);
				}
				else {
					MenuPanel.m1.setVisible(false);
					MenuPanel.m2.setVisible(false);
					MenuPanel.m3.setVisible(true);
				}
			}
			
		}
	}
}
