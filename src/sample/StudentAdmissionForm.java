package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class StudentAdmissionForm {
    public static void display(){
        Stage stage=new Stage();
        StackPane stackPane=new StackPane();
        ImageView imageView = new ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().addAll(imageView);

        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);

        HBox hBox=new HBox(25);

        Label label=new Label("Name");
        label.setMinWidth(200);
        label.setFont(Font.font("Bell MT",20));
        TextField textField=new TextField();
        textField.setPromptText("Name");
        hBox.getChildren().addAll(label,textField);

        HBox father=new HBox(25);

        Label fatherLabel=new Label("Father's Name");
        fatherLabel.setMinWidth(200);
        fatherLabel.setFont(Font.font("Bell MT",20));
        TextField FatherField=new TextField();
        FatherField.setPromptText("Father's Name");
        father.getChildren().addAll(fatherLabel,FatherField);

        HBox mother=new HBox(25);

        Label motherLabel=new Label("Mother's Name");
        motherLabel.setMinWidth(200);
        motherLabel.setFont(Font.font("Bell MT",20));
        TextField motherField=new TextField();
        motherField.setPromptText("Mother's Name");
        mother.getChildren().addAll(motherLabel,motherField);

        HBox classNo=new HBox(25);

        Label classLabel=new Label("Class");
        classLabel.setMinWidth(200);
        classLabel.setFont(Font.font("Bell MT",20));

        ComboBox<Integer>classNum;
        classNum=new ComboBox<>();
        classNum.setMinWidth(160);
        classNum.getItems().addAll(3,4,5,6,7,8);
        classNum.setValue(3);
        classNo.getChildren().addAll(classLabel,classNum);

        HBox dateOfBirth=new HBox(25);

        Label dateLabel=new Label("Date of Birth");
        dateLabel.setMinWidth(200);
        dateLabel.setFont(Font.font("Bell MT",20));

        ComboBox<Integer>date;
        date=new ComboBox<>();
        date.setValue(1);
        date.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ComboBox<Integer>month;
        month=new ComboBox<>();
        month.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        month.setValue(1);

        ComboBox<Integer>year;
        year=new ComboBox<>();
        year.getItems().addAll(2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013);
        year.setValue(2010);

        dateOfBirth.getChildren().addAll(dateLabel,date,month,year);

        HBox mobile=new HBox(25);

        Label mobileLabel=new Label("Mobile No");
        mobileLabel.setMinWidth(200);
        mobileLabel.setFont(Font.font("Bell MT",20));
        TextField mobileField=new TextField();
        mobileField.setPromptText("Mobile No");
        mobile.getChildren().addAll(mobileLabel,mobileField);

        HBox roll=new HBox(25);

        Label rollLabel=new Label("Roll");
        rollLabel.setMinWidth(200);
        rollLabel.setFont(Font.font("Bell MT",20));
        TextField rollField=new TextField();
        rollField.setPromptText("Roll");
        roll.getChildren().addAll(rollLabel,rollField);

        HBox address=new HBox(25);


        Label addressLabel=new Label("Address");
        addressLabel.setMinWidth(200);
        addressLabel.setFont(Font.font("Bell MT",20));
        TextArea addressArea=new TextArea();
        addressArea.setMaxHeight(50);
        addressArea.setPromptText("Address");
        address.getChildren().addAll(addressLabel,addressArea);

        HBox hall=new HBox(25);

        Label hallLabel=new Label("Hostel");
        hallLabel.setMinWidth(200);
        hallLabel.setFont(Font.font("Bell MT",20));

        ComboBox<String>hostel;
        hostel=new ComboBox<>();
        hostel.setValue("Shahidullah Hall");
        hostel.getItems().addAll("Shahidullah Hall","Fazlul Haque Hall","Amar Ekushey Hall");

        hall.getChildren().addAll(hallLabel,hostel);

        gridPane.setPadding(new Insets(20,20,20,100));
        GridPane.setConstraints(hBox,0,0);
        GridPane.setConstraints(father,0,1);
        GridPane.setConstraints(mother,0,2);
        GridPane.setConstraints(mobile,0,3);
        GridPane.setConstraints(classNo,0,4);
        GridPane.setConstraints(roll,0,5);
        GridPane.setConstraints(hall,0,6);
        GridPane.setConstraints(address,0,7);
        GridPane.setConstraints(dateOfBirth,0,8);

        gridPane.getChildren().addAll(hBox,father,mother,mobile,classNo,roll,hall,address,dateOfBirth);

        HBox hBox1=new HBox(900);
        hBox1.setPadding(new Insets(10,10,30,60));

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
            SecondPage.display();
            stage.close();
        });
        exit.setOnAction(e->{
            Platform.exit();
        });

        hBox1.getChildren().addAll(back,exit);

        VBox vBox=new VBox();
        vBox.setPadding(new Insets(15,15,15,15));
        ImageView imageView1=new ImageView(new Image("admissionForm.jpg"));
        imageView1.setFitWidth(250);
        imageView1.setFitHeight(300);
        vBox.getChildren().addAll(imageView1);

        BorderPane borderPane= new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox1);
        borderPane.setLeft(vBox);

        Scene scene=new Scene(borderPane,1300,700);
        stage.setScene(scene);
        stage.show();

    }
}
