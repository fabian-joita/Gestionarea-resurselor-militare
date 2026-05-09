package teste;

import modele.*;

import org.junit.Assert;
import org.junit.Test;

public class TestAprobareDecizieLogistica {

    @Test
    public void testMisiuneAprobataCuResurseComplete() {

        BazaMilitara baza =
                new BazaMilitara(
                        "Baza NATO",
                        "Constanta"
                );

        baza.adaugaVehiculInInventar(
                "V1",
                "Transportor",
                60,
                "Disponibil"
        );

        baza.adaugaArmament(
                "A1",
                "Tun",
                120,
                "Functional"
        );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID01",
                        "Popescu",
                        "Colonel"
                );

        boolean rezultat =
                comandant.aprobareDecizieLogistica(
                        baza
                );

        Assert.assertTrue(rezultat);
    }

    @Test
    public void testMisiuneRespinsaFaraVehicule() {

        BazaMilitara baza =
                new BazaMilitara(
                        "Baza Sud",
                        "Bucuresti"
                );

        baza.adaugaArmament(
                "A2",
                "Mitraliere",
                50,
                "Functional"
        );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID02",
                        "Ionescu",
                        "Maior"
                );

        boolean rezultat =
                comandant.aprobareDecizieLogistica(
                        baza
                );

        Assert.assertFalse(rezultat);
    }

    @Test
    public void testRealimentareVehicule() {

        BazaMilitara baza =
                new BazaMilitara(
                        "Baza Vest",
                        "Cluj"
                );

        baza.adaugaVehiculInInventar(
                "V2",
                "Transportor",
                10,
                "Disponibil"
        );

        baza.adaugaArmament(
                "A3",
                "Tun",
                100,
                "Functional"
        );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID03",
                        "Georgescu",
                        "Colonel"
                );

        boolean rezultat =
                comandant.aprobareDecizieLogistica(
                        baza
                );

        Assert.assertTrue(rezultat);

        Assert.assertTrue(
                baza.confirmareRealimentare()
        );
    }

    @Test
    public void testVehiculeDefecte() {

        BazaMilitara baza =
                new BazaMilitara(
                        "Baza Est",
                        "Iasi"
                );

        baza.adaugaVehiculInInventar(
                "V3",
                "Camion Militar",
                5,
                "Indisponibil_Lipsa_Combustibil"
        );

        Assert.assertEquals(
                1,
                baza.getVehiculDefecte().size()
        );
    }

    @Test
    public void testListaVehiculeGoala() {

        BazaMilitara baza =
                new BazaMilitara(
                        "Baza Test",
                        "Brasov"
                );

        Assert.assertEquals(
                0,
                baza.getVehiculDisponibile().size()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptieCombustibilNegativ() {

        VehiculMilitar vehicul =
                new VehiculMilitar(
                        "V10",
                        "Transportor",
                        50,
                        "Disponibil"
                );

        vehicul.alimenteaza(-20);
    }

    @Test
    public void testScenariuComplexLogisticaMilitara() {

        BazaMilitara baza =
                new BazaMilitara(
                        "Baza Centrala",
                        "Constanta"
                );

        baza.adaugaVehiculInInventar(
                "V1",
                "Transportor",
                5,
                "Disponibil"
        );

        baza.adaugaVehiculInInventar(
                "V2",
                "Camion Militar",
                60,
                "Disponibil"
        );

        baza.adaugaVehiculInInventar(
                "V3",
                "Jeep Militar",
                0,
                "Indisponibil_Lipsa_Combustibil"
        );

        baza.adaugaArmament(
                "A1",
                "Tun",
                120,
                "Functional"
        );

        baza.adaugaArmament(
                "A2",
                "Mitraliere",
                50,
                "Defect"
        );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID04",
                        "Popescu",
                        "Colonel"
                );

        OperatorLogistic operator =
                new OperatorLogistic(
                        "OP",
                        "ID05",
                        "Ionescu"
                );

        InginerMecanic inginer =
                new InginerMecanic(
                        "ING",
                        "ID06",
                        "Georgescu",
                        "Motoare"
                );

        operator.raporteazaLipsa(
                "Munitie",
                comandant
        );

        VehiculMilitar vehiculDefect =
                baza.getVehiculDefecte().get(0);

        boolean inspectie =
                inginer.inspecteazaVehicul(
                        vehiculDefect
                );

        Assert.assertFalse(inspectie);

        boolean rezultat =
                comandant.aprobareDecizieLogistica(
                        baza
                );

        Assert.assertTrue(rezultat);

        Assert.assertTrue(
                baza.confirmareRealimentare()
        );

        Assert.assertEquals(
                1,
                baza.getVehiculDefecte().size()
        );

        Assert.assertEquals(
                2,
                baza.getVehiculDisponibile().size()
        );
    }
}