package at.campus02.pegelverwaltung;

// umschalt + F6 => Namensänderungen
public class WasserstandDemo {

    public static void main(String[] args) {
        Wasserstand w1 = new Wasserstand(1,
                "Mur",
                6.0,
                8.0,
                100_000);

        Wasserstand w2 = new Wasserstand(2,
                "Mur",
                4.5,
                8.0,
                120_000);

        Wasserstand w3 = new Wasserstand(3,
                "Donau",
                7.0,
                14.0,
                110_000);

        Wasserstand w4 = new Wasserstand(4,
                "Donau",
                15.0,
                14.0,
                120_000);

        System.out.println("w1 = " + w1);
        System.out.println("w2 = " + w2);

        WasserstandManager wasserstandManager = new WasserstandManager();
        wasserstandManager.add(w1);
        wasserstandManager.add(w2);

    }
}
