package Code.View;

import Code.Controler.CalculatorControler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Stack;

public class CalculatorGUI implements CalculatorGUIInterface {
    // Création des boutons
    String[] buttonLabels = {
            "0", "1", "2",
            "3", "4", "5",
            "6", "7", "8",
            "9",
            "+", "-","*",
            "/", "ENTER", "DEL",
            "AC", ".", "SWAP",
            "+/-"};
    Buttons[] buttons = new Buttons[buttonLabels.length];
    int[][] buttonPositions = {
            {1, 3}, {0, 2}, {1, 2}, {2, 2},  // bouton 0, 1, 2, 3
            {0, 1}, {1, 1}, {2, 1},          // boutons 4, 5, 6
            {0, 0}, {1, 0}, {2, 0},          // boutons 7, 8, 9
            {3, 0}, {3, 1}, {3, 2},          // boutons PLUS, MOINS, FOIS
            {3, 3}, {4, 2}, {4, 1},          // boutons DIVIS, ENTER, DEL
            {4, 0}, {2, 3}, {4, 3},{0,3}          // boutons CLEAR, VIRG, SWAP
    };
    Label[] labels = new Label[8];
    CalculatorControler controler;

    private Stage stage;

    GridPane clavier = new GridPane();




    public CalculatorGUI(Stage stage, CalculatorControler controler) {
        this.stage = stage;
        this.controler = controler;
        affiche();
    }

    // Méthode affiche() qui configure l'interface graphique
    public void affiche() {
        stage.setTitle("Calculatrice");

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new Buttons(buttonLabels[i]);
            buttons[i].setId(buttonLabels[i]);
            buttons[i].addEventHandler(ActionEvent.ACTION, controler);
            clavier.add(buttons[i], buttonPositions[i][0], buttonPositions[i][1]);
        }



        VBox ecran = new VBox();
        ecran.setPrefSize(500, 400);

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label("");
            styleLabel(labels[i], 500, 50);
            ecran.getChildren().add(labels[i]);
        }

        clavier.setStyle("-fx-background-color: black;");

        VBox vBoxPrincipal = new VBox();
        vBoxPrincipal.getChildren().add(ecran);
        vBoxPrincipal.getChildren().add(clavier);

        // Créer une scène avec le VBox et des dimensions de 600x400
        Scene scene = new Scene(vBoxPrincipal, 500, 800);

        // Définir la scène sur le stage et afficher la fenêtre
        stage.setScene(scene);
        stage.show();
    }

    // Méthode pour appliquer les styles aux labels
    private void styleLabel(Label label, int width, int height) {
        label.setPrefSize(width, height);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setStyle(
                "-fx-padding: 0 10 0 0;" +           // Ajout de 10px de padding à droite
                        "-fx-border-color: grey;" +          // Couleur de la bordure
                        "-fx-border-width: 1;" +
                        " -fx-font-size: 30;"+
                        "-fx-border-insets: 0;"               // Position de la bordure par rapport au label
        );
    }

    @Override
    public void changeaccu(String accu) {
        labels[labels.length - 1].setText(accu);
    }

    @Override
    public void changestack(List<Double> stackdata) {
        if (labels.length-1 < stackdata.size()) {
            for (int i = 0; i < labels.length-1; i++) {
                labels[labels.length - i - 2].setText(String.valueOf(stackdata.get(stackdata.size()-i-1)));
            }
        }

        else {
            for (int i = 0; i < stackdata.size(); i++) {
            labels[labels.length - i - 2].setText(String.valueOf(stackdata.get(stackdata.size()-i-1)));

            }
            for(int i=0; i<labels.length-1-stackdata.size(); i++) {
                labels[i].setText("");
            }
        }
    }

}
