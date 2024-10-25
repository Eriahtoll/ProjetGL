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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

import java.util.Stack;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
    Buttons button1 = new Buttons("1");
    Buttons button2 = new Buttons("2");
    Buttons button3 = new Buttons("3");
    Buttons button4 = new Buttons("4");
    Buttons button5 = new Buttons("5");
    Buttons button6 = new Buttons("6");
    Buttons button7 = new Buttons("7");
    Buttons button8 = new Buttons("8");
    Buttons button9 = new Buttons("9");
    Buttons button0 = new Buttons("0");
    Buttons buttonPLUS = new Buttons("+");
    Buttons buttonMOINS = new Buttons("-");
    Buttons buttonFOIS = new Buttons("*");
    Buttons buttonDIVIS = new Buttons("/");
    Buttons buttonENT = new Buttons("<>");
    Buttons buttonDEL = new Buttons("DEL");
    Buttons buttonCLEAR = new Buttons("AC");
    Buttons buttonVIRG = new Buttons(",");
    Buttons buttonSWAP = new Buttons("<=>");

    GridPane tom = new GridPane();





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
