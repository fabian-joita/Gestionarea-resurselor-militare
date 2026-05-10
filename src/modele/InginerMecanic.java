package modele;

public class InginerMecanic extends Utilizator {

    private String specializare;
    private boolean mentenantaInregistrata;
    private boolean serviciiVerificate;

    public InginerMecanic(String memberName, String idUtilizator, String nume, String specializare) {
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

    public void inregistreazaMentenanta(VehiculMilitar vehicul, String operatie) {
        if (verificaServiciiMentenanta(vehicul)) {
            serviciiVerificate = true;
            System.out.println("<<extend>> S-au verificat si asociat serviciile de mentenanta.");
        } else {
            serviciiVerificate = false;
        }

        vehicul.actualizareStare("In Mentenanta");
        mentenantaInregistrata = true;
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