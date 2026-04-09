package teste;

import modele.*;
import org.junit.Assert;
import org.junit.Test;

public class TestUnitarJoitaFabian {

    @Test
    public void testPolimorfismVehicule() {
        BazaMilitara baza = new BazaMilitara("Baza Nord");

        // Adaugam un Tanc (prag 50) si o Moto (prag 5) cu aceeasi cantitate: 10.0
        baza.adaugaVehiculInInventar("T-01", "Tanc", 10.0, "Necunoscut");
        baza.adaugaVehiculInInventar("M-01", "Motocicleta", 10.0, "Necunoscut");

        VehiculMilitar tanc = baza.getToateVehiculele().get(0);
        VehiculMilitar moto = baza.getToateVehiculele().get(1);

        tanc.actualizareStare("Disponibil");
        moto.actualizareStare("Disponibil");

        // Tancul pica (10 < 50), Moto trece (10 > 5)
        Assert.assertEquals("Indisponibil_Lipsa_Combustibil", tanc.getStare());
        Assert.assertEquals("Disponibil", moto.getStare());
    }
}