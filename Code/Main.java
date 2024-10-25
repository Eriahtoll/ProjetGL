package Code;

import Code.Controler.CalculatorControler;
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
        CalculatorGUIInterface calculatorGUI = new CalculatorGUI(primaryStage);
        CalculatorModelInterface calculatorModel = new CalculatorModel();
        CalculatorControler calculatorControler = new CalculatorControler(calculatorGUI, calculatorModel);

    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}
