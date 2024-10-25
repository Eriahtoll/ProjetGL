package Code.View;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventDispatchChain;
import javafx.scene.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

import java.util.Stack;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
    private Button button;
    private Stage stage;
    public CalculatorGUI(Stage stage) {
        this.stage = stage;
        affiche();
    }

    // Méthode affiche() qui configure l'interface graphique
    public void affiche() {
        stage.setTitle("Calculatrice");

        // Créer un conteneur de base pour les éléments graphiques
        VBox VboxPrincipal= new VBox();

        // Créer une scène avec le pane et des dimensions de 400x400
        Scene scene = new Scene(VboxPrincipal, 600, 400);

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
    


}
