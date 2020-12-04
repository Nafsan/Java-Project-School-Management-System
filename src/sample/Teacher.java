package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

import java.io.IOException;

public class Teacher {
    String name;
    String designation;
    String education;
    String contactNo;
    String email;
    Hall tutor;
    Date joiningDate;
    ImageView pic;

    Button button;

    int serialNo;

    public Teacher() {
        name = "";
        designation = "";
        education = "";
        education = "";
        contactNo = "";
        email = "";
        tutor = new Hall();
        joiningDate = new Date();
        initButton();
    }

    public Teacher(String name, String designation, String education, String contactNo, String email, Hall tutor, Date joiningDate) {
        this.name = name;
        this.designation = designation;
        this.education = education;
        this.contactNo = contactNo;
        this.email = email;
        this.tutor = tutor;
        this.joiningDate = joiningDate;
        initButton();
    }

    private void initButton() {
        button = new Button("Info");
        button.setGraphic(new ImageView(new Image("info.jpg")));
        button.setOnAction(e -> display());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Hall getTutor() {
        return tutor;
    }

    public void setTutor(Hall tutor) {
        this.tutor = tutor;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public ImageView getPic() {
        return pic;
    }

    public void setPic(ImageView pic) {
        this.pic = pic;
    }

    public String toString() {
        return  "Name: " + name + "\n" +
                "Designation " + designation + "\n" +
                "Tutor At: " + tutor + "\n" +
                "Education: " + education + "\n" +
                "Contact No: " + contactNo + "\n" +
                "Email: " + email;
    }

    public void display() {
        Stage now = new Stage();
        now.setTitle("Profile");
        now.initModality(Modality.APPLICATION_MODAL);

        pic.setFitWidth(300);
        pic.setFitHeight(400);

        StackPane sp = new StackPane();
        sp.getChildren().add(pic);
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

        lb = new Label("Designation ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + designation);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 1);
        GridPane.setConstraints(lbName, 1, 1);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Education ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + education);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 2);
        GridPane.setConstraints(lbName, 1, 2);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Contact No ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + contactNo);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 3);
        GridPane.setConstraints(lbName, 1, 3);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Email ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + email);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 4);
        GridPane.setConstraints(lbName, 1, 4);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("House Tutor at ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + tutor);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 5);
        GridPane.setConstraints(lbName, 1, 5);
        grid.getChildren().addAll(lb, lbName);

        lb = new Label("Joining Date ");
        lb.setFont(Font.font(Font.getDefault().toString(), FontWeight.BOLD, 20));
        lbName = new Text(":   " + joiningDate);
        lbName.setFont(Font.font("Bell MT", 20));

        GridPane.setConstraints(lb, 0, 6);
        GridPane.setConstraints(lbName, 1, 6);
        grid.getChildren().addAll(lb, lbName);

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
