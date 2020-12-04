package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondPage {

    public static void display() {
        Stage stage = new Stage();
        stage.setTitle("Menu");
        ImageView imgView = new ImageView(new Image("Capture.jpg"));
        GridPane pane = new GridPane();
        pane.setHgap(50);
        pane.setVgap(50);
        pane.setPadding(new Insets(10,10,10,10));
        HBox hBox, hBox1;
        hBox = new HBox(10);
        hBox1 = new HBox(10);

        VBox vBox;
        vBox = new VBox(10);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(imgView);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(pane);
        borderPane.setTop(stackPane);
        borderPane.setRight(hBox);
        borderPane.setBottom(vBox);
        borderPane.setLeft(hBox1);

        Button student,teacher,admission,notice,about,exit,back;

        student=new Button("Student");
        teacher=new Button("Teacher");
        notice=new Button("Notice");
        admission=new Button("Admission");
        about=new Button("About");
        exit=new Button("Exit");

        student.setMinWidth(200);
        student.setMaxHeight(40);
        teacher.setMinWidth(200);
        teacher.setMaxHeight(40);
        notice.setMinWidth(200);
        notice.setMaxHeight(40);
        admission.setMaxHeight(40);
        admission.setMaxHeight(40);
        about.setMinWidth(200);
        about.setMaxHeight(40);
        exit.setMinWidth(200);
        exit.setMaxHeight(40);

        student.setOnAction(e->{
            ClassView.displayStudent();
            stage.close();
        });

        teacher.setOnAction(e->{
            TeacherList t = new TeacherList();
            try {
                t.display();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });

        notice.setOnAction(e->{
            NoticeBoard.displayNotice();
            stage.close();
        });

        admission.setOnAction(e->{
            StudentAdmissionForm.display();
            stage.close();
        });

        about.setOnAction(e->{
            AboutButton.display();
            stage.close();
        });

        exit.setOnAction(e->{
           Platform.exit();
        });
        student.setAlignment(Pos.BASELINE_LEFT);
        ImageView studentIcon = new ImageView(new Image("student.jpg"));
        student.setGraphic(studentIcon);
        student.setFont(Font.font("Bell MT",FontWeight.BOLD,22));

        teacher.setAlignment(Pos.BASELINE_LEFT);
        ImageView teacherIcon=new ImageView(new Image("Teacher.jpg"));
        teacher.setGraphic(teacherIcon);
        teacher.setFont(Font.font("Bell MT",FontWeight.BOLD,22));

        notice.setAlignment(Pos.BASELINE_LEFT);
        ImageView noticeIcon=new ImageView(new Image("notice.jpg"));
        notice.setGraphic(noticeIcon);
        notice.setFont(Font.font("Bell MT",FontWeight.BOLD,22));

        about.setAlignment(Pos.BASELINE_LEFT);
        ImageView aboutIcon=new ImageView(new Image("about.jpg"));
        about.setGraphic(aboutIcon);
        about.setFont(Font.font("Bell MT",FontWeight.BOLD,22));

        admission.setAlignment(Pos.BASELINE_LEFT);
        ImageView admissionIcon=new ImageView(new Image("admission.jpg"));
        admission.setGraphic(admissionIcon);
        admission.setFont(Font.font("Bell MT",FontWeight.BOLD,22));

        exit.setAlignment(Pos.BASELINE_LEFT);
        ImageView exitIcon=new ImageView(new Image("exit.jpg"));
        exit.setGraphic(exitIcon);
        exit.setFont(Font.font("Bell MT",FontWeight.BOLD,22));

        GridPane.setConstraints(student,0,0);
        GridPane.setConstraints(teacher,1,0);
        GridPane.setConstraints(notice,2,0);
        GridPane.setConstraints(admission,0,1);
        GridPane.setConstraints(about,1,1);
        pane.getChildren().addAll(student,teacher,notice,admission,about);
        pane.setAlignment(Pos.CENTER);

        vBox.getChildren().add(exit);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(20,60,60,60));
        vBox.getStyleClass().add("buttonSecondPage");

        Scene scene=new Scene(borderPane,1300,720);
        scene.getStylesheets().add("background.css");
        stage.setScene(scene);
        stage.show();
    }
}
