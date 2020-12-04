package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FirstPage extends Application {
    Stage stage;
    Button button1;
    Label label1,label2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("School Management");

        VBox vBox,vBox1;
        vBox= new VBox(10);
        vBox1=new VBox(10);
        vBox.setPadding(new Insets(100,0,0,0));

        HBox hBox,hBox1;
        hBox = new HBox(10);
        hBox1 = new HBox(10);
        Hyperlink hyperlink = new Hyperlink("");

        StackPane stackPane = new StackPane();
        Image img = new Image("Capture.jpg");
        ImageView imgView = new ImageView(img);
        stackPane.getChildren().add(imgView);

        BorderPane borderPane = new BorderPane(vBox,stackPane,vBox1,hBox,hBox1);

        TextField idNo = new TextField();
        idNo.setMaxWidth(250);
        idNo.setPromptText("Id No");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setMaxWidth(250);

        Button exit = new Button("Exit");
        exit.setOnAction(e -> Platform.exit());
        exit.setAlignment(Pos.BASELINE_LEFT);
        ImageView exitIcon=new ImageView(new Image("exitFirstPage.jpg"));
        exit.setGraphic(exitIcon);
        exit.setFont(Font.font("Bell MT",16));

        Label error=new Label();
        Button login=new Button("Log In");
        login.setFont(Font.font("Bell MT",16));

        login.setOnAction(e->{
            String idName = idNo.getText();
            String passwordName = password.getText();
            LoginCheck log = new LoginCheck();
            try {
                if(log.check(idName, passwordName)) {
                    SecondPage.display();
                    stage.close();
                }
                else
                    wrongPassword.warning();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            error.getStyleClass().add("error");
        });

        label2 = new Label();

        label1 = new Label("Login");
        label1.getStyleClass().add("label1");

        button1 = new Button("Visit as a guest");
        button1.getStyleClass().add("loginButton");

        button1.setOnAction(e->{
            label2.setText("You're watching as a guest. You can watch only some featured contents. Login to see all");
            label2.getStyleClass().add("error");
            SecondPage.display();
            stage.close();
        });

        hBox.getChildren().add(exit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinWidth(150);
        hBox.setPadding(new Insets(20,20,20,20));

        vBox.setPadding(new Insets(0, 0, 10, 0));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label1, idNo, password, login, error, button1, label2);

        Scene scene = new Scene(borderPane, 1300, 720);
        scene.getStylesheets().add("background.css");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
