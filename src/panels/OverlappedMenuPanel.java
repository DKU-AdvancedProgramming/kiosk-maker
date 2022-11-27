package panels;

import components.MenuPanel;
import data.Category;
import data.Data;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.util.ArrayList;

public class OverlappedMenuPanel extends JPanel{
	public JPanel[] menuPanels;
	public int itemCount;
	protected static CardLayout card = new CardLayout();
	/*static인 이유는 1개일 필요가 있는게 아니라 다른 곳에서 접근을
	* 가능하게 하기 위함임*/
	private final Data data = Data.getData();
	
	//카테고리 객체를 받아 객체 생성
	public OverlappedMenuPanel(String filename) {
		Data.setData(new File(filename));
		menuPanels = new MenuPanel[data.getCategoryCount()];
		setLayout(card);

		for(int i=0 ; i<data.getCategoryCount() ; i++) {
			Category c = data.getCategory(i);
			menuPanels[i] = new MenuPanel(c);
			add(c.name, menuPanels[i]);
		}
	}
	

}
