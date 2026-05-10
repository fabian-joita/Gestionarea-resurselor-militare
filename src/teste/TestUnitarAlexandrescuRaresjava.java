package teste;

import modele.InginerMecanic;
import modele.VehiculMilitar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnitarAlexandrescuRaresjava {

    private InginerMecanic inginer;
    private VehiculMilitar vehicul;

    @BeforeEach
    void setUp() {
        inginer = new InginerMecanic("ing_01", "U100", "Andrei", "Tancuri");
        vehicul = new VehiculMilitar("V-01", "TR-85", 50.0, "Disponibil");
    }

    @Test
    void testInregistreazaMentenanta_ExceptieDacaVehicululEsteNull() {
        assertThrows(NullPointerException.class, () -> {
            inginer.inregistreazaMentenanta(null, "Schimbare ulei");
        }, "Sistemul ar trebui sa arunce NullPointerException daca vehiculul trimis este null!");
    }


    @ParameterizedTest(name = "Test Combustibil={0} -> Rezultat asteptat={1}, Stare={2}")
    @CsvSource({
            "5.0,  false, Necesita Mentenanta",
            "9.9,  false, Necesita Mentenanta",
            "10.0, true,  Disponibil",
            "10.1, true,  Disponibil",
            "100.0, true, Disponibil"
    })
    void testInspecteazaVehicul_ValoriLimita(double combustibil, boolean rezultatAsteptat, String stareAsteptata) {
        vehicul.setNivelCombustibil((int) combustibil);

        boolean rezultat = inginer.inspecteazaVehicul(vehicul);

        assertEquals(rezultatAsteptat, rezultat);
        assertEquals(stareAsteptata, vehicul.getStare());
    }

    @Test
    void testScenariuMentenanta_CuExtend() {
        vehicul.actualizareStare("Defect");

        assertEquals("Defect", vehicul.getStare(), "Verificare initiala: Vehiculul trebuie sa fie defect inainte de a incepe.");
        assertFalse(inginer.isMentenantaInregistrata(), "Verificare initiala: Mentenanta nu trebuie sa fie deja inregistrata.");

        inginer.inregistreazaMentenanta(vehicul, "Reparatie motor");

        assertTrue(inginer.isServiciiVerificate(), "<<extend>> trebuia sa fie parcurs!");
        assertTrue(inginer.isMentenantaInregistrata(), "Mentenanta de baza a fost finalizata!");
        assertEquals("In Mentenanta", vehicul.getStare(), "Starea vehiculului s-a schimbat cu succes la final!");
    }

    @Test
    void testScenariuMentenanta_FaraExtend() {
        vehicul.actualizareStare("In Mentenanta");

        assertEquals("In Mentenanta", vehicul.getStare(), "Vehiculul este deja in mentenanta.");

        inginer.inregistreazaMentenanta(vehicul, "Continuare reparatii");

        assertFalse(inginer.isServiciiVerificate(), "Ramura <<extend>> trebuia ocolita.");
        assertTrue(inginer.isMentenantaInregistrata());
        assertEquals("In Mentenanta", vehicul.getStare(), "Starea trebuie sa ramana In Mentenanta.");
    }
}