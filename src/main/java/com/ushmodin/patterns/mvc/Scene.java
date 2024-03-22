package com.ushmodin.patterns.mvc;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Scene {
    private JPanel panel1;
    private JTable table1;
    private JPanel graph;

    private DefaultTableModel tableModel;

    private Model model;
    private Controller controller;

    public JPanel getPanel() {
        return panel1;
    }
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    private void createUIComponents() {
        model = new Model();
        graph = new FunctionGraph(model);
        controller = new Controller(model,this);


        graph.setSize(300,300);
        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        tableModel.addColumn("X");
        tableModel.addColumn("Y");

        tableModel.addRow(new Object[]{"",""});

        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getColumn() == 0){
                    if ((e.getLastRow() + 1) == tableModel.getRowCount()) {
                        if (!tableModel.getValueAt(e.getLastRow(), 0).toString().equals(""))
                            tableModel.addRow(new Object[]{"", ""});
                    } else if (tableModel.getValueAt(e.getLastRow(), 0).equals("")) {
                        tableModel.removeRow(e.getLastRow());
                    }
                    controller.updateModel();
                    graph.repaint();
                }
            }
        });


        table1 = new JTable(tableModel);

        table1.setDefaultEditor(Object.class,new MyCellEditor());

    }



    static class MyCellEditor extends DefaultCellEditor {
        public MyCellEditor() {
            super(new JTextField());
        }

        public static boolean checkValid(final String text) {
            System.out.println("parsed:" + text);
            if(text == null || text.isEmpty())
                return true;
            try {
                double d = Double.parseDouble(text);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
        @Override
        public boolean stopCellEditing() {

            final JTextField field = (JTextField) getComponent();
            if (checkValid(field.getText())) {
                //field.setBackground(Color.WHITE);
                return super.stopCellEditing(); //Fires 'editing stopped' event and returns true.
            }
            Toolkit.getDefaultToolkit().beep();
            //field.setBackground(Color.ORANGE.darker());
            JOptionPane.showMessageDialog(field, "You must enter a number!", "Oups!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
