package Code.View;

import javafx.scene.layout.GridPane;

public class Buttons extends javafx.scene.control.Button {

    public Buttons(String nom) {
        super(nom);
        this.setStyle(
                "-fx-background-color: black; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold;"
        );
        this.setPrefSize(100,100);
    }
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

    }





