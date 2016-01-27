import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.*;
 
public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    } // main
    
    @Override
    public void start(Stage primaryStage) {

        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("project-3.fxml"));
            root.getStylesheets().clear();
            root.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        } // try

        primaryStage.setTitle("Programmer's Calculator");
        primaryStage.setScene(new Scene(root, 396, 464));
        primaryStage.show();

    } // start

} // Driver
