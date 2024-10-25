package Code.Controler;

import Code.Model.CalculatorModelInterface;
import Code.View.CalculatorGUIInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Stack;

public class CalculatorControler implements CalculatorControlerInterface, EventHandler<ActionEvent> {
private CalculatorGUIInterface calculatorGUI;
private CalculatorModelInterface calculatorModel;

    public CalculatorControler(CalculatorGUIInterface calculatorGUI, CalculatorModelInterface calculatorModel) {
        this.calculatorGUI = calculatorGUI;
        this.calculatorModel = calculatorModel;
    }

    @Override
    public void changestack(Stack Pile) {

    }

    @Override
    public void changeaccu(String Accu) {

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("HELLO");
    }
}
