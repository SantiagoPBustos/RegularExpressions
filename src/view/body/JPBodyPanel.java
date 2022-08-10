package view.body;

import view.ConstantsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPBodyPanel extends JPanel {

    private JTabbedPane jtpPrincipal;
    private JPEditRE jpEditRE;

    public JPBodyPanel(ActionListener actionListener){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jtpPrincipal = new JTabbedPane();
        jpEditRE = new JPEditRE(actionListener);
        jtpPrincipal.add(ConstantsGUI.TITLE_TAB_EDIT_RE,jpEditRE);
        jtpPrincipal.setFocusable(false);

        this.add(jtpPrincipal);
    }

    public String getRE() {
        return jpEditRE.getRE();
    }

}
