package Code.View;

import javafx.scene.layout.GridPane;

public class Buttons extends javafx.scene.control.Button {

    public Buttons(String nom) {
        super(nom);
        this.setStyle(
                "-fx-background-color: black; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 20px; " +
                        "-fx-font-weight: bold;"
        );
        this.setPrefSize(100,100);
    }


    }





