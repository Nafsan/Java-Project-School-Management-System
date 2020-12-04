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

public class NoticeBoard {
    public static void displayNotice() {
        Stage stage=new Stage();

        StackPane stackPane=new StackPane();
        javafx.scene.image.ImageView imageView=new javafx.scene.image.ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().addAll(imageView);

        VBox vBox=new VBox(15);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setPadding(new Insets(15,15,1,15));

        File file=new File("Notice Board.txt");
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String string;
            Notice notice;
            Label label = null;
            Hyperlink hyperlink;
            String description,title;
            int line=0;
            while((title=bufferedReader.readLine()) != null) {
                String desc=bufferedReader.readLine();

                Hyperlink hyperlink1=new Hyperlink();
                hyperlink1.setText(title);
                hyperlink1.setFont(Font.font("Bell MT",22));
                notice=new Notice(hyperlink1,desc);
                vBox.getChildren().addAll(notice.getHyperlink());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        HBox hBox=new HBox(350);
        hBox.setPadding(new Insets(10,10,10,50));

        Button back,exit,addNotice;
        back=new Button("Back");
        back.setMinWidth(150);
        ImageView backIcon=new ImageView(new Image("back.jpg"));
        back.setGraphic(backIcon);

        addNotice =new Button("Add Notice");
        ImageView addNoticeIcon=new ImageView(new Image("addNoticeIcon.jpg"));
        addNoticeIcon.setFitHeight(50);
        addNoticeIcon.setFitWidth(50);
        addNotice.setGraphic(addNoticeIcon);
        addNotice.setOnAction(e->{
            AddNewNotice.display();
        });

        exit=new Button("Exit");
        exit.setMinWidth(150);
        ImageView exitIcon=new ImageView(new Image("exit.jpg"));
        exit.setGraphic(exitIcon);
        back.setOnAction(e->{
            SecondPage.display();
            stage.close();
        });
        exit.setOnAction(e->{
            Platform.exit();
        });
        hBox.getChildren().addAll(back,addNotice,exit);
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
