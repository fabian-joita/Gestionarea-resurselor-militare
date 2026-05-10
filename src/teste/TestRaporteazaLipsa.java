package teste;

import modele.Comandant;
import modele.OperatorLogistic;

import org.junit.Assert;
import org.junit.Test;

public class TestRaporteazaLipsa {

    @Test
    public void testRaporteazaLipsaTrimiteNotificareComandantului() {

        OperatorLogistic operator =
                new OperatorLogistic(
                        "OP",
                        "ID05",
                        "Ionescu"
                );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID04",
                        "Popescu",
                        "Colonel"
                );

        operator.raporteazaLipsa(
                "Munitie",
                comandant
        );

        Assert.assertEquals(
                1,
                comandant.getNotificari().size()
        );

        Assert.assertEquals(
                "Lipsa resursa: Munitie raportata de Ionescu",
                comandant.getNotificari().get(0)
        );
    }

    @Test
    public void testRaporteazaLipsaCuMaiMulteSeturiDeDate() {

        String[][] dateTestare = {
                {
                        "Munitie",
                        "Lipsa resursa: Munitie raportata de Ionescu"
                },
                {
                        "Combustibil",
                        "Lipsa resursa: Combustibil raportata de Ionescu"
                },
                {
                        "Echipament medical",
                        "Lipsa resursa: Echipament medical raportata de Ionescu"
                },
                {
                        "Piese schimb",
                        "Lipsa resursa: Piese schimb raportata de Ionescu"
                }
        };

        for (String[] setDate : dateTestare) {

            String resursaRaportata = setDate[0];
            String mesajAsteptat = setDate[1];

            OperatorLogistic operator =
                    new OperatorLogistic(
                            "OP",
                            "ID05",
                            "Ionescu"
                    );

            Comandant comandant =
                    new Comandant(
                            "CMD",
                            "ID04",
                            "Popescu",
                            "Colonel"
                    );

            operator.raporteazaLipsa(
                    resursaRaportata,
                    comandant
            );

            Assert.assertEquals(
                    1,
                    comandant.getNotificari().size()
            );

            Assert.assertEquals(
                    mesajAsteptat,
                    comandant.getNotificari().get(0)
            );
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResursaGoala() {

        OperatorLogistic operator =
                new OperatorLogistic(
                        "OP",
                        "ID05",
                        "Ionescu"
                );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID04",
                        "Popescu",
                        "Colonel"
                );

        operator.raporteazaLipsa(
                "",
                comandant
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResursaNull() {

        OperatorLogistic operator =
                new OperatorLogistic(
                        "OP",
                        "ID05",
                        "Ionescu"
                );

        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID04",
                        "Popescu",
                        "Colonel"
                );

        operator.raporteazaLipsa(
                null,
                comandant
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComandantNull() {

        OperatorLogistic operator =
                new OperatorLogistic(
                        "OP",
                        "ID05",
                        "Ionescu"
                );

        operator.raporteazaLipsa(
                "Munitie",
                null
        );
    }
}