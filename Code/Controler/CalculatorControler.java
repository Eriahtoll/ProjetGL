package Code.Controler;

import Code.Model.CalculatorModelInterface;
import Code.View.Buttons;
import Code.View.CalculatorGUIInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;
import java.util.Stack;

// Classe CalculatorControler implémente les interfaces CalculatorControlerInterface et EventHandler<ActionEvent>
// Cette classe gère les interactions entre l'interface graphique (CalculatorGUI) et le modèle de calcul (CalculatorModel)
public class CalculatorControler implements CalculatorControlerInterface, EventHandler<ActionEvent> {

    // Référence à l'interface graphique de la calculatrice nécessaire pour appeler ses fonctions
    private CalculatorGUIInterface calculatorGUI;

    // Référence au modèle de calcul de la calculatrice nécessaire pour appeler ses fonctions
    private CalculatorModelInterface calculatorModel;

    // Constructeur par défaut de la classe CalculatorControler
    public CalculatorControler() {
    }

    // Méthode pour définir l'interface graphique utilisée par le contrôleur
    //Nous ne mettons pas les attribut dans le constructeur car le modele est d'abord pris par le model et la view pour fonctionner, nous les settons donc après
    public void setCalculatorGUI(CalculatorGUIInterface calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
    }

    // Méthode pour définir le modèle de calcul utilisé par le contrôleur
    public void setCalculatorModel(CalculatorModelInterface calculatorModel) {
        this.calculatorModel = calculatorModel;
    }

    // Implémentation de la méthode changestack, pour mettre à jour l'affichage de la pile dans l'interface graphique
    @Override
    public void changestack(List<Double> stackdata) {
        calculatorGUI.changestack(stackdata);
    }

    // Implémentation de la méthode changeaccu, pour mettre à jour l'affichage de l'accumulateur dans l'interface graphique
    @Override
    public void changeaccu(String accu) {
        calculatorGUI.changeaccu(accu);
    }

    // Méthode pour gérer les événements d'action (ActionEvent), activée lors d'appuis sur les boutons de la calculatrice
    public void handle(ActionEvent event) {
        // Récupère la source de l'événement et l'identifie comme un bouton de la calculatrice
        Buttons source = (Buttons) event.getSource();

        // Récupère la valeur actuelle de l'accumulateur
        String accu = calculatorModel.getaccu();

        // Utilise un switch pour gérer le comportement en fonction de l'ID du bouton
        switch (source.getId()) {
            case "0":
                calculatorModel.setaccu(accu + "0"); // Ajoute "0" à l'accumulateur
                break;
            case "1":
                calculatorModel.setaccu(accu + "1"); // Ajoute "1" à l'accumulateur
                break;
            case "2":
                calculatorModel.setaccu(accu + "2"); // Ajoute "2" à l'accumulateur
                break;
            case "3":
                calculatorModel.setaccu(accu + "3"); // Ajoute "3" à l'accumulateur
                break;
            case "4":
                calculatorModel.setaccu(accu + "4"); // Ajoute "4" à l'accumulateur
                break;
            case "5":
                calculatorModel.setaccu(accu + "5"); // Ajoute "5" à l'accumulateur
                break;
            case "6":
                calculatorModel.setaccu(accu + "6"); // Ajoute "6" à l'accumulateur
                break;
            case "7":
                calculatorModel.setaccu(accu + "7"); // Ajoute "7" à l'accumulateur
                break;
            case "8":
                calculatorModel.setaccu(accu + "8"); // Ajoute "8" à l'accumulateur
                break;
            case "9":
                calculatorModel.setaccu(accu + "9"); // Ajoute "9" à l'accumulateur
                break;
            case "+":
                calculatorModel.add(); // Appelle la méthode d'addition du modèle
                break;
            case "-":
                calculatorModel.substract(); // Appelle la méthode de soustraction du modèle
                break;
            case "*":
                calculatorModel.multiply(); // Appelle la méthode de multiplication du modèle
                break;
            case "/":
                calculatorModel.divide(); // Appelle la méthode de division du modèle
                break;
            case "ENTER":
                calculatorModel.push(); // Pousse l'accumulateur sur la pile
                break;
            case "DEL":
                // Vérifie si l'accumulateur n'est pas vide avant de supprimer le dernier caractère
                if (!accu.isEmpty()) {
                    calculatorModel.setaccu(accu.substring(0, accu.length() - 1));
                } else {
                    calculatorModel.drop(); // Sinon, retire le dernier élément de la pile
                }
                break;
            case "AC":
                calculatorModel.clear(); // Réinitialise la calculatrice
                break;
            case ".":
                calculatorModel.setaccu(accu + "."); // Ajoute un point décimal
                break;
            case "SWAP":
                calculatorModel.swap(); // Permute les deux premiers éléments de la pile
                break;
            case "+/-":
                calculatorModel.opposite(); // Inverse le signe de l'accumulateur
                break;
            default:
                System.out.println("Bouton non reconnu"); // Affiche un message pour un bouton non pris en charge
                break;
        }
    }
}
