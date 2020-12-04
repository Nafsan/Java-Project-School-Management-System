package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentList {

    public static void display() throws IOException {
        Stage window = new Stage();
        window.setTitle("Student List");
        window.setMinWidth(1300);

        window.setOnCloseRequest(e -> {
            e.consume();
            ClassView.displayStudent();
            window.close();
        });

        ImageView img = new ImageView(new Image("Capture.jpg"));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(img);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);

        TableView<Student> tv;

        TableColumn<Student, String> serial = new TableColumn<>("");
        serial.setMinWidth(30);
        serial.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        serial.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, String> name = new TableColumn<>("Name");
        name.setMinWidth(400);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, String> classNo = new TableColumn<>("Class");
        classNo.setMinWidth(100);
        classNo.setCellValueFactory(new PropertyValueFactory<>("ClassNo"));
        classNo.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, String> roll = new TableColumn<>("Roll");
        roll.setMinWidth(100);
        roll.setCellValueFactory(new PropertyValueFactory<>("classRoll"));
        roll.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, String> mobileNo = new TableColumn<>("Guardian Mobile No");
        mobileNo.setMinWidth(300);
        mobileNo.setCellValueFactory(new PropertyValueFactory<>("guardianMobileNo"));
        mobileNo.setStyle("-fx-alignment: CENTER;");

        TableColumn<Student, Button> info = new TableColumn<>("");
        info.setMinWidth(200);
        info.setCellValueFactory(new PropertyValueFactory<>("info"));
        info.setStyle("-fx-alignment: CENTER;");

        tv = new TableView<>();

        tv.setItems(StudentLoader.getStudents());
        tv.getColumns().addAll(serial, name, classNo, roll, mobileNo, info);

        VBox vb = new VBox(20);
        vb.setPadding(new Insets(10, 80, 10, 10));
        vb.getChildren().addAll(tv);
        vb.setAlignment(Pos.CENTER);

        borderPane.setCenter(vb);

        Scene scene = new Scene(borderPane, 1300, 700);
        window.setScene(scene);
        window.show();
    }
}
