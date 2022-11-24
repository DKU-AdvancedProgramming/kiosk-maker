package panels;

import data.Data;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;

public class MenuPanel extends JPanel {
	private Data d = new Data(new File("FILE_PATH"));
	private JPanel overlapped, select;
	private CardLayout card;
	//modifier
	public MenuPanel() {
		setLayout(new BorderLayout());

		select = new SelectCategoryPanel();
		add(select, BorderLayout.NORTH);
		overlapped = new OverlappedCategoryPanel();
		add(overlapped, BorderLayout.CENTER);

		setSize(400, 400);
		setVisible(true);
	}

	//panel class in which display menus
	class OverlappedCategoryPanel extends JPanel {
		public ArrayList<CategoryPanel> OverlappedCategory = new ArrayList<>();

		public OverlappedCategoryPanel() {
			card = new CardLayout();
			setLayout(card);

			for(int i=0 ; i<d.getCategoryCount() ; i++) {
				OverlappedCategory.add(new CategoryPanel(d.getCategory(i)));
				add(d.getCategory(i).name, OverlappedCategory.get(i));
			}

			setSize(400,400);
			setVisible(true);
		}
	}

	//panel class in which choose category
	class SelectCategoryPanel extends JPanel{
		public ArrayList<JButton> categoryButtonList = new ArrayList<>();
		
		public SelectCategoryPanel() {
			setLayout(new FlowLayout());
			for(int i=0 ; i<d.getCategoryCount() ; i++) {
				categoryButtonList.add(new JButton( d.getCategory(i).name ));
				categoryButtonList.get(i).setBackground(Color.white);
				categoryButtonList.get(i).addActionListener(new CategoryActionListener());
				categoryButtonList.get(i).addActionListener(
						new CategoryActionListener() );
				add(categoryButtonList.get(i));
			}
			setVisible(true);
		}
	}
	//actionlistener, changes category
	class CategoryActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			card.show(overlapped, b.getActionCommand());
		}

	}

}