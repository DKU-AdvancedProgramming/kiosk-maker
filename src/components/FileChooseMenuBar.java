package components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import panels.Kiosk;

public class FileChooseMenuBar extends  JMenuBar {//메뉴바
    JMenuItem editMenuitem, openMenuitem, newMenuitem;
    public FileChooseMenuBar() {
        JMenu fileMenu = new JMenu("파일");

        editMenuitem = new Edit();
        openMenuitem = new Open();
        newMenuitem = new New();

        fileMenu.add(editMenuitem);
        fileMenu.add(openMenuitem);
        fileMenu.add(newMenuitem);

        add(fileMenu);

    }
    /**********************************************/
    private class Edit extends JMenuItem
            implements ActionListener {
        public Edit() {
            super("편집");
            addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" edit preform");
        }
    }
    /**********************************************/
    private class Open extends JMenuItem
            implements ActionListener {
        public Open() {
            super("열기");
            addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Kiosk.openAnotherFile(new File("info\\Pizza.txt"));
        }
    }
    /**********************************************/
    private class New extends JMenuItem
            implements ActionListener {
        public New() {
            super("새로 만들기");
            addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("new preform");
        }
    }

}
