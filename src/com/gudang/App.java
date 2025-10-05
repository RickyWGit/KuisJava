package com.gudang;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            primaryStage.setTitle("Login - Aplikasi Gudang");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Error: Tidak dapat memuat file FXML atau CSS. Periksa path Anda.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

