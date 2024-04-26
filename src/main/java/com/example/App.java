package com.example;

import com.example.controller.PetController;
import com.example.model.PetModel;
import com.example.view.PetView;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetModel model = new PetModel();
            PetView view = new PetView();
            new PetController(model, view);
        });
    }
}
