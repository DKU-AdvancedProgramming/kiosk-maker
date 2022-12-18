package windows;

import panels.order.BillPanel;
import panels.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentDialog extends JDialog {
    private BillPanel curr_bill;
    private JButton btnBack, btnPayByCard;

    public void back(){
        setVisible(false);
        Panels.getOrderPanel().add(curr_bill);
        Panels.getKioskFrame().setVisible(true);
    }
    public PaymentDialog(BillPanel billPanel){

        curr_bill = billPanel;
        btnBack = new JButton("뒤로가기");
        btnPayByCard = new JButton("신용카드 결제");

        btnBack.setBackgroud(Color.LIGHT_GRAY);
        btnPayByCard.setBackGroud(Color.ORANGE);
        btnBack.setBounds(15,270,152,75);
        btnPayByCard.setBounds(185,270,152, 75);

        add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        add(btnPayByCard);
        btnPayByCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curr_bill.setPriceSum();
                String text = String.format("총 주문금액: %d원\n주문하시겠습니까?", curr_bill.totalPriceSum);
                int option = JOptionPane.showConfirmDialog(null, text, "결제 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.OK_OPTION){


                    JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.\n음식이 나올 때까지 잠시만 기다려 주세요.", "주문 성공", JOptionPane.INFORMATION_MESSAGE);
                    curr_bill.btn_itemPricePanel.clear();
                    curr_bill.removeAll();
                    back();
                }
            }
        });

        setLayout(null);

        curr_bill.setLocation(0, 0);
        add(curr_bill);


        setSize(365, 400);
        setLocationRelativeTo(null); // 화면 정중앙에 배치
        setVisible(true);
    }
}