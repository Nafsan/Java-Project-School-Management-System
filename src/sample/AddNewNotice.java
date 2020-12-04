package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AddNewNotice {
    public static void display()  {
        Stage stage=new Stage();
        VBox vBox=new VBox(10);
        vBox.setPadding(new Insets(40,10,10,10));

        File file=new File("Notice Board.txt");

        StackPane stackPane=new StackPane();
        ImageView imageView=new ImageView(new Image("Capture.jpg"));
        stackPane.getChildren().addAll(imageView);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(vBox);
        borderPane.setTop(stackPane);

        TextArea textField=new TextArea();
        textField.setPromptText("Add your Title");
        textField.setFont(Font.font("Bell MT", FontWeight.BOLD,25));
        textField.setMaxWidth(600);
        textField.setMaxHeight(50);

        TextArea description=new TextArea();
        description.setPromptText("Description");
        description.setFont(Font.font("Bell MT",19));
        description.setMaxWidth(600);
        description.setMinHeight(200);
        //description.setAlignment(Pos.TOP_LEFT);

        Button add=new Button("Add");
        add.setFont(Font.font("Bell MT",16));
        add.setMinWidth(70);


        add.setOnAction(e->{
           // stage.close();
            Notice notice;
            Hyperlink hyperlink;
            String des;
            try {

                hyperlink  =new Hyperlink(textField.getText());
                String str2 = description.getText();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                writer.write(hyperlink.getText()+"\n"+str2);
                notice=new Notice(hyperlink,str2);
                writer.close();
            }catch (IOException f){
                f.printStackTrace();
            }
            Notice not = new Notice();
            not.display();
            stage.close();
        });


        vBox.getChildren().addAll(textField,description,add);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(borderPane,1300,700);
        stage.setScene(scene);
        stage.show();
    }
}
