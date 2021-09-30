package com;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudents {

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    private Student student;

    public Student getStudent(){
        return student;
    }


    @FXML
    void onAdd(ActionEvent event) {

        student=new Student(idText.getText(),nameText.getText(),surnameText.getText());
        Node node = (Node) event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();


    }



}
