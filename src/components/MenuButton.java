package components;

import data.Item;

import javax.swing.*;
import java.awt.*;
/*
button to store information about one menu
	※ 여기서 Menu는 '하나의 메뉴'를 의미합니다!
*/
public class MenuButton extends JButton{
	public String name;
	public int price;
	public ImageIcon image;

	public MenuButton(Item item) {
		name = item.name;
		price = item.price;
		image = resizedImageIcon(item.imgPath);

		setBackground(Color.white);

		JLabel imgLabel = new JLabel(image);
		JLabel nameLabel = new JLabel(name);
		JLabel priceLabel = new JLabel(Integer.toString(price));

		imgLabel.setSize(100, 100);
		nameLabel.setSize(100, 30);
		priceLabel.setSize(100, 30);

		setLayout(new BorderLayout());

		add(imgLabel, BorderLayout.NORTH);
		add(nameLabel, BorderLayout.CENTER);
		add(priceLabel, BorderLayout.SOUTH);

	}

	private static ImageIcon resizedImageIcon(String pathname) {
		ImageIcon icon = new ImageIcon(pathname);
		Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
}
