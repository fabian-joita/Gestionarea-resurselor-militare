// Clasa care implementeaza relatia <<include>> din diagrama de utilizare
package modele;

public class OperatorLogistic extends Utilizator {
    public OperatorLogistic(String memberName, String idUtilizator, String nume) {
        super(memberName, idUtilizator, nume, "Operator Logistic");
    }

    // Aceasta metoda include obligatoriu notificarea comandantului (relatia include)
    public void raporteazaLipsa(BazaMilitara baza, String item, Comandant cmd) {
        System.out.println("Operatorul inregistreaza lipsa: " + item);

        // Relatia <<include>>: Notificarea este automata si obligatorie
        cmd.primesteNotificare("Lipsa resursa: " + item + " raportata de " + this.nume);
    }
}