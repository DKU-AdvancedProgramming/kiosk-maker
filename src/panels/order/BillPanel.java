package panels.order;

import components.ItemPricePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BillPanel extends JPanel implements Cloneable {
    //OrderPanel의 상단부 Panel
    public Map<JButton, ItemPricePanel> btn_itemPricePanel;
    //OrderPanel의 btn_itemPricePanel 레퍼런스값을 받기 위한 변수, BtnPanel에서 활용
    public int totalPriceSum = 0;

    public BillPanel(Map<JButton, ItemPricePanel> btn_itemPricePanel) {
        this.btn_itemPricePanel = btn_itemPricePanel;
        GUI_Set();
    }

    public void GUI_Set() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(7, 1, 0, 1));
        setSize(350, 250);
    }

    public void setPriceSum() {
        totalPriceSum = 0;
        for (Object o : btn_itemPricePanel.values().toArray()) {
            ItemPricePanel tmp = (ItemPricePanel) o;
            totalPriceSum += tmp.totalPrice;
        }
    }
}
