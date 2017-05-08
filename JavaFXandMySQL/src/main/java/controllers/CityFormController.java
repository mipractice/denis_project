package controllers;

import dbconnection.impl.CityServiceImpl;
import entity.CityEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by DrSwitch on 30.04.2017.
 */
public class CityFormController  implements Initializable {

    @FXML
    private TableView<CityEntity> tvCities;
    @FXML
    private TableColumn<CityEntity, Integer> tcCityId;
    @FXML
    private TableColumn<CityEntity, String> tcCityName;
    @FXML
    private TableColumn<CityEntity, Integer> tcRegion;
    @FXML
    private TextField tfCityName;

    private ObservableList<CityEntity> citiesObservableList;
    public void initialize(URL location, ResourceBundle resources) {
        select();

    }

    private CityServiceImpl cityServ = new CityServiceImpl();
    private void select(){

        List<CityEntity> lsCity = cityServ.getAllcity();

        //инициация листа
        citiesObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелисты для страны
        for (CityEntity city : lsCity) {
            citiesObservableList.add(new CityEntity());
        }

        //Заполняем таблевью из обсерваблелиста
        tvCities.setItems(citiesObservableList);
        tvCities.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // хз что это но без него не работает
        tcCityId.setCellValueFactory(new PropertyValueFactory<CityEntity, Integer>("cityid"));
        tcCityName.setCellValueFactory(new PropertyValueFactory<CityEntity, String>("cityname"));
        tcRegion.setCellValueFactory(new PropertyValueFactory<CityEntity, Integer>("regionid"));
    }

    public void AddCitybtnClick (){

    }
    public void DelCitybtnClick (){


    }
}
