package start;

import interfaces.impls.CollectionAdresBook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import object.Person;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/sample.fxml"));
        primaryStage.setTitle("Телефонная книга");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();

        testData();
    }

    private void testData() {
        CollectionAdresBook adresBook = new CollectionAdresBook();

        Person person = new Person();
        person.setFlo("Test1");
        person.setPhone("123456789");

        Person person2 = new Person();
        person2.setFlo("Test 2");
        person2.setPhone("987654");

        adresBook.add(person);
        adresBook.add(person2);

        person.setPhone("1111111");

        adresBook.delete(person);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
