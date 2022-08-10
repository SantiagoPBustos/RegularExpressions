package view;

import view.body.JPBodyPanel;
import view.footer.JPFooterPanel;
import view.header.JPHeaderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPMainPanel extends JPanel {

    private JPBodyPanel jpBodyPanel;

    public JPMainPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.add(new JPHeaderPanel(actionListener),BorderLayout.NORTH);
        jpBodyPanel = new JPBodyPanel(actionListener);
        this.add(jpBodyPanel,BorderLayout.CENTER);
        this.add(new JPFooterPanel(actionListener),BorderLayout.SOUTH);
    }

    public String getRE() {
        return jpBodyPanel.getRE();
    }

}
