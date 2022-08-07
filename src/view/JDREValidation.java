package view;

import view.ConstantsGUI;
import view.JFMainWindow;

import javax.swing.*;
import java.awt.*;

public class JDREValidation extends JDialog {

    private JPanel jpContainer;
    private JLabel jlText;
    JDREValidation(JFMainWindow jfMainWindow){
        setModal(true);
        this.setTitle(ConstantsGUI.TITLE_VALIDATE_RE);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_MAIN_ICON)).getImage());
        this.setMinimumSize(new Dimension(300, 90));
        this.setLocationRelativeTo(jfMainWindow);
        this.initComponents();
    }

    private void initComponents() {
        jpContainer = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
        jpContainer.setBackground(Color.WHITE);
        jlText = new JLabel();
        jpContainer.add(jlText);
        this.add(jpContainer);
    }

    public void addText(String message){
        jlText.setText(message);
    }
}
