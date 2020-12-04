package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;
        window.setTitle("Student List");
        window.setMinWidth(200);
        window.setMinHeight(500);

        TableView<Student> tv;

        TableColumn<Student, String> name = new TableColumn<>("Name");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> classNo = new TableColumn<>("Class");
        classNo.setMinWidth(100);
        classNo.setCellValueFactory(new PropertyValueFactory<>("ClassNo"));
        classNo.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, String> roll = new TableColumn<>("Roll");
        roll.setMinWidth(100);
        roll.setCellValueFactory(new PropertyValueFactory<>("classRoll"));
        roll.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, Button> info = new TableColumn<>("");
        info.setMinWidth(200);
        info.setCellValueFactory(new PropertyValueFactory<>("info"));
        info.setStyle("-fx-alignment: CENTER;");

        tv = new TableView<>();
        tv.setItems(getStudents());
        tv.getColumns().addAll(name, classNo, roll, info);

        VBox vb = new VBox(20);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.getChildren().addAll(tv);

        Scene scene = new Scene(vb, 800, 300);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Student> getStudents() {
        ObservableList<Student> ol = FXCollections.observableArrayList();

        ol.add(new Student("Pial", 8, 23));

        ol.add(new Student("Showmik", 9, 15));

        ol.add(new Student("Nafsan", 8, 12));

        ol.add(new Student("Shuvo", 8, 24));

        ol.add(new Student("Pial", 8, 23));

        ol.add(new Student("Showmik", 9, 15));

        ol.add(new Student("Nafsan", 8, 12));

        ol.add(new Student("Shuvo", 8, 24));

        ol.add(new Student("Pial", 8, 23));

        ol.add(new Student("Showmik", 9, 15));

        ol.add(new Student("Nafsan", 8, 12));

        ol.add(new Student("Shuvo", 8, 24));

        ol.add(new Student("Pial", 8, 23));

        ol.add(new Student("Showmik", 9, 15));

        ol.add(new Student("Nafsan", 8, 12));

        ol.add(new Student("Shuvo", 8, 24));


        return ol;
    }
}
