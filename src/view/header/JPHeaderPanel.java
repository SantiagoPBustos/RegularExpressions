package view.header;

import control.Commands;
import view.ConstantsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JPHeaderPanel extends JPanel {

    private JMenuBar menuBar;
    private JMenu jmFile,jmConvert,jmAbout;
    private JMenuItem jmiOpen,jmiSave,jmiExit,jmiConvert,jmiAbout;

    public JPHeaderPanel(ActionListener actionListener){
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        // Principal Menu Bar
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);

        // Menu File
        jmFile = new JMenu(ConstantsGUI.TITLE_MENU_FILE);
        jmFile.setBackground(Color.WHITE);

        // Menu Item File/Open
        jmiOpen = new JMenuItem(ConstantsGUI.TITLE_MENU_ITEM_OPEN);
        jmiOpen.setBackground(Color.WHITE);
        jmFile.add(jmiOpen);

        // Menu Item File/Save
        jmiSave = new JMenuItem(ConstantsGUI.TITLE_MENU_ITEM_SAVE);
        jmiSave.setBackground(Color.WHITE);
        jmFile.add(jmiSave);

        // Menu Item File/Exit
        jmiExit = new JMenuItem(ConstantsGUI.TITLE_MENU_ITEM_EXIT);
        jmiExit.setBackground(Color.WHITE);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        jmiExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jmiExit.addActionListener(actionListener);
        jmiExit.setActionCommand(Commands.C_EXIT.toString());
        jmFile.add(jmiExit);

        menuBar.add(jmFile);

        // Menu Convert
        jmConvert = new JMenu(ConstantsGUI.TITLE_MENU_CONVERT);
        jmConvert.setBackground(Color.WHITE);

        // Menu Item Convert/to NFA
        jmiConvert = new JMenuItem(ConstantsGUI.TITLE_MENU_ITEM_CONVERT);
        jmiConvert.setBackground(Color.WHITE);

        jmConvert.add(jmiConvert);
        menuBar.add(jmConvert);

        // Menu Help
        jmAbout = new JMenu(ConstantsGUI.TITLE_MENU_ABOUT);
        jmAbout.setBackground(Color.WHITE);

        jmiAbout = new JMenuItem(ConstantsGUI.TITLE_MENU_ABOUT);
        jmiAbout.setBackground(Color.WHITE);
        jmiAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jmiAbout.addActionListener(actionListener);
        jmiAbout.setActionCommand(Commands.C_SHOW_ABOUT.toString());

        jmAbout.add(jmiAbout);
        menuBar.add(jmAbout);

        this.add(menuBar);
    }
}
