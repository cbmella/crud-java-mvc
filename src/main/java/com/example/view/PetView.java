package com.example.view;

import javax.swing.*;
import java.util.Vector;

public class PetView extends JFrame {
    private JTable table;

    public PetView() {
        setTitle("CRUD con Swing");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setTableData(Vector<Vector<Object>> data, Vector<String> columnNames) {
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }
}
