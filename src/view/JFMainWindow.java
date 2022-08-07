package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFMainWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private JPMainPanel jpMainPanel;
    private JDialogAbout jdAbout;
    private JDREValidation jdValidationRE;
	public JFMainWindow(ActionListener controller) {
        this.setTitle(ConstantsGUI.TITLE_MAIN_WINDOW);
        this.setSize(new Dimension(900, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_MAIN_ICON)).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initDialogs();
        initComponents(controller);
    }

    private void initDialogs() {
        jdAbout = new JDialogAbout(this);
        jdValidationRE = new JDREValidation(this);
    }

    public void initComponents(ActionListener actionListener){
        jpMainPanel = new JPMainPanel(actionListener);
        this.add(jpMainPanel);
    }

    public void showAboutDialog(){
        jdAbout.setVisible(true);
    }
    public void showDialogREValidation(String message){
        jdValidationRE.addText(message);
        jdValidationRE.setVisible(true);
    }

    public String getRE() {
        return jpMainPanel.getRE();
    }
}
