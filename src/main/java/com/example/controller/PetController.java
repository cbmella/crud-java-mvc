package com.example.controller;

import com.example.model.PetModel;
import com.example.view.PetView;

import java.util.Vector;

public class PetController {
    private PetModel model;
    private PetView view;

    public PetController(PetModel model, PetView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Name");
        columnNames.add("Location");
        columnNames.add("Photo URL");

        Vector<Vector<Object>> data = model.getAllPets();
        view.setTableData(data, columnNames);
    }
}
