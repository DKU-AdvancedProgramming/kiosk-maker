package panels;

import javax.swing.*;
import java.awt.*;

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
       
        setSize(350,200);
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

    class MenuBtnListener implements ActionListener{
        //MenuButton 클릭시
        @Override
        public void actionPerformed(ActionEvent e) {
            if(btn_itemPricePanel.size() < 10){
                //BillPanel에 최대 10개의 ItemPricePanel 추가 가능
                MenuButton mBtn = (MenuButton) e.getSource();

                //[X] - itemPricePanel(야채김밥 | 2000원 | [-]1[+] | [X])
                JButton deleteBtn = new JButton("X");
                deleteBtn.addActionListener(new DeleteBtnListener());
                ItemPricePanel itemPricePanel = new ItemPricePanel(mBtn.name, mBtn.price);
                itemPricePanel.add(deleteBtn);

                btn_itemPricePanel.put(deleteBtn, itemPricePanel);
                billPanel.add(itemPricePanel);
            }
        }
    }

    class DeleteBtnListener implements ActionListener{
        //[X]버튼 클릭시
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton dBtn = (JButton)e.getSource();
            billPanel.remove(btn_itemPricePanel.remove(dBtn));
            //클릭된 [X]버튼을 포함하는 ItemPricePanel, OrderPanel.Map<>의 [X]-ItemPricePanel 요소를 동시에 제거
        }
    }
}

class BillPanel extends JPanel{
    //OrderPanel의 상단부 Panel
    public Map<JButton, ItemPricePanel> btn_itemPricePanel;
    //OrderPanel의 btn_itemPricePanel 레퍼런스값을 받기 위한 변수, BtnPanel에서 활용
    public int totalPriceSum = 0;
    public BillPanel(Map<JButton, ItemPricePanel> btn_itemPricePanel){
        this.btn_itemPricePanel = btn_itemPricePanel;
        GUI_Set();
    }

    public void GUI_Set(){
        setBackground(Color.WHITE);
        setLayout(new GridLayout(10,1,0,1));
        setSize(350,400);
    }

    public void setPriceSum(){
        for(Object o:btn_itemPricePanel.values().toArray()){
            ItemPricePanel tmp = (ItemPricePanel) o;
            totalPriceSum += tmp.totalPrice;
        }
    }
}

class BtnPanel extends JPanel{
    //OrderPanel의 하단부
    public JButton orderBtn = new JButton("주문");
    public JButton resetBtn = new JButton("취소");
    public JButton Btn = new JButton("Button");

    public BillPanel billPanel;
    public BtnPanel(BillPanel billPanel){
        this.billPanel = billPanel;
        GUI_Set();
        addXListener();
    }
}