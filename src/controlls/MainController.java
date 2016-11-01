package controlls;

import interfaces.impls.CollectionAdresBook;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import object.Person;

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

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;


    @FXML
    private void initialize() {

//        tableAdresBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        adresBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });

        adresBookImpl.fillTestData();

        tableAdresBook.setItems(adresBookImpl.getPersonList());


        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {e.printStackTrace();}




    }

    private void updateCountLabel(){
        lableCount.setText("Количество записей: "+adresBookImpl.getPersonList().size());

    }

    public void actionButtonPressed(ActionEvent actionEvent){

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)){return;}

        Button clickedButton = (Button) source;
        Person selectedPerson = (Person) tableAdresBook.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();

        editDialogController.setPerson(selectedPerson);

        switch (clickedButton.getId()) {
            case "btnAdd": break;

            case "btnEdit":
                showDialog(parentWindow);
                break;
            case "btnDelete": break;
        }
    }



    private void showDialog(Window parentWindow){

        if (editDialogStage==null){
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(parentWindow);
        }

        editDialogStage.show();

//        Object source = actionEvent.getSource();
//
//        if (!(source instanceof Button)) {return;}
//
//        Button clickedBitton = (Button) source;
//
//        Person selectePerson = (Person) tableAdresBook.getSelectionModel().getSelectedItem();
//
//        switch (clickedBitton.getId()){
//            case "btnAdd":
//                System.out.println("add"+selectePerson);
//                break;
//            case "btnEdit":
//                System.out.println("edit"+selectePerson);
//                break;
//            case "btnDelete":
//                System.out.println("delete"+selectePerson);
//                break;
//        }
//
//        try {
//            Stage stage= new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
//            stage.setTitle("Редактироввание записи");
//            stage.setMinHeight(120);
//            stage.setMinWidth(500);
//            stage.setResizable(false);
//            stage.setScene(new Scene(root));
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());//определение родительского окна
//            stage.show();
//        } catch (IOException e){
//            e.printStackTrace();
        }
    }//Модальное окно




}
