package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherList {

    public void display() throws IOException {
        Stage window = new Stage();
        window.setTitle("Student List");
        window.setMinWidth(200);
        window.setMinHeight(500);
        window.setOnCloseRequest(e -> {
            e.consume();
            SecondPage.display();
            window.close();
        });

        ImageView img = new ImageView(new Image("Capture.jpg"));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(img);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);

        TableView<Teacher> tv;

        TableColumn<Teacher, String> serial = new TableColumn<>("");
        serial.setMinWidth(30);
        serial.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        serial.setStyle("-fx-alignment: CENTER;");

        TableColumn<Teacher, String> name = new TableColumn<>("Name");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setStyle("-fx-alignment: CENTER;");

        TableColumn<Teacher, String> designation = new TableColumn<>("Designation");
        designation.setMinWidth(300);
        designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        designation.setStyle("-fx-alignment: CENTER;");

        TableColumn<Teacher, String> email = new TableColumn<>("Email");
        email.setMinWidth(400);
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        email.setStyle("-fx-alignment: CENTER;");

        TableColumn<Teacher, Button> info = new TableColumn<>("");
        info.setMinWidth(200);
        info.setCellValueFactory(new PropertyValueFactory<>("button"));
        info.setStyle("-fx-alignment: CENTER;");

        tv = new TableView<>();

        tv.setItems(TeacherLoader.getTeachers());
        tv.getColumns().addAll(serial, name, designation, email, info);

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
