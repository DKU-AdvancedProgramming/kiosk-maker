package panels;

import components.MenuButton;
import data.Category;
import data.Data;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.util.ArrayList;

class OneMenuPanel extends JPanel{
    public JButton[] menuButtons;
    public int itemCount;

    private final Data data = Data.getData();

    //카테고리 객체를 받아 객체 생성
    public OneMenuPanel(Category category) {
        itemCount = category.getItemCount(); //추가한 메소드
        menuButtons = new MenuButton[itemCount]; 
        setLayout(new GridLayout(3,itemCount/3,4,4));

        for(int i=0; i<itemCount; i++) {
            menuButtons[i] = new MenuButton(category.getItem(i)); 
            add(menuButtons[i]);
        }
        setSize(300,300);
    }
   
}


public class MenuPanel extends JPanel {

	public JPanel[] menuPanels;
	public int itemCount;
	protected static CardLayout card = new CardLayout(); //card -> cardLayout
	/*static인 이유는 1개일 필요가 있는게 아니라 다른 곳에서 접근을
	* 가능하게 하기 위함임*/
	private final Data data = Data.getData();  //무슨의미
	
	//카테고리 객체를 받아 객체 생성
	public MenuPanel() {
		menuPanels = new OneMenuPanel[data.getCategoryCount()];
		setLayout(card);

		for(int i=0 ; i<data.getCategoryCount() ; i++) {
			Category c = data.getCategory(i);
			menuPanels[i] = new OneMenuPanel(c);
			add(c.name, menuPanels[i]);
		}
	}
	
	
	OneMenuPanel getOneMenuPanel(int index) {
		return (OneMenuPanel) menuPanels[index];
	}
	

}
