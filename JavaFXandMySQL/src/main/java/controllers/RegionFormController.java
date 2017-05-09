package controllers;

import dbconnection.impl.CountryServiceImpl;
import dbconnection.impl.RegionServiceImpl;
import entity.CountryEntity;
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
 * Created by DrSwitch on 03.05.2017.
 */
public class RegionFormController implements Initializable {

    @FXML
    private TableView<RegionEntity> tvRegions;
    @FXML
    private TableColumn<RegionEntity, Integer> tcRegionId;
    @FXML
    private TableColumn<RegionEntity, String> tcRegionName;
    @FXML
    private TableColumn<RegionEntity, Integer> tcCountryName;
    @FXML
    private TextField tfRegionName;
    @FXML
    private ComboBox<CountryEntity> cbCountry;

    private ObservableList<RegionEntity> regionsObservableList;
    private ObservableList<CountryEntity> countriesObservableList;

    public void initialize(URL location, ResourceBundle resources) {
        select();

    }

    private RegionServiceImpl regionServ = new RegionServiceImpl();
    private CountryServiceImpl countryServ = new CountryServiceImpl();
    private void select(){

        List<RegionEntity> lsRegion = regionServ.getAllRegion();
        List<CountryEntity> lsCountry = countryServ.getAllCountry();

        //инициация листа
        regionsObservableList = FXCollections.observableArrayList();
        countriesObservableList = FXCollections.observableArrayList();
        //заполняем обсерваблелисты для страны
        for (RegionEntity region : lsRegion) {
            regionsObservableList.add(new RegionEntity(region.getRegionid(),region.getRegionname(),region.getCountry()));
        }

        for (CountryEntity country : lsCountry){
            countriesObservableList.add(new CountryEntity(country.getCountryid(),country.getCountryname()));
        }

        cbCountry.setItems(countriesObservableList);
        //Заполняем таблевью из обсерваблелиста
        tvRegions.setItems(regionsObservableList);
        tvRegions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // хз что это но без него не работает
        tcRegionId.setCellValueFactory(new PropertyValueFactory<RegionEntity, Integer>("regionid"));
        tcRegionName.setCellValueFactory(new PropertyValueFactory<RegionEntity, String>("regionname"));
        tcCountryName.setCellValueFactory(new PropertyValueFactory<RegionEntity, Integer>("country"));
    }

    public void AddRegionbtnClick(){
        RegionEntity region = new RegionEntity();
        region.setRegionname(tfRegionName.getText());
        region.setCountry(cbCountry.getSelectionModel().getSelectedItem());
        regionServ.addRegion(region);
        select();

    }

    public void DelRegionbtnClick(){
        regionServ.deleteRegion(tvRegions.getSelectionModel().getSelectedItem().getRegionid());
        select();
    }


}
