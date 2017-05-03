package controllers;
import dbconnection.StudentServiceImpl;
import dbconnection.CityServiceImpl;

import entity.CityEntity;
import entity.StudentEntity;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

//логика взаимодействия с MainForm.fxml
public class MainFormController  implements Initializable {

    @FXML
    private Label lbText;
    @FXML
    private TextField tfFIO;
    @FXML
    private TextField tfAddress;
    @FXML
    private TableView<StudentEntity> tvMainTableStudent;
    @FXML
    private TableColumn<StudentEntity, Integer> tcIdStudent;
    @FXML
    private TableColumn<StudentEntity, String> tcFIO;
    @FXML
    private TableColumn<StudentEntity, String> tcAddress;
    @FXML
    private TableColumn<StudentEntity, String> tcCity;
    @FXML
    private ComboBox<CityEntity> cbCity;

    private ObservableList<StudentEntity> userObservableList = FXCollections.observableArrayList();

    private ObservableList<CityEntity> cityNamesObservableList= FXCollections.observableArrayList();

    private StudentServiceImpl studServ = new StudentServiceImpl();

    private CityServiceImpl cityServ = new CityServiceImpl();

    //эта хрень запускается и делает код во время загруски формы или типа того
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        select();
    }

    public void btnclick(ActionEvent actionEvent){
        select();
    }

    public void select(){
        List<StudentEntity> lsStudent = studServ.getAllStudent();
        List<CityEntity> lsCity = cityServ.getAllcity();

        //инициация листа
        userObservableList = FXCollections.observableArrayList();
        cityNamesObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелист для студента
        for (StudentEntity student : lsStudent){
            userObservableList.add(new StudentEntity(
                    student.getStudentid(),
                    student.getFio(),
                    student.getAddress(),
                    student.getCity()));

        }
        //заполняем обсерваблелисты для города
        for (CityEntity city : lsCity) {
            cityNamesObservableList.add(new CityEntity(city.getCityid(),city.getCityname()));
        }

        //заполняем кобобох из обсерваблелиста
        cbCity.setItems(cityNamesObservableList);
        //Заполняем таблевью из обсерваблелиста
        tvMainTableStudent.setItems(userObservableList);

        tvMainTableStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // хз что это но без него не работает
        tcIdStudent.setCellValueFactory(new PropertyValueFactory<StudentEntity, Integer>("studentid"));
        tcFIO.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("fio"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("Address"));
        tcCity.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("city"));
    }

    public  void Insertbtnclick(ActionEvent actionEvent){

        StudentEntity student = new StudentEntity();

        student.setFio(tfFIO.getText());
        student.setAddress(tfAddress.getText());
        student.setCity(cbCity.getSelectionModel().getSelectedItem());

        studServ.addStudent(student);

  //      lbText.setText("name City = " + cbCity.getSelectionModel().getSelectedItem().getCityname()
     //           +"\nid City = " + cbCity.getSelectionModel().getSelectedItem().getIdcity());

        System.out.println(student);

        select();
    }

    public  void  Deletebtnclick(ActionEvent actionEvent){

       // lbText.setText("ID = "+tvMainTableStudent.getSelectionModel().getSelectedItem().getID_Student());

        studServ.deleteStudent(tvMainTableStudent.getSelectionModel().getSelectedItem().getStudentid());

        select();
        tvMainTableStudent.refresh();
    }
    public  void CountrybtnClick(){

    }
    public  void RegionbtnClick(){

    }

    public  void CitybtnClick(ActionEvent actionEvent) throws Exception{
        try {
            Stage stage = new Stage();

            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("FORMS/CityForm.fxml"));
            stage.setTitle("Страна");
            stage.setScene(new Scene(parent, 430, 400));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}