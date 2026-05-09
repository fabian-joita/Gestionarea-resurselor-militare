package modele;

public class InginerMecanic extends Utilizator {

    private String specializare;

    private boolean mentenantaInregistrata;
    private boolean serviciiVerificate;

    public InginerMecanic(String memberName,
                          String idUtilizator,
                          String nume,
                          String specializare) {

        super(memberName, idUtilizator, nume, "Inginer Mecanic");
        this.specializare = specializare;
    }

    public boolean inspecteazaVehicul(VehiculMilitar vehicul) {

        if (vehicul.getNivelCombustibil() < 10) {
            vehicul.actualizareStare("Necesita Mentenanta");
            return false;
        }

        vehicul.actualizareStare("Disponibil");
        return true;
    }

    public void inregistreazaMentenanta(VehiculMilitar vehicul,
                                        String operatie) {

        vehicul.actualizareStare("In Mentenanta");
        mentenantaInregistrata = true;

        if (verificaServiciiMentenanta(vehicul)) {
            serviciiVerificate = true;
        }
    }

    public boolean verificaServiciiMentenanta(VehiculMilitar vehicul) {

        if ("In Mentenanta".equals(vehicul.getStare())) {
            return false;
        }

        return true;
    }

    public boolean isMentenantaInregistrata() {
        return mentenantaInregistrata;
    }

    public boolean isServiciiVerificate() {
        return serviciiVerificate;
    }
}