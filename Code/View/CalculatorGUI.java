package Code.View;

import Code.Controler.CalculatorControler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class CalculatorGUI implements CalculatorGUIInterface {
    // Création des boutons
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
    GridPane clavier = new GridPane();



    private Stage stage;
    public CalculatorGUI(Stage stage) {
        this.stage = stage;
        affiche();
    }

    // Méthode affiche() qui configure l'interface graphique
    public void affiche() {
        stage.setTitle("Calculatrice");
        clavier.add(button1, 0, 2);
        clavier.add(button2, 1, 2);
        clavier.add(button3, 2, 2);
        clavier.add(button4, 0, 1);
        clavier.add(button5, 1, 1);
        clavier.add(button6, 2, 1);
        clavier.add(button7, 0, 0);
        clavier.add(button8, 1, 0);
        clavier.add(button9, 2, 0);
        clavier.add(button0, 1, 3);
        clavier.add(buttonPLUS, 3, 0);
        clavier.add(buttonMOINS, 3, 1);
        clavier.add(buttonFOIS, 3, 2);
        clavier.add(buttonDIVIS, 3, 3);
        clavier.add(buttonENT, 4, 2);
        clavier.add(buttonDEL, 4, 1);
        clavier.add(buttonCLEAR, 4, 0);
        clavier.add(buttonVIRG, 2, 3);
        clavier.add(buttonSWAP, 4, 3);;
       buttonENT.addEventHandler(ActionEvent.ACTION, CalculatorControler);
        VBox ecran = new VBox();
        ecran.setPrefSize(500,400);
        VBox vBoxPrincipal = new VBox();
        VBox vBoxEcran = new VBox();



        vBoxPrincipal.getChildren().add(ecran);
        vBoxPrincipal.getChildren().add(clavier);

        // Créer une scène avec le VBox et des dimensions de 600x400
        Scene scene = new Scene(vBoxPrincipal, 500, 800);

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
