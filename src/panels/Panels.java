package panels;

public class Panels {
    private static MenuPanel menuPanel;
    private static CategoryPanel categoryPanel;
    private static OrderPanel orderPanel;
    private static NorthPanel northPanel;

    public static void init() {
        menuPanel = new MenuPanel();
        categoryPanel = new CategoryPanel();
        orderPanel = new OrderPanel();
        northPanel = new NorthPanel();
    }

    public static MenuPanel getMenuPanel() { return menuPanel; }
    public static CategoryPanel getCategoryPanel() { return categoryPanel; }
    public static OrderPanel getOrderPanel() { return orderPanel; }
    public static NorthPanel getNorthPanel() { return northPanel; }
}
