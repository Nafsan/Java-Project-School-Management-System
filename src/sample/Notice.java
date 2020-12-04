package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;

public class Notice {
    Hyperlink hyperlink;
    String description;

    public Notice(Hyperlink hyperlink, String description) {
        this.hyperlink = hyperlink;
        this.description = description;
        init();
    }
    public Notice(){
        hyperlink=new Hyperlink();
        description=null;
        init();
    }

    public Hyperlink getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(Hyperlink hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void init()
    {
        hyperlink.setOnAction(e->{
            display();
        });
    }

    public void display() {
        Stage stage=new Stage();
        StackPane stackPane=new StackPane();
        ImageView imageView = new ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().addAll(imageView);

        Label label = new Label(description);
        label.setFont(Font.font("Bell MT",20));

        VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setPadding(new Insets(15,15,1,15));
        vBox.getChildren().addAll(label);
        HBox hBox=new HBox(350);
        hBox.setPadding(new Insets(10,10,10,50));

        Button back,exit,addNotice;
        back=new Button("Back");
        back.setMinWidth(150);
        ImageView backIcon=new ImageView(new Image("back.jpg"));
        back.setGraphic(backIcon);


        exit=new Button("Exit");
        exit.setMinWidth(150);
        ImageView exitIcon=new ImageView(new Image("exit.jpg"));
        exit.setGraphic(exitIcon);
        back.setOnAction(e->{
            NoticeBoard noticeBoard=new NoticeBoard();
            noticeBoard.displayNotice();
            stage.close();
        });
        exit.setOnAction(e->{
            Platform.exit();
        });


        hBox.getChildren().addAll(back,exit);
        hBox.getStyleClass().add("buttonSecondPage");

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);


        Scene scene=new Scene(borderPane,1300,700);
        stage.setScene(scene);
        stage.show();
    }
}
