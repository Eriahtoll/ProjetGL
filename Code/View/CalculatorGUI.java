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

// Classe CalculatorGUI implémente l'interface CalculatorGUIInterface
// Cette classe configure l'interface graphique de la calculatrice et gère l'affichage des boutons, de l'écran et des étiquettes
public class CalculatorGUI implements CalculatorGUIInterface {

    // Tableau de chaînes de caractères pour les étiquettes de chaque bouton
    String[] buttonLabels = {
            "0", "1", "2",
            "3", "4", "5",
            "6", "7", "8",
            "9",
            "+", "-", "*",
            "/", "ENTER", "DEL",
            "AC", ".", "SWAP",
            "+/-"
    };

    // Tableau d'objets Buttons pour stocker chaque bouton de l'interface
    Buttons[] buttons = new Buttons[buttonLabels.length];

    // Tableau de positions pour placer chaque bouton sur la grille
    int[][] buttonPositions = {
            {1, 3}, {0, 2}, {1, 2}, {2, 2},
            {0, 1}, {1, 1}, {2, 1},
            {0, 0}, {1, 0}, {2, 0},
            {3, 0}, {3, 1}, {3, 2},
            {3, 3}, {4, 2}, {4, 1},
            {4, 0}, {2, 3}, {4, 3}, {0, 3}
    };

    // Tableau de labels pour afficher la pile et l'accumulateur
    Label[] labels = new Label[8];

    // Contrôleur pour gérer les actions des boutons
    CalculatorControler controler;

    // Fenêtre principale de l'application
    private Stage stage;

    // Grille pour disposer les boutons
    GridPane clavier = new GridPane();

    // Constructeur de CalculatorGUI
    // Initialise la fenêtre et le contrôleur (pour pouvoir lui transmettre la detection des listeners) , puis appelle la méthode d'affichage
    public CalculatorGUI(Stage stage, CalculatorControler controler) {
        this.stage = stage;
        this.controler = controler;
        affiche();
    }

    // Méthode affiche() qui configure l'interface graphique
    public void affiche() {
        // Définit le titre de la fenêtre
        stage.setTitle("Calculatrice");

        // Boucle pour créer et positionner chaque bouton dans la grille
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new Buttons(buttonLabels[i]);       // Crée un bouton avec l'étiquette correspondante
            buttons[i].setId(buttonLabels[i]);               // Définit l'ID du bouton pour l'identification dans les événements utile pour le switch case du handle
            buttons[i].addEventHandler(ActionEvent.ACTION, controler); // Associe chaque bouton au contrôleur d'événements
            clavier.add(buttons[i], buttonPositions[i][0], buttonPositions[i][1]); // Ajoute le bouton à la grille aux positions indiquées
        }

        // Crée un VBox pour afficher les labels (l'écran de la calculatrice)
        VBox ecran = new VBox();
        ecran.setPrefSize(500, 400);

        // Boucle pour créer chaque label dans l'écran
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label("");                         // Initialise un label vide
            styleLabel(labels[i], 500, 50);                    // Applique les styles définis dans la méthode styleLabel ci dessous
            ecran.getChildren().add(labels[i]);                // Ajoute chaque label au VBox d'affichage
        }

        labels[labels.length - 1].setStyle(
                "-fx-padding: 0 10 0 0;" +
                        "-fx-border-color: grey;" +
                        "-fx-border-width: 1;" +
                        "-fx-font-size: 30;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-insets: 0;");


        // Définit le style de la grille de boutons (fond noir)
        clavier.setStyle("-fx-background-color: black;");

        // Crée un VBox principal pour contenir l'écran et le clavier
        VBox vBoxPrincipal = new VBox();
        vBoxPrincipal.getChildren().add(ecran);               // Ajoute l'écran à l'interface
        vBoxPrincipal.getChildren().add(clavier);             // Ajoute le clavier à l'interface

        // Crée une scène avec le VBox principal et définit les dimensions de la fenêtre
        Scene scene = new Scene(vBoxPrincipal, 500, 800);

        // Définit la scène sur le stage et affiche la fenêtre
        stage.setScene(scene);
        stage.show();
    }

    // Méthode pour appliquer les styles aux labels
    private void styleLabel(Label label, int width, int height) {
        label.setPrefSize(width, height);                     // Définit les dimensions du label
        label.setAlignment(Pos.CENTER_RIGHT);                 // Aligne le texte à droite
        label.setStyle(
                "-fx-padding: 0 10 0 0;" +                   // Ajoute un padding de 10px à droite
                        "-fx-border-color: grey;" +                  // Définit une bordure grise
                        "-fx-border-width: 1;" +
                        "-fx-font-size: 30;" +
                        "-fx-border-insets: 0;"                       // Position de la bordure par rapport au label
        );
    }

    // Implémentation de la méthode changeaccu pour mettre à jour l'affichage de l'accumulateur
    @Override
    public void changeaccu(String accu) {
        labels[labels.length - 1].setText(accu);              // Modifie le dernier label pour afficher l'accumulateur
    }

    // Implémentation de la méthode changestack pour mettre à jour l'affichage de la pile de calcul
    @Override
    public void changestack(List<Double> stackdata) {
        // Si le nombre d'éléments de la pile dépasse le nombre de labels, remplit les labels disponibles
        if (labels.length - 1 < stackdata.size()) {
            for (int i = 0; i < labels.length - 1; i++) {
                labels[labels.length - i - 2].setText(String.valueOf(stackdata.get(stackdata.size() - i - 1)));
            }
        } else {
            // Sinon, met à jour les labels avec les valeurs de la pile, en laissant les autres vides
            for (int i = 0; i < stackdata.size(); i++) {
                labels[labels.length - i - 2].setText(String.valueOf(stackdata.get(stackdata.size() - i - 1)));
            }
            for (int i = 0; i < labels.length - 1 - stackdata.size(); i++) {
                labels[i].setText(""); // Vide les labels restants
            }
        }
    }
}
