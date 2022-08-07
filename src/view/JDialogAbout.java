package view;

import javax.swing.*;
import java.awt.*;

public class JDialogAbout extends JDialog {

    private JPanel jpContainer;
    JDialogAbout(JFMainWindow jfMainWindow){
        setModal(true);
        this.setTitle(ConstantsGUI.TITLE_MENU_ABOUT);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_MAIN_ICON)).getImage());
        this.setMinimumSize(new Dimension(430, 140));
        this.setLocationRelativeTo(jfMainWindow);
        this.initComponents();
    }

    private void initComponents() {
        jpContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpContainer.setBackground(Color.WHITE);
        jpContainer.add(new JLabel(ConstantsGUI.TITLE_UNIVERSITY));
        jpContainer.add(new JLabel(ConstantsGUI.TITLE_SUBJECT));
        jpContainer.add(new JLabel(ConstantsGUI.TITLE_AUTORS));
        jpContainer.add(new JLabel(ConstantsGUI.TITLE_DATE));

        this.add(jpContainer);
    }
}
