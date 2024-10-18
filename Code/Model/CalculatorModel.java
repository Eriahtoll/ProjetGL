package Code.Model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack Pile = new Stack();
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

    }

    @Override
    public void divide() {

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

    }

    @Override
    public void swap() {

    }

    @Override
    public void clear() {
        Pile.clear();

    }
}
