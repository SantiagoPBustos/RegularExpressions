package control;

import models.Nfa;
import models.ValidateRE;
import view.ConstantsGUI;
import view.JFMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private JFMainWindow jfMainWindow;
    private ValidateRE validateRE;
    private Nfa controllerNFA;

    public Controller() {
        validateRE = new ValidateRE();
        controllerNFA = new Nfa();
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
                case C_SAVE:
                    jfMainWindow.openChooserFile();
                    break;
                case C_CONVERT_TO_NFA:
                    controllerNFA.automata(jfMainWindow.getRE());
                    jfMainWindow.setElements(controllerNFA.State(),controllerNFA.Transition(),controllerNFA.Destiny());
                    jfMainWindow.showNFA();
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
            JOptionPane.showMessageDialog(null,e2,e2.toString(),JOptionPane.ERROR_MESSAGE);
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
