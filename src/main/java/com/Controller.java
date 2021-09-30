package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sun.plugin.javascript.JSObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button delete;
    @FXML
    private TableView<Student> table;
    private ObservableList<Student> studentsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        extracted();
        this.table.setItems(initData());



    }

    private void extracted() {
        TableColumn<Student, String> nameColumn=new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> surname=new TableColumn<>("Surname");
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<Student, String> idColumn=new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.table.getColumns().addAll(idColumn,nameColumn,surname);




    }

    private ObservableList<Student> initData() {
        List<Student> emps = new ArrayList<>();
        //emps.add(new Student("name","surname","1")); o sa afisam datele din baza
        this.studentsList = FXCollections.observableArrayList(emps);


        return this.studentsList;
    }
    @FXML
    void onAdd(ActionEvent event) throws IOException {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/addStudent.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Student");

        stage.showAndWait();

        AddStudents addStudents=loader.getController();

        Student student=addStudents.getStudent();

       this.studentsList.add(student);

    }

    @FXML
    void onDelete(ActionEvent event) throws IOException {
        int idx=table.getSelectionModel().getSelectedIndex();

        if(idx>-1){
        this.studentsList.remove(idx);
        }

    }

    @FXML
    void onExport(ActionEvent event) {

        // write data to json object
        // ObjectMapper mapper = new ObjectMapper();
        //  mapper.writeValue(new File("c:\\country.json"), countryObj );


    }




    @FXML
    void onEdit(ActionEvent event) throws IOException {

        Student student=this.table.getSelectionModel().getSelectedItem();

        Integer idx=this.table.getSelectionModel().getSelectedIndex();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/edit.fxml"));
        Parent parent=loader.load();
        //incarcam info din table in textField
        Edit edit=loader.getController();
        edit.setStudent(student);
        //Construim o scena noua
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Editare Student");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    Edit editStudent=loader.getController();

     Student newStudent=editStudent.getStudent();

     this.studentsList.set(idx,newStudent);

    }



}
