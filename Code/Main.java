package Code;

import Code.Controler.CalculatorControler;
import Code.Controler.CalculatorControlerInterface;
import Code.Model.CalculatorModel;
import Code.Model.CalculatorModelInterface;
import Code.View.CalculatorGUI;
import Code.View.CalculatorGUIInterface;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer l'interface graphique via CalculatorGUI
        CalculatorControler calculatorControler = new CalculatorControler();
        CalculatorGUIInterface calculatorGUI = new CalculatorGUI(primaryStage, calculatorControler);
        CalculatorModel calculatorModel = new CalculatorModel(calculatorControler);
        calculatorControler.setCalculatorGUI(calculatorGUI);
        calculatorControler.setCalculatorModel(calculatorModel);
        System.out.println(4);


    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}
