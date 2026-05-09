package teste;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import modele.InginerMecanic;
import modele.VehiculMilitar;

class InginerMecanicTest {

    // =========================
    // TEST 1: Inspectie vehicul - combustibil mic
    // =========================
    @Test
    void test_inspecteazaVehicul_cu_combustibil_redus() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.setNivelCombustibil(5);

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        boolean rezultat = inginer.inspecteazaVehicul(vehicul);

        assertFalse(rezultat);
        assertEquals("Necesita Mentenanta", vehicul.getStare());
    }

    // =========================
    // TEST 2: Inspectie vehicul - OK
    // =========================
    @Test
    void test_inspecteazaVehicul_ok() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.setNivelCombustibil(50);

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        boolean rezultat = inginer.inspecteazaVehicul(vehicul);

        assertTrue(rezultat);
        assertEquals("Disponibil", vehicul.getStare());
    }

    // =========================
    // TEST 3: Inregistrare mentenanta (fara verificare servicii)
    // =========================
    @Test
    void test_inregistrare_mentenanta_fara_verificare() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.actualizareStare("OK");

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        inginer.inregistreazaMentenanta(vehicul, "revizie");

        assertEquals("In Mentenanta", vehicul.getStare());
    }

    // =========================
    // TEST 4: Verificare servicii mentenanta (extend - TRUE)
    // =========================
    @Test
    void test_verifica_servicii_permis() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.actualizareStare("OK");

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        boolean rezultat =
                inginer.verificaServiciiMentenanta(vehicul);

        assertTrue(rezultat);
    }

    // =========================
    // TEST 5: Verificare servicii mentenanta (extend - FALSE)
    // =========================
    @Test
    void test_verifica_servicii_blocat() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.actualizareStare("In Mentenanta");

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        boolean rezultat =
                inginer.verificaServiciiMentenanta(vehicul);

        assertFalse(rezultat);
    }

    // =========================
    // TEST 6: Flux complet - inregistrare + extend
    // =========================
    @Test
    void test_flux_complet_mentenanta() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.actualizareStare("OK");

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        inginer.inregistreazaMentenanta(vehicul, "revizie");

        assertEquals("In Mentenanta", vehicul.getStare());
    }

    // =========================
    // TEST 7: Flux complet inspectie + mentenanta
    // =========================
    @Test
    void test_flux_integrat() {

        VehiculMilitar vehicul = new VehiculMilitar();
        vehicul.setNivelCombustibil(5);

        InginerMecanic inginer =
                new InginerMecanic("M1", "1", "Popescu", "Mecanic");

        boolean inspectie = inginer.inspecteazaVehicul(vehicul);

        if (!inspectie) {
            inginer.inregistreazaMentenanta(vehicul, "reparatie");
        }

        assertEquals("In Mentenanta", vehicul.getStare());
    }
}