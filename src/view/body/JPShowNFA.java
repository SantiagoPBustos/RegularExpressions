package view.body;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class JPShowNFA extends JPanel {

    public JPShowNFA(ActionListener actionListener){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents() {
    }

}
