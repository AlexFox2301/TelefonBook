package controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

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
    }
}
