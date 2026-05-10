package teste;

import modele.Armament;

import org.junit.Assert;
import org.junit.Test;

public class TestActualizareStareArmament {

    // Cazul 1: stare setata la "Functional"
    // → verificaStoc() returneaza true
    @Test
    public void testActualizareStareFunctionala() {

        Armament armament =
                new Armament(
                        "A1",
                        "Tun",
                        120,
                        "Defect"
                );

        armament.actualizareStare("Functional");

        Assert.assertEquals(
                "Functional",
                armament.getStare()
        );

        Assert.assertTrue(
                armament.verificaStoc()
        );
    }

    // Cazul 2: stare setata la "Defect"
    // → verificaStoc() returneaza false
    @Test
    public void testActualizareStareDefecta() {

        Armament armament =
                new Armament(
                        "A2",
                        "Pusca",
                        7.62,
                        "Functional"
                );

        armament.actualizareStare("Defect");

        Assert.assertEquals(
                "Defect",
                armament.getStare()
        );

        Assert.assertFalse(
                armament.verificaStoc()
        );
    }

    // Cazul 3: stare initiala "Functional" fara actualizare
    // → verificaStoc() returneaza true din start
    @Test
    public void testStareInitialFunctionala() {

        Armament armament =
                new Armament(
                        "A3",
                        "Mitraliera",
                        50,
                        "Functional"
                );

        Assert.assertTrue(
                armament.verificaStoc()
        );
    }

    // Cazul 4: actualizare multipla a starii
    // → ultima stare conteaza
    @Test
    public void testActualizareStareMultipla() {

        Armament armament =
                new Armament(
                        "A4",
                        "Obuzier",
                        155,
                        "Defect"
                );

        armament.actualizareStare("Functional");
        Assert.assertTrue(armament.verificaStoc());

        armament.actualizareStare("In Reparatie");
        Assert.assertFalse(armament.verificaStoc());

        armament.actualizareStare("Functional");
        Assert.assertTrue(armament.verificaStoc());
    }

    // Cazul 5: stare cu valoare diferita de "Functional"
    // → verificaStoc() returneaza false
    @Test
    public void testStareDiferitaDeFunctional() {

        Armament armament =
                new Armament(
                        "A5",
                        "Lansator",
                        40,
                        "Functional"
                );

        armament.actualizareStare("In Mentenanta");

        Assert.assertFalse(
                armament.verificaStoc()
        );
    }

    // Cazul 6: verificare atribute dupa constructie
    // → id, model, calibru sunt corecte
    @Test
    public void testAtributeArmament() {

        Armament armament =
                new Armament(
                        "A6",
                        "Tun Naval",
                        203,
                        "Functional"
                );

        Assert.assertEquals("A6", armament.getIdArmament());
        Assert.assertEquals("Tun Naval", armament.getModel());
        Assert.assertEquals(203, armament.getCalibru(), 0.001);
        Assert.assertEquals("Functional", armament.getStare());
    }
}