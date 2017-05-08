package controllers;

import dbconnection.impl.CountryServiceImpl;
import entity.CountryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
public class CountryFormController implements Initializable {

    @FXML
    private TableView<CountryEntity> tvCountries;
    @FXML
    private TableColumn<CountryEntity, Integer> tcCountryId;
    @FXML
    private TableColumn<CountryEntity, String> tcCountryName;
    @FXML
    private TextField tfCountryName;
    @FXML
    private Label lbTest;

    private ObservableList<CountryEntity> countriesObservableList;
    public void initialize(URL location, ResourceBundle resources) {
        select();

    }

    private CountryServiceImpl countryServ = new CountryServiceImpl();
    private void select(){

        List<CountryEntity> lsCountry = countryServ.getAllCountry();

        //инициация листа
        countriesObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелисты для страны
        for (CountryEntity country : lsCountry) {
            countriesObservableList.add(new CountryEntity(country.getCountryid(),country.getCountryname()));
        }

        //Заполняем таблевью из обсерваблелиста
        tvCountries.setItems(countriesObservableList);
        tvCountries.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // хз что это но без него не работает
        tcCountryId.setCellValueFactory(new PropertyValueFactory<CountryEntity, Integer>("countryid"));
        tcCountryName.setCellValueFactory(new PropertyValueFactory<CountryEntity, String>("countryname"));
    }


    public void AddCountrybtnClick(){
        CountryEntity country = new CountryEntity();
        country.setCountryname(tfCountryName.getText());
        countryServ.addCountry(country);
        select();
    }

    public void DelCountrybtnClick(){
        lbTest.setText("id = "+tvCountries.getSelectionModel().getSelectedItem().getCountryid());
        countryServ.deleteCountry(tvCountries.getSelectionModel().getSelectedItem().getCountryid());
        select();
    }

}
