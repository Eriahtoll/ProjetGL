package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer un bouton
        Button btn = new Button();
        btn.setText("Cliquez-moi !");
        btn.setOnAction(event -> System.out.println("Bonjour, JavaFX !"));

        // Ajouter le bouton dans un layout
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Créer la scène
        Scene scene = new Scene(root, 300, 250);

        // Configurer la fenêtre (Stage)
        primaryStage.setTitle("Mon Application JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}