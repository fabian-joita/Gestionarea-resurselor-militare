package teste;

import modele.InginerMecanic;
import modele.VehiculMilitar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnitarAlexandrescuRaresjava { // <-- Am corectat numele clasei aici

    private InginerMecanic inginer;
    private VehiculMilitar vehicul;

    @BeforeEach
    void setUp() {
        // Initializam un inginer si un vehicul de test inainte de fiecare scenariu
        inginer = new InginerMecanic("ing_01", "U100", "Andrei", "Tancuri");
        vehicul = new VehiculMilitar("V-01", "TR-85", 50.0, "Disponibil");
    }

    // =======================================================================================
    // 1. FORTAREA EXCEPTIILOR (Am inlocuit rolul cu validarea datelor nule)
    // =======================================================================================
    @Test
    void testInregistreazaMentenanta_ExceptieDacaVehicululEsteNull() {
        // ACT & ASSERT: Verificam ca sistemul arunca exceptie daca nu ii dam un vehicul valid
        assertThrows(NullPointerException.class, () -> {
            inginer.inregistreazaMentenanta(null, "Schimbare ulei");
        }, "Sistemul ar trebui sa arunce NullPointerException daca vehiculul trimis este null!");
    }

    // =======================================================================================
    // 2. TESTE PARAMETRIZATE - LIMITE INFERIOARE/SUPERIOARE (Boundary Testing)
    // =======================================================================================
    @ParameterizedTest(name = "Test Combustibil={0} -> Rezultat asteptat={1}, Stare={2}")
    @CsvSource({
            "5.0,  false, Necesita Mentenanta",  // Limita inferioara (Sub prag)
            "9.9,  false, Necesita Mentenanta",  // Fix sub pragul decizional
            "10.0, true,  Disponibil",           // Limita exacta (Boundary Value)
            "10.1, true,  Disponibil",           // Fix peste prag
            "100.0, true, Disponibil"            // Valoare nomala/superioara
    })
    void testInspecteazaVehicul_ValoriLimita(double combustibil, boolean rezultatAsteptat, String stareAsteptata) {
        // Setam nivelul de combustibil din tabelul CsvSource
        vehicul.setNivelCombustibil((int) combustibil);

        // Apelam metoda
        boolean rezultat = inginer.inspecteazaVehicul(vehicul);

        // Validam outputul metodei si modificarea starii vehiculului
        assertEquals(rezultatAsteptat, rezultat);
        assertEquals(stareAsteptata, vehicul.getStare());
    }

    // =======================================================================================
    // 3. COMPLEXITATEA SCENARIULUI DIN DIAGRAMA (Happy Path + Ramura de <<extend>>)
    // =======================================================================================
    @Test
    void testScenariuMentenanta_CuExtend() {
        // ARRANGE: Setam starea initiala
        vehicul.actualizareStare("Defect");

        // VERIFICARE INITIALA (Demonstram ca nu e doar de forma)
        assertEquals("Defect", vehicul.getStare(), "Verificare initiala: Vehiculul trebuie sa fie defect inainte de a incepe.");
        assertFalse(inginer.isMentenantaInregistrata(), "Verificare initiala: Mentenanta nu trebuie sa fie deja inregistrata.");

        // ACT: Executam fluxul principal
        inginer.inregistreazaMentenanta(vehicul, "Reparatie motor");

        // ASSERT: Verificam starea FINALA (S-a modificat pe bune!)
        assertTrue(inginer.isServiciiVerificate(), "<<extend>> trebuia sa fie parcurs!");
        assertTrue(inginer.isMentenantaInregistrata(), "Mentenanta de baza a fost finalizata!");
        assertEquals("In Mentenanta", vehicul.getStare(), "Starea vehiculului s-a schimbat cu succes la final!");
    }

    // =======================================================================================
    // 4. COMPLEXITATE - RAMURA ALTERNATIVA (Ocolirea <<extend>>-ului)
    // =======================================================================================
    @Test
    void testScenariuMentenanta_FaraExtend() {
        // ARRANGE: Setam starea initiala
        vehicul.actualizareStare("In Mentenanta");

        // VERIFICARE INITIALA
        assertEquals("In Mentenanta", vehicul.getStare(), "Vehiculul este deja in mentenanta.");

        // ACT
        inginer.inregistreazaMentenanta(vehicul, "Continuare reparatii");

        // ASSERT: Validam ocolirea ramurii si ca starea a ramas corecta
        assertFalse(inginer.isServiciiVerificate(), "Ramura <<extend>> trebuia ocolita.");
        assertTrue(inginer.isMentenantaInregistrata());
        assertEquals("In Mentenanta", vehicul.getStare(), "Starea trebuie sa ramana In Mentenanta.");
    }
}