package controllers;

import dbconnection.impl.RegionServiceImpl;
import entity.RegionEntity;
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

    private ObservableList<RegionEntity> RegionsObservableList;

    public void initialize(URL location, ResourceBundle resources) {
        select();

    }

    private RegionServiceImpl regionServ = new RegionServiceImpl();
    private void select(){

        List<RegionEntity> lsRegion = regionServ.getAllRegion();

        //инициация листа
        RegionsObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелисты для страны
        for (RegionEntity region : lsRegion) {
            RegionsObservableList.add(new RegionEntity(region.getRegionid(),region.getRegionname(),region.getCountryid()));
        }

        //Заполняем таблевью из обсерваблелиста
        tvRegions.setItems(RegionsObservableList);
        tvRegions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // хз что это но без него не работает
        tcRegionId.setCellValueFactory(new PropertyValueFactory<RegionEntity, Integer>("regionid"));
        tcRegionName.setCellValueFactory(new PropertyValueFactory<RegionEntity, String>("regionname"));
        tcCountryName.setCellValueFactory(new PropertyValueFactory<RegionEntity, Integer>("countryid"));
    }


public void AddRegionbtnClick(){


}

public void DelRegionbtnClick(){}
}
