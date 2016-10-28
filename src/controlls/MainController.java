package controlls;

import interfaces.AdresBook;
import interfaces.impls.CollectionAdresBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import object.Person;

import javax.swing.table.*;
import java.io.IOException;

public class MainController {

    private CollectionAdresBook adresBookImpl = new CollectionAdresBook();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView tableAdresBook;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private Label lableCount;


    @FXML
    private void initialize() {
        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        adresBookImpl.fillTestData();

        tableAdresBook.setItems(adresBookImpl.getPersonList());

        updateCountLabel();
    }

    private void updateCountLabel(){
        lableCount.setText("Количество записей: "+adresBookImpl.getPersonList().size());

    }



    public void showDialog(ActionEvent actionEvent){
        try {
            Stage stage= new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Редактироввание записи");
            stage.setResizable(false);
            stage.setMinHeight(120);
            stage.setMinWidth(500);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());//определение родительского окна
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }//Модальное окно




}
