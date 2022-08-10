package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFMainWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private JPMainPanel jpMainPanel;
    private JDialogAbout jdAbout;
    private JDREValidation jdValidationRE;
    private JDShowNFA jdShowNFA;
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
        jdShowNFA = new JDShowNFA(this);
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
    public void showNFA(){ jdShowNFA.setVisible(true); }

    public String getRE() {
        return jpMainPanel.getRE();
    }

    public void setElements(ArrayList<Object> states,ArrayList<Character> transitions,ArrayList<Object> endStates) {
        jdShowNFA.setElements(states, transitions,endStates);
    }
    public void openChooserFile(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Json", "json");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("SAVE!");
        }
    }
}
