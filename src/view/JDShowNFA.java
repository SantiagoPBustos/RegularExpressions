package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class JDShowNFA extends JDialog {
    private JPanel jpContainer;
    private DefaultTableModel dtmElementsTable;
    private JTable jtRequest;
    private JScrollPane jScrollPaneRequest;

    public DefaultTableModel getDtmElementsTable() {
        return dtmElementsTable;
    }
    public void setDtmElementsTable(DefaultTableModel dtmElementsTable) {
        this.dtmElementsTable = dtmElementsTable;
    }

    public JDShowNFA(JFMainWindow jfMainWindow){
        setModal(true);
        this.setTitle(ConstantsGUI.TITLE_MENU_ABOUT);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_MAIN_ICON)).getImage());
        this.setMinimumSize(new Dimension(520, 500));
        this.setLocationRelativeTo(jfMainWindow);
        this.initComponents();
    }

    private void initComponents() {
        jpContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpContainer.setBackground(Color.WHITE);

        dtmElementsTable= new DefaultTableModel();
        dtmElementsTable.setColumnIdentifiers(this.asignHeadersTable());

        jtRequest=new JTable();
        jtRequest.setModel(dtmElementsTable);
        jtRequest.getTableHeader().setReorderingAllowed(false);
        jtRequest.getTableHeader().setBackground(Color.GRAY);
        jtRequest.getTableHeader().setPreferredSize(new Dimension(0,30));
        jtRequest.getTableHeader().setForeground(Color.WHITE);
        jtRequest.setBackground(Color.WHITE);
        jtRequest.setFillsViewportHeight(true);
        jtRequest.setRowHeight(25);

        asignWidthHeaders(0,150);
        asignWidthHeaders(1,150);
        centerTextInCell();

        jScrollPaneRequest=new JScrollPane(jtRequest);
        jScrollPaneRequest.setForeground(Color.WHITE);
        jScrollPaneRequest.setBorder(null);
        jScrollPaneRequest.setAlignmentX(Component.LEFT_ALIGNMENT);
        jpContainer.add(jScrollPaneRequest);

        this.add(jpContainer);
    }

    private void centerTextInCell() {
        DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer();
        centerModel.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < dtmElementsTable.getColumnCount(); i++) {
            jtRequest.getColumnModel().getColumn(i).setCellRenderer(centerModel);
        }
    }

    private void asignWidthHeaders(int NumberHeader,int widthHeader) {
        TableColumn column;
        column=jtRequest.getColumnModel().getColumn(NumberHeader);
        column.setPreferredWidth(widthHeader);
        column.setMinWidth(widthHeader);
        column.setMaxWidth(widthHeader);
    }
    private String[] asignHeadersTable() {
        String[] headers = {
                ConstantsGUI.TITLE_INITIAL,
                ConstantsGUI.TITLE_TRANSITION,
                ConstantsGUI.TITLE_FINAL,
        };
        return headers;
    }

    public void setElements(ArrayList<Object> states,ArrayList<Character> transitions,ArrayList<Object> endStates){
        int x = 0;
        int y = 0;
        for (Object object: states) {
            addStatesToTable(object,x,y);
            y++;
            for (Object object2: transitions) {
                addTransitionsToTable(object2,x,y);
                y++;
                for (Object object3: endStates) {
                    addDestinyToTable(object3,x,y);
                    x++;
                }
            }
        }
    }

    public void addStatesToTable(Object vector,int x,int y){
        dtmElementsTable.setNumRows(1);
        dtmElementsTable.setValueAt(vector,x,y);
    }

    public void addTransitionsToTable(Object vector,int x,int y){
        dtmElementsTable.setValueAt(vector,x,y);
    }

    public void addDestinyToTable(Object vector,int x,int y){
        dtmElementsTable.setValueAt(vector,x,y);
    }
}
