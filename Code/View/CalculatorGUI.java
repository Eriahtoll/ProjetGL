package Code.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class CalculatorGUI implements CalculatorGUIInterface {
    // Création des boutons

    private Stage stage;

    public CalculatorGUI(Stage stage) {
        this.stage = stage;
        affiche();
    }

    // Méthode affiche() qui configure l'interface graphique
    public void affiche() {
        stage.setTitle("Calculatrice");

        GridPane gridPane = new GridPane();
        VBox vBoxPrincipal = new VBox();
        VBox vBoxEcran = new VBox();



        vBoxPrincipal.getChildren().add(vBoxEcran);
        vBoxPrincipal.getChildren().add(gridPane);

        // Créer une scène avec le VBox et des dimensions de 600x400
        Scene scene = new Scene(vBoxPrincipal, 600, 800);

        // Définir la scène sur le stage et afficher la fenêtre
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void changeaccu(String accu) {

    }

    @Override
    public void changestack(Stack Pile) {

    }

    // Méthode pour configurer le GridPane avec les boutons

}
