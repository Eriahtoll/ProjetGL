package Code.Model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> Pile = new Stack();
    public CalculatorModel() {
    }
    @Override
    public void add() {
        if(Pile.size()>1){
            double operande1 = (double) Pile.poo();
            double operande2 = (double) Pile.pop();
            Pile.push(operande2 + operande1);
        }

    }

    @Override
    public void substract() {
        if(Pile.size()>1){
            double operande1 = (double) Pile.poo();
            double operande2 = (double) Pile.pop();
            Pile.push(operande2 - operande1);

    }

    @Override
    public void multiply() {
        if (Pile.size() >= 2) {
            double value1 = Pile.pop();
            double value2 = Pile.pop();

            double result = value1 * value2;

            Pile.push(result);
        } else {
            System.out.println("La pile contient moins de deux éléments");
        }
    }
    @Override
    public void divide() {
        if (Pile.size() >= 2) {
            Double value1 = Pile.pop();
            Double value2 = Pile.pop();

            if (value1 != 0) {
                Double result = value2 / value1;
                Pile.push(result);
            } else {
                Pile.push(value2);
                Pile.push(value1);
                System.out.println("Impossible de diviser par zéro.");
            }
        } else {
            System.out.println("La pile contient moins de deux éléments");
        }
    }

    @Override
    public void opposite() {

    }

    @Override
    public void push(double num) {
        Pile.push(num);

    }

    @Override
    public double pop() {
        if(!Pile.isEmpty()){
        return (double) Pile.pop();}
        return 0;
    }

    @Override
    public void drop() {
        if (Pile.size() >= 1) {
            Pile.pop();
        } else {
            System.out.println("La pile est vide");
    }

    @Override
    public void swap() {
        if (Pile.size() >= 2) {
            double value1 = Pile.pop();
            double value2 = Pile.pop();
            Pile.push(value1);
            Pile.push(value2);
        } else {
            System.out.println("La pile contient moins de deux éléments");
        }
    }

    @Override
    public void clear() {
        Pile.clear();

    }
}
