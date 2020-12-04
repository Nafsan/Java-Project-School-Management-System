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

import javax.swing.border.Border;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class showDescription {
    public static void display()
    {
        Stage stage=new Stage();
        StackPane stackPane=new StackPane();
        ImageView imageView=new ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().addAll(imageView);

        VBox vBox=new VBox(10);
        File file=new File("Notice Board.txt");
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            Label label;
            String description,title;
            int line=0;
            while((title=bufferedReader.readLine()) != null) {
                String desc=bufferedReader.readLine();
                label=new Label();
                label.setText(desc);
                label.setFont(Font.font("Bell MT",20));

                vBox.getChildren().addAll(label);
                vBox.setPadding(new Insets(20,20,20,20));

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        HBox hBox =new HBox(10);
        hBox.setPadding(new Insets(20,20,20,20));

        Button back,exit;
        back=new Button("Back");
        back.setMinWidth(150);
        javafx.scene.image.ImageView backIcon=new javafx.scene.image.ImageView(new Image("back.jpg"));
        back.setGraphic(backIcon);

        exit=new Button("Exit");
        exit.setMinWidth(150);
        javafx.scene.image.ImageView exitIcon=new javafx.scene.image.ImageView(new Image("exit.jpg"));
        exit.setGraphic(exitIcon);
        back.setOnAction(e->{
            NoticeBoard.displayNotice();
            stage.close();
        });
        exit.setOnAction(e->{
            Platform.exit();
        });

        hBox.getChildren().addAll(back,exit);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);

        Scene scene=new Scene(borderPane,1300,700);
        stage.setScene(scene);
        stage.show();
    }
}
