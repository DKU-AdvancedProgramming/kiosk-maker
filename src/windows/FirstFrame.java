package windows;

import data.Data;
import panels.Panels;

import java.awt.*;
import java.io.File;
import javax.swing.*;

@SuppressWarnings("serial")
public class FirstFrame extends JFrame { //포장 매장
	JLabel colorLabel1, colorLabel2, textLabel;
	JButton forHere, toGo;

	public FirstFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(Color.WHITE);
		setSize(350,775);
		setLayout(null);
		GUI_Set();
		setImageAndFont();

		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void GUI_Set() {
		textLabel = new JLabel("식사하실 장소를 선택해 주세요");
		textLabel.setFont(new Font("NanumGothic", Font.PLAIN, 16));
		textLabel.setLocation(65,80);
		textLabel.setSize(365,100);
		colorLabel1 = new JLabel();
		colorLabel1.setOpaque(true);
		colorLabel1.setBackground(Color.ORANGE);
		colorLabel1.setSize(365,10);
		colorLabel1.setLocation(0,50);
	
		
		forHere = new JButton();
		toGo = new JButton();

		forHere.setLocation(45,200);
		forHere.setSize(120,200);
		forHere.addActionListener(e -> {
			File file = new File("Gimbap.txt");
			Data.setData(file);
			Panels.init();
			setVisible(false);});
		forHere.setBackground(Color.ORANGE);

		toGo.setLocation(190,200);
		toGo.setSize(120,200);
		toGo.addActionListener(e -> {
			File file = new File("Gimbap.txt");
			Data.setData(file);
			Panels.init();
			setVisible(false);});
		toGo.setBackground(Color.ORANGE);

		colorLabel2 = new JLabel();
		colorLabel2.setOpaque(true);
		colorLabel2.setBackground(Color.ORANGE);
		colorLabel2.setSize(365,10);
		colorLabel2.setLocation(0,530);
		
		add(colorLabel1);
		add(textLabel);
		add(forHere);
		add(toGo);
		add(colorLabel2);
	}

	void setImageAndFont() {
		forHere.setLayout(new BorderLayout());
		toGo.setLayout(new BorderLayout());
		ImageIcon i1 = new ImageIcon("매장.jpg");
		ImageIcon i2 = new ImageIcon("포장.jpg");

		Image i11 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image i22 = i2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		JLabel l1 = new JLabel(new ImageIcon(i11));
		JLabel l2 = new JLabel(new ImageIcon(i22));
		forHere.add(l1, BorderLayout.CENTER);
		toGo.add(l2, BorderLayout.CENTER);

		JLabel t1 = new JLabel("      매장");
		JLabel t2 = new JLabel("      포장");

		t1.setFont(new Font("NanumGothic", Font.PLAIN, 16));
		t2.setFont(new Font("NanumGothic", Font.PLAIN, 16));
		forHere.add(t1, BorderLayout.SOUTH);
		toGo.add(t2, BorderLayout.SOUTH);

	}
}
