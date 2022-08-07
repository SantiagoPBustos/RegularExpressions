package control;

import models.ValidateRE;
import view.ConstantsGUI;
import view.JFMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private JFMainWindow jfMainWindow;
    private ValidateRE validateRE;

    public Controller() {
        validateRE = new ValidateRE();
        jfMainWindow = new JFMainWindow(this);
        jfMainWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (Commands.valueOf(e.getActionCommand())) {
                case C_SHOW_ABOUT:
                    jfMainWindow.showAboutDialog();
                    break;
                case C_OPEN:

                    break;
                case C_SAVE:

                    break;
                case C_CONVERT_TO_NFA:

                    break;
                case C_EXIT:
                    this.manageExitApp();
                case C_VALIDATE_RE:
                    jfMainWindow.showDialogREValidation(validateRE.isRE(jfMainWindow.getRE()));
                    break;
                default:
                    break;
            }
        }catch (Exception e2) {
            System.out.println(e2);
        }
    }

    private void manageExitApp() {
        int option = JOptionPane.showConfirmDialog(null, ConstantsGUI.MESSAGE_EXIT_APP, ConstantsGUI.T_EXIT,
                JOptionPane.NO_OPTION);
        if (option == 0) {
            System.exit( 0 );
        }
    }
}
