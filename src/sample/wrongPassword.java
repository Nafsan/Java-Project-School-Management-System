package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class wrongPassword {
    public static void warning(){
        Stage stage=new Stage();
        stage.setTitle("Wrong password");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(300);
        stage.setMinHeight(100);
        stage.setX(500);
        stage.setY(300);

        Label label=new Label("You have entered wrong password");
        Button exitBtn = new Button("Ok");
        exitBtn.setMinWidth(60);
        exitBtn.setOnAction(e -> {
            //Platform.exit();
            stage.close();
        });
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(label,exitBtn);
        Scene scene=new Scene(vBox,300,100);
        stage.setScene(scene);
        //scene.getStylesheets().add("background.css");
        stage.showAndWait();
    }
}
