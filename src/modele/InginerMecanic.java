package modele;

public class InginerMecanic extends Utilizator {

    private String specializare;

    public InginerMecanic(String memberName,
                          String idUtilizator,
                          String nume,
                          String specializare) {

        super(memberName,
                idUtilizator,
                nume,
                "Inginer Mecanic");

        this.specializare = specializare;
    }

    public boolean inspecteazaVehicul(
            VehiculMilitar vehicul) {

        System.out.println(
                "Se efectueaza inspectia tehnica...");

        if ("Indisponibil_Lipsa_Combustibil"
                .equals(vehicul.getStare())) {

            vehicul.actualizareStare(
                    "Necesita Mentenanta");

            return false;
        }

        vehicul.actualizareStare(
                "Disponibil");

        return true;
    }

    public void inregistreazaMentenanta(VehiculMilitar vehicul,
                                        String operatie) {

        vehicul.actualizareStare(
                "In Mentenanta");

        System.out.println(
                "Mentenanta inregistrata: "
                        + operatie);
    }

    public boolean verificaServiciiMentenanta(
            VehiculMilitar vehicul) {

        System.out.println(
                "Verificare servicii mentenanta...");

        if ("In Mentenanta".equals(
                vehicul.getStare())) {

            return false;
        }

        return true;
    }
}