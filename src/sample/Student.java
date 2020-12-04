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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Student {

    String name;
    String fatherName;
    String motherName;

    String guardianMobileNo;

    int ClassNo, classRoll;
    Hall res;

    String address;

    Date birth;

    int serialNo;

    Button info;

    public Student() {
        name = "";
        fatherName = "";
        motherName = "";
        guardianMobileNo = "";
        ClassNo = 0;
        classRoll = 0;
        address = "";
        birth = new Date();
        info = new Button("Info");
        initButton();
    }

    public Student(String name, String fatherName, String motherName,
                   int classNo, int classRoll, String guardianMobileNo,
                   String address, Date birth, Hall res) {
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        ClassNo = classNo;
        this.classRoll = classRoll;
        this.res = res;
        this.address = address;
        this.birth = birth;
        this.guardianMobileNo = guardianMobileNo;
        initButton();
    }

    public Student(String name, int classNo, int classRoll) {
        this.name = name;
        ClassNo = classNo;
        this.classRoll = classRoll;
        this.birth = birth;
        initButton();
    }

    public void initButton() {
        info = new Button("");
        info.setMinWidth(50);
        info.setGraphic(new ImageView(new Image("info.jpg")));
        info.setOnAction(e -> {
            display();

        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGuardianMobileNo() {
        return guardianMobileNo;
    }

    public void setGuardianMobileNo(String guardianMobileNo) {
        this.guardianMobileNo = guardianMobileNo;
    }

    public int getClassNo() {
        return ClassNo;
    }

    public void setClassNo(int classNo) {
        ClassNo = classNo;
    }

    public int getClassRoll() {
        return classRoll;
    }

    public void setClassRoll(int classRoll) {
        this.classRoll = classRoll;
    }

    public Hall getRes() {
        return res;
    }

    public void setRes(Hall res) {
        this.res = res;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Button getInfo() {
        return info;
    }

    public void setInfo(Button info) {
        this.info = info;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "Father's Name: " + fatherName + "\n" +
                "Mother's Name: " + motherName + "\n" +
                "Guardian Mobile No: " + guardianMobileNo + "\n" +
                "Class: " + ClassNo + "\n" +
                "Class Roll: " + classRoll + "\n" +
                "Hall: " + res +
                "Address: " + address + "\n" +
                "Date of Birth: " + birth;
    }

    public void display() {
        Stage now = new Stage();
        now.initModality(Modality.APPLICATION_MODAL);
        now.setTitle("Profile");

        ImageView imv = new ImageView(new Image("pic.jpg"));
        imv.setFitWidth(300);
        imv.setFitHeight(325);

        StackPane sp = new StackPane();
        sp.getChildren().add(imv);
        sp.setAlignment(Pos.CENTER);
        sp.setStyle("-fx-background-color: rgba(111, 111, 111, 0.5);");

        HBox hb;
        Label lb;
        Text lbName;
        VBox vb = new VBox(10);
        vb.getChildren().addAll(sp);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);

        hb = new HBox(10);

        lb = new Label("Name ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + name);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 0);
        GridPane.setConstraints(lbName, 1, 0);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Father's Name ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + fatherName);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 1);
        GridPane.setConstraints(lbName, 1, 1);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Mother's Name ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + motherName);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 2);
        GridPane.setConstraints(lbName, 1, 2);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Guardian Mobile No ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + guardianMobileNo);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 3);
        GridPane.setConstraints(lbName, 1, 3);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Class ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + ClassNo);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 4);
        GridPane.setConstraints(lbName, 1, 4);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Roll ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + classRoll);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 5);
        GridPane.setConstraints(lbName, 1, 5);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Hostel ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + res.getName());
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 6);
        GridPane.setConstraints(lbName, 1, 6);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Address ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + address);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 7);
        GridPane.setConstraints(lbName, 1, 7);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Date of Birth ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + birth.toString());
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 8);
        GridPane.setConstraints(lbName, 1, 8);
        grid.getChildren().addAll(lb, lbName);
        grid.setStyle("-fx-background-color: rgba(222, 222, 222, 0.5);");

        vb.getChildren().add(grid);
        vb.setAlignment(Pos.CENTER);

        Button exit = new Button("Exit");
        exit.setOnAction(e -> now.close());
        vb.getChildren().add(exit);

        Scene scene = new Scene(vb, 1300, 700);
        now.setScene(scene);
        now.show();
    }
}
