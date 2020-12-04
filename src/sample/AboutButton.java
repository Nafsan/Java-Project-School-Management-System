package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AboutButton {
    public static void display(){
        Stage stage=new Stage();
        StackPane stackPane=new StackPane();
        ImageView imageView=new ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().addAll(imageView);

        StringBuilder msg = new StringBuilder();
        Label label = new Label();
        label.setText("Charles Babbage Residential School was founded in 1987, to satisfy the need for an " +
                "authentic international school in Dhaka. It had a very humble beginning with a rented" +"\n"+
                " two-storied building for a school, just off the main road near Dhanmondi Lake. Since" +
                " then the school has grown in terms of its student population, range of subjects taught" +"\n"+
                " and lecturing staff. The School now has five campuses situated in several locations in" +
                " the city including Dhanmondi, Gulshan, Uttara and Banasree. At present, there are " +"\n"+
                "approximately 2500 students and 250 teachers with an international student body and" +
                " teaching faculty.\n" +
                "\n" +
                "OIS is a registered school with the University of Cambridge International Examinations," +
                " UK and Edexcel, UK. Today, the students of OIS are recognized both nationally and " +"\n"+
                "internationally, for achieving high academic scores in GCE O and A Level examinations." +
                " We take great pride in saying that a number of our students have received Outstanding " +"\n"+
                "Cambridge Learner Awards by gaining highest standard mark in a particular subject both" +
                " around the world as well as in the country. The school has achieved an excellent " +"\n"+
                "standing within the community and is an associate member of the Round Square " +
                "Organizations of International Schools. We have been consistently rated ‘satisfactory’ " +"\n"+
                "by the educational consultants from the University of Cambridge Local Examination " +
                "Syndicate (UCLES) for upholding and maintaining our international standard of education." +"\n"+
                "\n" +
                "Over the years, the school has changed and developed significantly, and yet it has still" +
                " retained its fundamental characteristics. Many of its core ideas and beliefs are still" +"\n"+
                " to be found in the way they are run today. OIS continues to be one of the prominent " +
                "English medium schools in Bangladesh and is wholeheartedly committed to ensuring the " +"\n"+
                "best educational experience for all our students."+"\n");


        label.setFont(Font.font("Bell MT",16));

        Button exit=new Button("Exit");
        exit.setMaxHeight(50);
        exit.setMaxWidth(100);
        exit.setOnAction(e->{
            Platform.exit();
        });
        exit.setAlignment(Pos.BASELINE_LEFT);
        ImageView exitIcon=new ImageView(new Image("exitFirstPage.jpg"));
        exit.setGraphic(exitIcon);
        exit.setFont(Font.font("Bell MT", FontWeight.BOLD,18));





        HBox hBox=new HBox();
        hBox.getChildren().addAll(exit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(15,30,30,30));

        VBox vBox = new VBox(1);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(label);
        BorderPane borderPane=new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);
        Scene scene=new Scene(borderPane,1300,700);
        stage.setScene(scene);
        stage.show();


    }
}
