package panels;

import javax.swing.*;
import java.awt.*;
/*
button to store information about one menu

*/
public class Menu extends JButton{
	public String name;
	public int price;
	public ImageIcon image;

	public Menu(String name, int price, String imagePathNane) {
		this.name = name;
		this.price = price;
		this.image = resizedImageIcon(imagePathNane);

		setBackground(Color.white);

		JLabel imgLable = new JLabel(this.image);
		JLabel nameLable = new JLabel(name);
		JLabel priceLable = new JLabel(Integer.toString(price));

		imgLable.setSize(100, 100);
		nameLable.setSize(100, 30);
		priceLable.setSize(100, 30);

		setLayout(new BorderLayout());

		add(imgLable, BorderLayout.NORTH);
		add(nameLable, BorderLayout.CENTER);
		add(priceLable, BorderLayout.SOUTH);

	}

	private static ImageIcon resizedImageIcon(String pathname) {
		ImageIcon icon = new ImageIcon(pathname);
		Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}

}








