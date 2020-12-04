package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassView {
    public static void displayStudent() {
        Stage stage=new Stage();
        stage.setTitle("Student's information");
        stage.setMinWidth(1150);
        stage.setMinHeight(650);

        VBox vBox=new VBox(10);
        VBox vBox1=new VBox(10);
        HBox hBox, hBox1;
        hBox1=new HBox(10);
        GridPane pane=new GridPane();
        StackPane stackPane=new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        ImageView imgView = new ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().add(imgView);
        //Center-> top-> right-> bottum-> left
        BorderPane borderPane=new BorderPane(pane,stackPane,vBox1,vBox,hBox1);

        Button exitBtn,class3,class4,class5,class6,class7,class8,previous,hall1,hall2,hall3;
        class3=new Button("Class 3");
        class3.setFont(Font.font("Bell MT", FontWeight.BOLD,22));
        class3.setMinWidth(150);
        class3.setOnAction(e->{

        });

        class4=new Button("Class 4");
        class4.setMinWidth(150);
        class4.setFont(Font.font("Bell MT", FontWeight.BOLD,22));

        class5=new Button("Class 5");
        class5.setMinWidth(150);
        class5.setFont(Font.font("Bell MT", FontWeight.BOLD,22));

        class6=new Button("Class 6");
        class6.setMinWidth(150);
        class6.setFont(Font.font("Bell MT", FontWeight.BOLD,22));

        class7=new Button("Class 7");
        class7.setMinWidth(150);
        class7.setFont(Font.font("Bell MT", FontWeight.BOLD,22));

        class8=new Button("Class 8");
        class8.setMinWidth(150);
        class8.setFont(Font.font("Bell MT", FontWeight.BOLD,22));

        Button all = new Button("All Classes");
        all.setMinWidth(150);
        all.setFont(Font.font("Bell MT", FontWeight.BOLD,22));

        all.setOnAction(e -> {
            try {
                StudentList.display();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        previous=new Button("Back");
        previous.setMinWidth(150);
        previous.setFont(Font.font("Bell MT", FontWeight.BOLD,22));
        previous.setAlignment(Pos.BASELINE_LEFT);

        ImageView previousIcon=new ImageView(new Image("backThirdPage.jpg"));
        previous.setGraphic(previousIcon);
        previous.setOnAction(e->{
            SecondPage.display();
            stage.close();
        });

        exitBtn = new Button("Exit");
        exitBtn.setOnAction(e -> Platform.exit());
        exitBtn.setMinWidth(150);
        exitBtn.setFont(Font.font("Bell MT", FontWeight.BOLD,22));
        exitBtn.setAlignment(Pos.BASELINE_LEFT);
        ImageView exitIcon=new ImageView(new Image("exitFirstPage.jpg"));
        exitBtn.setGraphic(exitIcon);
        //exitBtn.getStyleClass().add("exitFirstPage");


        hall1=new Button("Amar Ekushey Hall");
        hall2=new Button("Shahidullah Hall");
        hall3=new Button("Fazlul Haque Hall");

        hall1.setMinWidth(150);
        hall2.setMinWidth(150);
        hall3.setMinWidth(150);

        Label label = new Label("Residential Halls");
        label.setStyle("-fx-font-size: 23");
        label.setStyle("-fx-font-weight: bold");

        vBox1.getChildren().addAll(label,hall1,hall2,hall3);
        vBox1.setPadding(new Insets(30,130,30,30));
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getStyleClass().add("Halls");


        GridPane.setConstraints(class3,0,0);
        GridPane.setConstraints(class4,1,0);
        GridPane.setConstraints(class5,2,0);
        GridPane.setConstraints(class6,0,1);
        GridPane.setConstraints(class7,1,1);
        GridPane.setConstraints(class8,2,1);
        GridPane.setConstraints(all   ,1, 2);
        GridPane.setConstraints(previous,2,3);
        pane.getChildren().addAll(class3,class4,class5,class6,class7,class8, all, previous);
        pane.setHgap(50);
        pane.setVgap(50);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getStyleClass().add("buttonSecondPage");
        pane.setAlignment(Pos.CENTER);

        vBox.getChildren().add(exitBtn);
        vBox.setPadding(new Insets(20,60,60,60));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.getStyleClass().add("buttonSecondPage");
        Scene scene=new Scene(borderPane,1300,720);
        stage.setScene(scene);
        scene.getStylesheets().add("background.css");
        stage.show();
    }
}