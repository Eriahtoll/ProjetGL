package Code.View;

import javafx.scene.layout.GridPane;

public class Buttons extends javafx.scene.control.Button {

    public Buttons(String nom) {
        super(nom);
        String originalStyle = "-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;";
        String clickedStyle = "-fx-background-color: grey; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;";

        this.setStyle(originalStyle);
        this.setPrefSize(100, 100);

        // Définir l'événement de changement de couleur lors du clic
        this.setOnMousePressed(event -> this.setStyle(clickedStyle));

        // Restaurer la couleur d'origine au relâchement du clic
        this.setOnMouseReleased(event -> this.setStyle(originalStyle));
    }

}
