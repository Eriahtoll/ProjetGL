package Code.Model;

import Code.Controler.CalculatorControlerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {

    private Stack<Double> Pile = new Stack<>();

    private String accu = "";


    private CalculatorControlerInterface calculatorControler;

    // Constructeur qui prend en paramètre le contrôleur
    public CalculatorModel(CalculatorControlerInterface calculatorControler) {
        this.calculatorControler = calculatorControler;
    }

    @Override
    public void add() { // Méthode pour l'addition
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                // Si l'accumulateur et la pile ne sont pas vides, on additionne les deux
                double numAccu = Double.parseDouble(accu); //On transforme en Double la valeur de l'accu
                double operande1 = Pile.pop(); //Récupération de la dernier valeur de la pile
                accu = String.valueOf(numAccu + operande1); // On ajoute les 2 valeurs dans l'accumulateur
            } else if (accu.isEmpty() && Pile.size() > 1) {
                // Si l'accumulateur est vide, on additionne les deux dernières valeurs de la pile
                double operande1 = Pile.pop();
                double operande2 = Pile.pop();
                accu = String.valueOf(operande2 + operande1); // On ajoute les 2 valeurs dans l'accumulateur
            }
        } catch (NumberFormatException e) {
            // Si l'accumulateur ne contient pas unnombre du format "Double"
            calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
        }

        // Mise à jour de  l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void substract() { // Méthode pour la soustraction
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = Pile.pop();
                accu = String.valueOf(operande1 - numAccu);
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = Pile.pop();
                double operande2 = Pile.pop();
                accu = String.valueOf(operande2 - operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
        }

        // Mise à jour de l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void multiply() { // Méthode pour la multiplication
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = Pile.pop();
                accu = String.valueOf(operande1 * numAccu);
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = Pile.pop();
                double operande2 = Pile.pop();
                accu = String.valueOf(operande2 * operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
        }

        // Met à jour l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void divide() { // Méthode pour la division
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = Pile.pop();
                if (numAccu != 0) {
                    // Permet de s'assurer que l'opperation n'est pas une dévision par 0
                    accu = String.valueOf(operande1 / numAccu);
                } else {
                    calculatorControler.changeaccu("DIVISION PAR 0");
                }
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = Pile.pop();
                double operande2 = Pile.pop();
                if (operande1 != 0) {
                    accu = String.valueOf(operande2 / operande1);
                } else {
                    calculatorControler.changeaccu("DIVISION PAR 0");
                }
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
        }

        // Met à jour l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void opposite() { // Méthode pour inverser le signe
        try {
            if (!accu.isEmpty()) {
                // Si l'accumulateur est vide, on inverse la derniere valeur de la pile
                double numAccu = Double.parseDouble(accu);
                accu = String.valueOf(-1 * numAccu);
            } else if (!Pile.isEmpty()) {
                //. Si l'accumulateur contient une valeur, on l'inverse
                double operande1 = -1 * Pile.pop();
                Pile.push(operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
        }

        // Mise à jour de l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void push() { // Méthode pour empiler la valeur de l'accumulateur dans la pile
        if (!accu.isEmpty()) { // On vérifie que l'accumulateur n'est pas vide
            try {
                double numberaccu = Double.parseDouble(accu);
                Pile.push(numberaccu);
                accu = ""; //On vide l'accumulateur après avoir transfére la valeur dans la pile
                // Mise a jour de  l'interface
                List<Double> stackdata = new ArrayList<>(Pile);
                calculatorControler.changestack(stackdata);
                calculatorControler.changeaccu(accu);
            } catch (NumberFormatException e) {
                calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
            }
        } else {
            calculatorControler.changeaccu("ACCUMULATEUR VIDE");
        }
    }

    @Override
    public double pop() { // Méthode pour dépiler la dernière valeur de la pile
        if (!Pile.isEmpty()) {
            return Pile.pop();
        }
        return 0;
    }

    @Override
    public void drop() { // Méthode pour supprimer la dernière valeur de la pile
        if (!Pile.isEmpty()) {
            Pile.pop();
        }
        // Mise à jour de l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void swap() { // Méthode pour échanger l'accumulateur et le sommet de la pile
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) { // Si l'accu n'est pas vide, on inverse la derniere valeur de la pile avec l'accu
                double numAccu = Double.parseDouble(accu);
                double operande1 = Pile.pop();
                accu = String.valueOf(operande1); // l'accumulateur récupere la derniere valeur de la pile
                Pile.push(numAccu); //La pile recois la valeur de l'accumulateur
            } else if (accu.isEmpty() && Pile.size() > 1) { //Si l'accu est vide, on inverse les 2 dernères valeurs de la pile
                double operande1 = Pile.pop();
                double operande2 = Pile.pop();
                Pile.push(operande1);
                Pile.push(operande2);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("IMPOSSIBLE FORMAT NOMBRE INVALIDE");
        }

        // Mise à jour de  l'interface
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void clear() { // Méthode pour vider la pile et l'accumulateur
        Pile.clear();
        accu = "";

        // Mise à jour de l'interface
        calculatorControler.changeaccu(accu);
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
    }


    @Override
    public void setaccu(String text) { //Setter Accu
        accu = text;
        calculatorControler.changeaccu(accu);
    }

    @Override
    public String getaccu() {  // Getter Accu
        return accu;
    }
}
