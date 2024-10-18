package Code;

import Code.Model.CalculatorModel;


public class Main {

    public static void main(String[] args) {
        // Création d'une instance du modèle de calculatrice
        CalculatorModel calculator = new CalculatorModel();

        // Test de l'ajout
        calculator.push(2);
        calculator.push(3);
        calculator.add();
        System.out.println("Résultat après addition (2 + 3): " + calculator.pop());  // Devrait afficher 5

        // Test de la soustraction
        calculator.push(10);
        calculator.push(3);
        calculator.substract();
        System.out.println("Résultat après soustraction (10 - 3): " + calculator.pop());  // Devrait afficher 7

        // Test de la multiplication
        calculator.push(4);
        calculator.push(5);
        calculator.multiply();
        System.out.println("Résultat après multiplication (4 * 5): " + calculator.pop());  // Devrait afficher 20

        // Test de la division
        calculator.push(20);
        calculator.push(4);
        calculator.divide();
        System.out.println("Résultat après division (20 / 4): " + calculator.pop());  // Devrait afficher 5

        // Test de la division par zéro
        calculator.push(10);
        calculator.push(0);
        calculator.divide();  // Devrait afficher un message d'erreur pour la division par zéro
        System.out.println("Résultat après tentative de division par zéro: " + calculator.pop());  // Devrait afficher 10, car la division n'a pas eu lieu

        // Test de la méthode swap
        calculator.push(1);
        calculator.push(2);
        calculator.swap();
        System.out.println("Résultat après swap: ");
        System.out.println("Sommet de la pile (devrait être 1): " + calculator.pop());  // Devrait afficher 1
        System.out.println("Deuxième élément (devrait être 2): " + calculator.pop());  // Devrait afficher 2

        // Test de la méthode drop
        calculator.push(15);
        calculator.push(25);
        calculator.drop();
        System.out.println("Résultat après drop (devrait être 15): " + calculator.pop());  // Devrait afficher 15

        // Test de la méthode clear
        calculator.push(100);
        calculator.push(200);
        calculator.clear();
        System.out.println("Résultat après clear (devrait être vide): " + (calculator.pop()));  // Devrait afficher 0, car la pile est vide
    }
}
