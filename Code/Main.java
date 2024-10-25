package Code;

import Code.View.CalculatorGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer l'interface graphique via CalculatorGUI
        CalculatorGUI calculatorGUI = new CalculatorGUI(primaryStage);
    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}
