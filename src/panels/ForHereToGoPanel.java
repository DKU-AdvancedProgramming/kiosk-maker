package panels;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ForHereToGoPanel extends JPanel { //포장 매장
	JLabel colorLabel1, colorLabel2, textLabel;
	JButton forHere, toGo;

	public ForHereToGoPanel() {
		setBackground(Color.WHITE);
		setSize(350,775);
		setLayout(null);
		GUI_Set();
		setImageAndFont();
	}
	
	void GUI_Set() {
		textLabel = new JLabel("식사하실 장소를 선택해 주세요");
		textLabel.setLocation(95,80);
		textLabel.setSize(365,100);
		colorLabel1 = new JLabel();
		colorLabel1.setOpaque(true);
		colorLabel1.setBackground(Color.ORANGE);
		colorLabel1.setSize(365,10);
		colorLabel1.setLocation(0,50);
	
		
		forHere = new JButton("바로먹기");
		toGo = new JButton("포장");
		forHere.setLocation(45,200);
		forHere.setSize(120,200);
		forHere.addActionListener(e -> this.setVisible(false));
		forHere.setBackground(Color.ORANGE);
		toGo.setLocation(190,200);
		toGo.setSize(120,200);
		toGo.setBackground(Color.ORANGE);
		toGo.addActionListener(e -> this.setVisible(false));
	
		
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
		//textLabel.setFont();
		//foreHere.setFont();
		//toGo.setFont();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(null);
		f.setTitle(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ForHereToGoPanel p = new ForHereToGoPanel();
		p.setLocation(0,0);
		f.add(p);
		
		
		f.setVisible(true);
		f.setSize(365,775);
	}
	
}
