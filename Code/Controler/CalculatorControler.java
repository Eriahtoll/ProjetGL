package Code.Controler;

import Code.Model.CalculatorModelInterface;
import Code.View.Buttons;
import Code.View.CalculatorGUIInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;
import java.util.Stack;

public class CalculatorControler implements CalculatorControlerInterface, EventHandler<ActionEvent> {
private CalculatorGUIInterface calculatorGUI;
private CalculatorModelInterface calculatorModel;

    public CalculatorControler() {;
    }

    public void setCalculatorGUI(CalculatorGUIInterface calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
    }

    public void setCalculatorModel(CalculatorModelInterface calculatorModel) {
        this.calculatorModel = calculatorModel;
    }

    @Override
    public void changestack(List<Double> stackdata) {
        calculatorGUI.changestack(stackdata);

    }

    @Override
    public void changeaccu(String accu) {
        calculatorGUI.changeaccu(accu);

    }

    public void handle(ActionEvent event) {
            // Utilisez un switch en fonction de l'ID du bouton
            Buttons source = (Buttons) event.getSource();
            String accu = calculatorModel.getaccu();
            switch (source.getId()) {
                case "0":
                    calculatorModel.setaccu(accu + "0");
                    break;

                case "1":
                    calculatorModel.setaccu(accu + "1");
                    break;
                case "2":
                    calculatorModel.setaccu(accu +"2");
                    break;

                case "3":
                    calculatorModel.setaccu(accu +"3");
                    break;
                case "4":
                    calculatorModel.setaccu(accu +"4");
                    break;

                case "5":
                    calculatorModel.setaccu(accu +"5");
                    break;
                case "6":
                    calculatorModel.setaccu(accu +"6");
                    break;

                case "7":
                    calculatorModel.setaccu(accu +"7");
                    break;
                case "8":
                    calculatorModel.setaccu(accu +"8");
                    break;

                case "9":
                    calculatorModel.setaccu(accu + "9");
                    break;

                case "+":
                    calculatorModel.add();
                    break;

                case "-":
                    calculatorModel.divide();
                    break;
                case "*":
                    calculatorModel.multiply();
                    break;

                case "/":
                    calculatorModel.divide();
                    break;

                case "ENTER":
                    if(!accu.isEmpty()){
                    calculatorModel.push();}
                    break;

                case "DEL":
                    if (!accu.isEmpty()){
                        calculatorModel.setaccu(accu.substring(0,accu.length()-1));
                    }
                    else{
                        calculatorModel.drop();
                    }
                    break;

                case "AC":
                    calculatorModel.clear();
                    break;

                case ".":
                    calculatorModel.setaccu(accu +".");
                    break;
                case "SWAP":
                    calculatorModel.swap();
                    break;

                case "+/-":
                    calculatorModel.opposite();
                    break;

                // Ajoutez d'autres cas pour d'autres boutons
                default:
                    System.out.println("Bouton non reconnu");
                    break;
            }
        }


}
