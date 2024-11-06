package Code.Model;

import Code.Controler.CalculatorControlerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> Pile = new Stack();
    private String accu = new String();
    private CalculatorControlerInterface calculatorControler;

    public CalculatorModel(CalculatorControlerInterface calculatorControler) {
        this.calculatorControler = calculatorControler;
    }
    @Override
    public void add() {
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = (double) Pile.pop();
                accu = String.valueOf(numAccu + operande1);
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = (double) Pile.pop();
                double operande2 = (double) Pile.pop();
                accu = String.valueOf(operande2 + operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("ERREUR VALEUR");
        }

        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void substract() {
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = (double) Pile.pop();
                accu = String.valueOf(operande1 - numAccu);
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = (double) Pile.pop();
                double operande2 = (double) Pile.pop();
                accu = String.valueOf(operande2 - operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("ERREUR VALEUR");
        }

        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void multiply() {
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = (double) Pile.pop();
                accu = String.valueOf(operande1 * numAccu);
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = (double) Pile.pop();
                double operande2 = (double) Pile.pop();
                accu = String.valueOf(operande2 * operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("ERREUR VALEUR");
        }

        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void divide() {
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = (double) Pile.pop();
                if (numAccu != 0) {
                    accu = String.valueOf(operande1 / numAccu);
                } else {
                    calculatorControler.changeaccu("DIVISION PAR 0");
                }
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = (double) Pile.pop();
                double operande2 = (double) Pile.pop();
                if (operande1 != 0) {
                    accu = String.valueOf(operande2 / operande1);
                } else {
                    calculatorControler.changeaccu("DIVISION PAR 0");
                }
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("ERREUR VALEUR");
        }

        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void opposite() {
        try {
            if (!accu.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                accu = String.valueOf(-1 * numAccu);
            } else if (!Pile.isEmpty()) {
                double operande1 = -1 * (double) Pile.pop();
                Pile.push(operande1);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("ERREUR VALEUR");
        }

        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void push() {
        if (accu != null && !accu.isEmpty()) {
            try {
                double numberaccu = Double.parseDouble(accu);
                Pile.push(numberaccu);
                List<Double> stackdata = new ArrayList<>(Pile);
                calculatorControler.changestack(stackdata);
                accu = "";
                calculatorControler.changeaccu(accu);
            } catch (NumberFormatException e) {
                calculatorControler.changeaccu("ERREUR VALEUR");
            }
        } else {
            calculatorControler.changeaccu("ACCUMULATEUR VIDE");
        }
    }


    @Override
    public double pop() {
        if(!Pile.isEmpty()){
        return (double) Pile.pop();}
        return 0;

    }

    @Override
    public void drop() {
        if (!Pile.isEmpty()) {
            Pile.pop();
        }
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void swap() {
        try {
            if (!accu.isEmpty() && !Pile.isEmpty()) {
                double numAccu = Double.parseDouble(accu);
                double operande1 = (double) Pile.pop();
                accu = String.valueOf(operande1);
                Pile.push(numAccu);
            } else if (accu.isEmpty() && Pile.size() > 1) {
                double operande1 = (double) Pile.pop();
                double operande2 = (double) Pile.pop();
                Pile.push(operande1);
                Pile.push(operande2);
            }
        } catch (NumberFormatException e) {
            calculatorControler.changeaccu("ERREUR VALEUR");
        }

        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);
        calculatorControler.changeaccu(accu);
    }

    @Override
    public void clear() {
        Pile.clear();
        accu = "";
        calculatorControler.changeaccu(accu);
        List<Double> stackdata = new ArrayList<>(Pile);
        calculatorControler.changestack(stackdata);

    }

    @Override
    public void setaccu(String text) {
        accu = text;
        calculatorControler.changeaccu(accu);
    }

    @Override
    public String getaccu() {
        return accu;
    }
}
