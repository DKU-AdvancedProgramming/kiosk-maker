package panels;

import components.MenuButton;
import panels.order.BillPanel;
import windows.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class OrderPanel extends JPanel { //오른쪽 주문하기 패널, 영수증 출력기능도 있어야 할듯
    public Map<JButton, ItemPricePanel> btn_itemPricePanel;
    //ItemPricePanel과 이를 삭제하기 위한 deleteBtn을 Map<>으로 묶어서 관리
    private final MenuPanel menuPanel = Panels.getMenuPanel();
    public BillPanel billPanel;
    public BtnPanel btnPanel;
    
    public OrderPanel(){
        btn_itemPricePanel = new HashMap<>();
        billPanel = new BillPanel(btn_itemPricePanel);
        //BillPanel과 Map<>을 생성자를 통해 연결
        btnPanel = new BtnPanel(billPanel);
        //BtnPanel과 BillPanel을 생성자를 통해 연결

        setBackground(Color.DARK_GRAY);
        setLayout(null);

        addMenuBtnListener();

        billPanel.setLocation(0,0);
        btnPanel.setLocation(0,250);
        
        add(billPanel);
        add(btnPanel);

        setSize(350,300);
    }
    

    private void addMenuBtnListener(){
        //각 MeneButton에 리스너 연결
    	// i<3, j<9 부분 수정 필요함
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<9; j++) {
    			menuPanel.getOneMenuPanel(i).menuButtons[j]
    					.addActionListener(new MenuBtnListener());;
    		}
    	}
    }

    class MenuBtnListener implements ActionListener {
        //MenuButton 클릭시
        @Override
        public void actionPerformed(ActionEvent e) {
            if(btn_itemPricePanel.size() < 7){
                //BillPanel에 최대 10개의 ItemPricePanel 추가 가능
                MenuButton mBtn = (MenuButton) e.getSource();
                //추가(메뉴 중복 선택 방지 코드), 22.12.04 - 하경준
                for(ItemPricePanel tmp:btn_itemPricePanel.values()){
                    if(tmp.itemLab.getText().equals(mBtn.name)){
                        return;
                    }
                }

                //[X] - itemPricePanel(야채김밥 | 2000원 | [-]1[+] | [X])
                JButton deleteBtn = new JButton("X");
                deleteBtn.addActionListener(new DeleteBtnListener());
                ItemPricePanel itemPricePanel = new ItemPricePanel(mBtn.name, mBtn.price);
                itemPricePanel.add(deleteBtn);

                btn_itemPricePanel.put(deleteBtn, itemPricePanel);
                billPanel.add(itemPricePanel);

                billPanel.setPriceSum();
                revalidate();
                repaint();
            }
        }
    }

    class DeleteBtnListener implements ActionListener{
        //[X]버튼 클릭시
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton dBtn = (JButton)e.getSource();
            billPanel.remove(btn_itemPricePanel.remove(dBtn));
            billPanel.revalidate();
            billPanel.repaint();
            //클릭된 [X]버튼을 포함하는 ItemPricePanel, OrderPanel.Map<>의 [X]-ItemPricePanel 요소를 동시에 제거
        }
    }
}

class BtnPanel extends JPanel{
    //OrderPanel의 하단부
    public JButton orderBtn= new JButton("주문");
    public JButton resetBtn = new JButton("취소");


    public BillPanel billPanel;
    public BtnPanel(BillPanel billPanel){
        this.billPanel = billPanel;
        GUI_Set();
        addXListener();
    }

    public void GUI_Set(){
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1,2,0,3));
        resetBtn.setFont(new Font("NanumGothic", Font.PLAIN, 20));
        resetBtn.setBackground(Color.LIGHT_GRAY);
        orderBtn.setFont(new Font("NanumGothic", Font.PLAIN, 20));
        orderBtn.setBackground(Color.ORANGE);

        add(resetBtn);
        add(orderBtn);

        setSize(350,50);
    }

    public void addXListener(){
        orderBtn.addActionListener(new ActionListener() {
            //[주문]버튼 클릭시
            @Override
            public void actionPerformed(ActionEvent e) {
                if(billPanel.btn_itemPricePanel.size() >= 1){
                    new PaymentDialog(billPanel);
                    Panels.getKioskFrame().setVisible(false);
//                    billPanel.totalPriceSum = 0;
//                    //다시 0으로 초기화
//                    billPanel.setPriceSum();
//
//                    String text = String.format("총 주문금액: %d원\n주문하시겠습니까?", billPanel.totalPriceSum);
//                    int option = JOptionPane.showConfirmDialog(null, text, "결제 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//                    if(option == JOptionPane.OK_OPTION){
//                        JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.\n음식이 나올 때까지 잠시만 기다려 주세요.", "주문 성공", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                    billPanel.btn_itemPricePanel.clear();
//                    billPanel.removeAll();
//                    billPanel.revalidate();
//                    billPanel.repaint();
                }
            }
        });
        
        resetBtn.addActionListener(new ActionListener() {
            //[초기화]버튼 클릭시
            @Override
            public void actionPerformed(ActionEvent e) {
                //연결된 BillPanel(OrderPanel).Map<>의 모든 요소, BillPanel에 부착된 모든 ItemPricePanel를 제거
            	billPanel.btn_itemPricePanel.clear();
                billPanel.removeAll();
                billPanel.revalidate();
                billPanel.repaint();
            }
        });
    }
}