package Code.Controler;

public interface CalculatorControlerInterface {
    public double add(double valeur1,double valeur2);
    public double substract(double valeur1,double valeur2);
    public double multiply(double valeur1,double valeur2);
    public double divide(double valeur1,double valeur2);
    public double opposite(double valeur1);
    public void push();
    public void pop();
    public void drop();
    public void swap();
    public void clear();
}
