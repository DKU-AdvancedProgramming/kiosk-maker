package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemPricePanel extends JPanel {
    //메뉴를 클릭할 때마다, OrderPanel.BillPanel에 추가되는 패널
    //ex. ItemPricePanel - (야채김밥 | 2000원 | [-]1[+])
    public JLabel itemLab, priceLab, totalPriceLab;
    private int itemPrice;
    private JButton plus, minus;
    private JTextField cntText;
    private int cnt = 1;
    public int totalPrice;
    //개수 * 단가

    public ItemPricePanel(String itemName, int itemPrice){
        this.itemPrice = itemPrice;
        totalPrice = this.itemPrice * cnt;

        itemLab = new JLabel(itemName);
        priceLab = new JLabel(String.valueOf(this.itemPrice) + "원");

        cntText = new JTextField(String.valueOf(cnt), 2);

        minus = new JButton("-");
        plus = new JButton("+");

        minus.setBackground(Color.WHITE);
        plus.setBackground(Color.WHITE);

        totalPriceLab = new JLabel(String.valueOf(totalPrice) + "원");
        GUI_Set();
        addXListener();
    }

    public void GUI_Set(){  //GUI 세부 설정 필요
        setSize(300, 40);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());

        itemLab.setPreferredSize(new Dimension(80, 20));
        itemLab.setHorizontalAlignment(JLabel.CENTER);
        itemLab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
        priceLab.setFont(new Font("NanumGothic", Font.BOLD, 12));
        totalPriceLab.setFont(new Font("NanumGothic", Font.BOLD, 12));
        plus.setSize(10,10);
        minus.setSize(10,10);

        add(itemLab);
        add(priceLab);

        add(minus);
        add(cntText);
        add(plus);

        add(totalPriceLab);
    }

    public void addXListener(){
        //리스너가 필요한 것들의 집합, 코드 직관적이게
        plus.addActionListener(new VariationBtnListener());
        minus.addActionListener(new VariationBtnListener());
    }

    class VariationBtnListener implements ActionListener {
        //변수 cnt 증감리스너, 최소개수 1, 최대개수 10으로 제한
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton cntVary = (JButton) e.getSource();
            if(cntVary.getText().equals("+")){
                cnt++;
                if(cnt > 10){
                    cnt = 10;
                }
            }
            else if(cntVary.getText().equals("-")){
                cnt--;
                if(cnt <= 1){
                    cnt = 1;
                }
            }
            cntText.setText(String.valueOf(cnt));
            totalPrice = itemPrice * cnt;
            totalPriceLab.setText(String.valueOf(totalPrice) + "원");
        }
    }
}