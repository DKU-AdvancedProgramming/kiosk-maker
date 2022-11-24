import data.Category;

import javax.swing.*;
import java.awt.*;
import panels.Menu;

/*
ī�װ� �ϳ��� ������ �����ϴ� �г�
*/
class CategoryPanel extends JPanel{
	public Menu[] MenuList = new Menu[9];

	public CategoryPanel(Category c){

		setLayout(new GridLayout(3,3,4,4));

		for(int i=0; i<9; i++) {
			MenuList[i] = new Menu(c.getItem(i).name, c.getItem(i).price, "WeCanDoIt.jpg");
			add(MenuList[i]);
		}

		setVisible(true);
		setSize(300,300);
	}
}

