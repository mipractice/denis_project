package controllers;

import dbconnection.impl.CityServiceImpl;
import dbconnection.impl.RegionServiceImpl;
import entity.CityEntity;
import entity.RegionEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
    @FXML
    private ComboBox<RegionEntity> cbRegion;

    private ObservableList<CityEntity> citiesObservableList;
    private ObservableList<RegionEntity> regionObservableList;
    public void initialize(URL location, ResourceBundle resources) {
        select();

    }

    private CityServiceImpl cityServ = new CityServiceImpl();
    private RegionServiceImpl regionServ = new RegionServiceImpl();
    private void select(){

        List<CityEntity> lsCity = cityServ.getAllcity();
        List<RegionEntity> lsRegion = regionServ.getAllRegion();

        //инициация листа
        citiesObservableList = FXCollections.observableArrayList();
        regionObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелисты для страны
        for (CityEntity city : lsCity) {
            citiesObservableList.add(new CityEntity(city.getCityid(),city.getCityname(),city.getRegion()));
        }

        for (RegionEntity region : lsRegion){
            regionObservableList.add(new RegionEntity(region.getRegionid(),region.getRegionname(),region.getCountry()));
        }
        //Заполняем таблевью из обсерваблелиста
        tvCities.setItems(citiesObservableList);
        tvCities.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        cbRegion.setItems(regionObservableList);
        // хз что это но без него не работает
        tcCityId.setCellValueFactory(new PropertyValueFactory<CityEntity, Integer>("cityid"));
        tcCityName.setCellValueFactory(new PropertyValueFactory<CityEntity, String>("cityname"));
        tcRegion.setCellValueFactory(new PropertyValueFactory<CityEntity, Integer>("region"));
    }

    public void AddCitybtnClick (){
        CityEntity city = new CityEntity();
        city.setCityname(tfCityName.getText());
        city.setRegion(cbRegion.getSelectionModel().getSelectedItem());
        cityServ.addCity(city);
        select();
    }
    public void DelCitybtnClick (){
        cityServ.deleteCity(tvCities.getSelectionModel().getSelectedItem().getCityid());
        select();
    }
}
