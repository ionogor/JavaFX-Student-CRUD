package com;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Edit {

    private Student student;
    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    @FXML
    void onAdd(ActionEvent event) {

        this.student=new Student(idText.getText(),nameText.getText(),surnameText.getText());

        Node node = (Node) event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();


    }


    public void setStudent(Student student){

        this.idText.setText(student.getId());
        this.nameText.setText(student.getName());
        this.surnameText.setText(student.getSurname());
    }


    public Student getStudent() {
        return this.student;

    }
    @FXML
    void onClose(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }

}
