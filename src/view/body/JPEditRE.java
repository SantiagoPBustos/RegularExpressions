package view.body;

import control.Commands;
import view.ConstantsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPEditRE extends JPanel {
    private JTextField jtaRE;
    private JButton jbValidateRE;
    private JButton jbConvertNFA;

    public JPEditRE(ActionListener actionListener){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        JPanel jpHgap = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpHgap.setPreferredSize(new Dimension(900,75));
        jpHgap.setBackground(Color.WHITE);
        this.add(jpHgap);

        this.add(new JLabel(ConstantsGUI.TITLE_VALIDATE_RE_LABEL));

        JPanel jpHgap2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpHgap2.setPreferredSize(new Dimension(900,75));
        jpHgap2.setBackground(Color.WHITE);
        this.add(jpHgap2);

        this.add(new JLabel(ConstantsGUI.TITLE_ENTRY_TEXT));

        jtaRE = new JTextField(60);
        this.add(jtaRE);

        jbValidateRE = new JButton(ConstantsGUI.TITLE_VALIDATE_RE);
        jbValidateRE.addActionListener(actionListener);
        jbValidateRE.setActionCommand(Commands.C_VALIDATE_RE.toString());
        this.add(jbValidateRE);

        jbConvertNFA = new JButton(ConstantsGUI.TITLE_MENU_ITEM_CONVERT);
        jbConvertNFA.addActionListener(actionListener);
        jbConvertNFA.setActionCommand(Commands.C_CONVERT_TO_NFA.toString());
        this.add(jbConvertNFA);
    }

    public String getRE() {
        return jtaRE.getText();
    }
}
